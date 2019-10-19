package com.lama.dal.controller;

import com.lama.dal.entity.Seller;
import com.lama.dal.service.SellerService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/sellers")
@Slf4j
@RequiredArgsConstructor
@Api(tags = "Sellers")
public class SellerController {
    private final SellerService sellerService;

    @GetMapping
    public ResponseEntity<List<Seller>> findAll() {
        return ResponseEntity.ok(sellerService.findAll());
    }

    @PostMapping
    public ResponseEntity create(@Valid @RequestBody Seller seller) {
        return ResponseEntity.ok(sellerService.save(seller));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Seller> findById(@PathVariable String id) {
        return ResponseEntity.ok(sellerService.findById(id).get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Seller> update(@PathVariable String id, @Valid @RequestBody Seller seller) {
        return ResponseEntity.ok(sellerService.update(id, seller));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable String id) {
        sellerService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}