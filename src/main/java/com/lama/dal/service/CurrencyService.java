package com.lama.dal.service;

import com.lama.dal.entity.Currency;
import com.lama.dal.repository.CurrencyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CurrencyService {
    @Autowired
    private final CurrencyRepository currencyRepository;

    public List<Currency> findAll() {
        return currencyRepository.findAll();
    }

    public Optional<Currency> findById(String id) {
        return currencyRepository.findById(id);
    }

    public Currency save(Currency currency) {
        return (Currency) currencyRepository.save(currency);
    }

    public void deleteById(String id) {
        currencyRepository.deleteById(id);
    }
}
