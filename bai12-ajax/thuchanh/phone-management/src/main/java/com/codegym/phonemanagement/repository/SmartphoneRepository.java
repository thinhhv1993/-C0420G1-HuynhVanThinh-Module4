package com.codegym.phonemanagement.repository;

import com.codegym.phonemanagement.model.Smartphone;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SmartphoneRepository extends JpaRepository<Smartphone,Long> {

}
