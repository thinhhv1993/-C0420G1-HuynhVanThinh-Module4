package com.codegym.phonemanagement.service;


import com.codegym.phonemanagement.model.Smartphone;
import org.springframework.stereotype.Service;


public interface SmartphoneService {
    Iterable<Smartphone> findAll();
    Smartphone findById(Long id);
    Smartphone save(Smartphone phone);
    Smartphone remove(Long id);
}
