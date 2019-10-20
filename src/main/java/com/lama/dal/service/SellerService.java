package com.lama.dal.service;

import com.lama.dal.entity.Seller;
import com.lama.dal.error.EntityNotFoundException;
import com.lama.dal.repository.SellerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SellerService {
    @Autowired
    private final SellerRepository sellerRepository;

    public List<Seller> findAll() {
        return sellerRepository.findAll();
    }

    public boolean existsById(String id) {
        return sellerRepository.existsById(id);
    }

    public Optional<Seller> findById(String id) {
        Optional<Seller> seller = sellerRepository.findById(id);
        if (!seller.isPresent()) {
            throw new EntityNotFoundException(Seller.class, "id", id);
        }

        return seller;
    }

    public Seller update(String id, Seller seller) {
        if (!existsById(id)) {
            throw new EntityNotFoundException(Seller.class, "id", id);
        }
        seller.setId(id);
        return sellerRepository.save(seller);
    }

    public Seller save(Seller seller) {
        return sellerRepository.save(seller);
    }

    public void deleteById(String id) {
        if (!existsById(id)) {
            throw new EntityNotFoundException(Seller.class, "id", id);
        }

        sellerRepository.deleteById(id);
    }
}
