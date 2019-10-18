package com.lama.dal.controller;

import com.lama.dal.entity.Country;
import com.lama.dal.service.CountryService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/country")
@Slf4j
@RequiredArgsConstructor
@Api(tags = "Country")
public class CountryController {
    private final CountryService countryService;

    @GetMapping
    public ResponseEntity<List<Country>> findAll() {
        return ResponseEntity.ok(countryService.findAll());
    }

    @PostMapping
    public ResponseEntity create(@Valid @RequestBody Country country) {
        return ResponseEntity.ok(countryService.save(country));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Country> findById(@PathVariable String id) {
        Optional<Country> country = countryService.findById(id);
        if (!country.isPresent()) {
            log.error("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(country.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Country> update(@PathVariable String id, @Valid @RequestBody Country country) {
        if (!countryService.findById(id).isPresent()) {
            log.error("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(countryService.save(country));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable String id) {
        if (!countryService.findById(id).isPresent()) {
            log.error("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }

        countryService.deleteById(id);

        return ResponseEntity.ok().build();
    }
}