package com.lama.dal.service;

import com.lama.dal.entity.Buyer;
import com.lama.dal.error.EntityNotFoundException;
import com.lama.dal.repository.BuyerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    public Optional<Buyer> findById(String id) {
        Optional<Buyer> buyer = buyerRepository.findById(id);
        if (!buyer.isPresent()) {
            throw new EntityNotFoundException(Buyer.class, "id", id);
        }

        return buyer;
    }

    public Buyer update(String id, Buyer buyer) {
        if (!findById(id).isPresent()) {
            throw new EntityNotFoundException(Buyer.class, "id", id);
        }
        return buyerRepository.save(buyer);
    }

    public Buyer save(Buyer buyer) {
        return buyerRepository.save(buyer);
    }

    public void deleteById(String id) {
        if (!findById(id).isPresent()) {
            throw new EntityNotFoundException(Buyer.class, "id", id);
        }

        buyerRepository.deleteById(id);
    }
}
