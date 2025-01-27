package com.lama.dal.service;

import com.lama.dal.entity.Buyer;
import com.lama.dal.error.EntityNotFoundException;
import com.lama.dal.repository.BuyerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BuyerService {
    @Autowired
    private final BuyerRepository buyerRepository;

    public List<Buyer> findAll() {
        return buyerRepository.findAll();
    }

    public boolean existsById(String id) {
        return buyerRepository.existsById(id);
    }

    public Optional<Buyer> findById(String id) {
        Optional<Buyer> buyer = buyerRepository.findById(id);
        if (!buyer.isPresent()) {
            throw new EntityNotFoundException(Buyer.class, "id", id);
        }

        return buyer;
    }

    public Buyer update(String id, Buyer buyer) {
        if (!existsById(id)) {
            throw new EntityNotFoundException(Buyer.class, "id", id);
        }
        buyer.setId(id);
        return buyerRepository.save(buyer);
    }

    public Buyer save(Buyer buyer) {
        return buyerRepository.save(buyer);
    }

    public void deleteById(String id) {
        if (!existsById(id)) {
            throw new EntityNotFoundException(Buyer.class, "id", id);
        }

        buyerRepository.deleteById(id);
    }
}
