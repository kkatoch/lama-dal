package com.lama.dal.service;

import com.lama.dal.entity.Order;
import com.lama.dal.error.EntityNotFoundException;
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
        if (!existsById(id)) {
            throw new EntityNotFoundException(Order.class, "id", id);
        }
        order.setId(id);
        return orderRepository.save(order);
    }

    public Order save(Order order) {
        return orderRepository.save(order);
    }

    public void deleteById(String id) {
        if (!existsById(id)) {
            throw new EntityNotFoundException(Order.class, "id", id);
        }

        orderRepository.deleteById(id);
    }
}
