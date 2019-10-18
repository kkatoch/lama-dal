package com.lama.dal.service;

import com.lama.dal.entity.Seller;
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

    public Optional<Seller> findById(String id) {
        return sellerRepository.findById(id);
    }

    public Seller save(Seller seller) {
        return (Seller) sellerRepository.save(seller);
    }

    public void deleteById(String id) {
        sellerRepository.deleteById(id);
    }
}
