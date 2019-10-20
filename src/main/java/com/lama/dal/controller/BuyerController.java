package com.lama.dal.controller;

import com.lama.dal.entity.Buyer;
import com.lama.dal.service.BuyerService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/buyers")
@Slf4j
@RequiredArgsConstructor
@Api(tags = "Buyers")
public class BuyerController {
    private final BuyerService buyerService;

    @GetMapping
    public ResponseEntity<List<Buyer>> findAll() {
        return ResponseEntity.ok(buyerService.findAll());
    }

    @PostMapping
    public ResponseEntity create(@Valid @RequestBody Buyer buyer) {
        return ResponseEntity.ok(buyerService.save(buyer));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Buyer> findById(@PathVariable String id) {
        return ResponseEntity.ok(buyerService.findById(id).get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Buyer> update(@PathVariable String id, @Valid @RequestBody Buyer buyer) {
        return ResponseEntity.ok(buyerService.update(id, buyer));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable String id) {
        buyerService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}