package com.lama.dal.service;

import com.lama.dal.entity.Product;
import com.lama.dal.entity.Seller;
import com.lama.dal.error.EntityNotFoundException;
import com.lama.dal.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    @Autowired
    private final ProductRepository productRepository;
    private final SellerService sellerService;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public boolean existsById(String id) {
        return productRepository.existsById(id);
    }

    public Optional<Product> findById(String id) {
        Optional<Product> product = productRepository.findById(id);
        if (!product.isPresent()) {
            throw new EntityNotFoundException(Product.class, "id", id);
        }

        return product;
    }

    public Product update(String id, Product product) {
        if (!existsById(id)) {
            throw new EntityNotFoundException(Product.class, "id", id);
        }
        product.setId(id);
        return productRepository.save(product);
    }

    public Product save(Product product) {
        Seller seller = product.getSeller();
        if(seller == null || seller.getId().isEmpty()) {
            throw new EntityNotFoundException(Seller.class, "id", "Empty");

        }
        if (!sellerService.existsById(seller.getId())) {
            throw new EntityNotFoundException(Seller.class, "id", seller.getId());
        }
        return productRepository.save(product);
    }

    public void deleteById(String id) {
        if (!existsById(id)) {
            throw new EntityNotFoundException(Product.class, "id", id);
        }

        productRepository.deleteById(id);
    }
}
