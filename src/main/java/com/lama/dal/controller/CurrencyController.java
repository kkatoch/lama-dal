package com.lama.dal.controller;

import com.lama.dal.entity.Currency;
import com.lama.dal.service.CurrencyService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/currency")
@Slf4j
@RequiredArgsConstructor
@Api(tags = "Currency")
public class CurrencyController {
    private final CurrencyService currencyService;

    @GetMapping
    public ResponseEntity<List<Currency>> findAll() {
        return ResponseEntity.ok(currencyService.findAll());
    }

    @PostMapping
    public ResponseEntity create(@Valid @RequestBody Currency currency) {
        return ResponseEntity.ok(currencyService.save(currency));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Currency> findById(@PathVariable String id) {
        Optional<Currency> currency = currencyService.findById(id);
        if (!currency.isPresent()) {
            log.error("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(currency.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Currency> update(@PathVariable String id, @Valid @RequestBody Currency currency) {
        if (!currencyService.findById(id).isPresent()) {
            log.error("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(currencyService.save(currency));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable String id) {
        if (!currencyService.findById(id).isPresent()) {
            log.error("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }

        currencyService.deleteById(id);

        return ResponseEntity.ok().build();
    }
}