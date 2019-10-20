package com.lama.dal.service;

import com.lama.dal.entity.Buyer;
import com.lama.dal.entity.Order;
import com.lama.dal.entity.Product;
import com.lama.dal.error.EntityNotFoundException;
import com.lama.dal.model.OrderItem;
import com.lama.dal.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderService {
    @Autowired
    private final OrderRepository orderRepository;
    private final BuyerService buyerService;
    private final ProductService productService;

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public boolean existsById(String id) {
        return orderRepository.existsById(id);
    }

    public Optional<Order> findById(String id) {
        Optional<Order> order = orderRepository.findById(id);
        if (!order.isPresent()) {
            throw new EntityNotFoundException(Order.class, "id", id);
        }

        return order;
    }

    public Order update(String id, Order order) {
        validateOrderItems(order);
        if (!existsById(id)) {
            throw new EntityNotFoundException(Order.class, "id", id);
        }
        order.setId(id);
        return orderRepository.save(order);
    }

    public Order save(Order order) {
        validateOrderItems(order);

        Buyer buyer = order.getBuyer();
        if (buyer == null || buyer.getId().isEmpty()) {
            throw new EntityNotFoundException(Buyer.class, "id", "Empty");
        }
        if (!buyerService.existsById(buyer.getId())) {
            throw new EntityNotFoundException(Buyer.class, "id", buyer.getId());
        }
        Order savedOrder = orderRepository.save(order);
        changeProductStatusOnOrder(order, savedOrder);
        return savedOrder;
    }

    public void deleteById(String id) {
        if (!existsById(id)) {
            throw new EntityNotFoundException(Order.class, "id", id);
        }

        orderRepository.deleteById(id);
    }

    private void validateOrderItems(Order order) {
        if (order.getOrderItems() == null || order.getOrderItems().isEmpty()) {
            throw new EntityNotFoundException(OrderItem.class, "id", "Empty");
        }

        order.getOrderItems().parallelStream().forEach(orderItem -> {
            Optional<Product> product = productService.findById(orderItem.getProduct().getId());
            if (product == null || product.get().getId().isEmpty() ||
                    !product.get().isListed()) {
                throw new EntityNotFoundException(OrderItem.class, "id", "Not available to order");
            }
        });
    }

    private void changeProductStatusOnOrder(Order order, Order savedOrder) {
        if (savedOrder != null && !savedOrder.getId().isEmpty() && existsById(savedOrder.getId())) {
            order.getOrderItems().parallelStream().forEach(orderItem -> {
                Optional<Product> product = productService.findById(orderItem.getProduct().getId());
                if (product != null && !product.get().getId().isEmpty()) {
                    product.get().setListed(false);
                    productService.save(product.get());
                }
            });
        }
    }
}
