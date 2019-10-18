package com.lama.dal.service;

import com.lama.dal.entity.Order;
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

    public Optional<Order> findById(String id) {
        return orderRepository.findById(id);
    }

    public Order save(Order order) {
       return (Order) orderRepository.save(order);
    }

    public void deleteById(String id) {
        orderRepository.deleteById(id);
    }
}
