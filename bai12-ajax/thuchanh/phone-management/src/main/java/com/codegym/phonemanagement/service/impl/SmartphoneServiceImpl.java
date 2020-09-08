package com.codegym.phonemanagement.service.impl;

import com.codegym.phonemanagement.model.Smartphone;
import com.codegym.phonemanagement.repository.SmartphoneRepository;
import com.codegym.phonemanagement.service.SmartphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SmartphoneServiceImpl implements SmartphoneService {

    @Autowired
    SmartphoneRepository smartphoneRepository;

    @Override
    public Iterable<Smartphone> findAll() {
        return this.smartphoneRepository.findAll();
    }

    @Override
    public Smartphone findById(Long id) {
        return this.smartphoneRepository.findById(id).orElse(null);
    }

    @Override
    public Smartphone save(Smartphone phone) {
        return this.smartphoneRepository.save(phone);
    }

    @Override
    public Smartphone remove(Long id) {
        this.smartphoneRepository.deleteById(id);
        return this.smartphoneRepository.findById(id).orElse(null);
    }
}
