package com.codegym.cinemamanager.service.impl;

import com.codegym.cinemamanager.model.KhuyenMai;
import com.codegym.cinemamanager.repository.KhuyenMaiRepository;
import com.codegym.cinemamanager.service.KhuyenMaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class KhuyenMaiServiceImpl implements KhuyenMaiService {

    @Autowired
    private KhuyenMaiRepository khuyenMaiRepository;

    @Override
    public List<KhuyenMai> fillAll() {
        return this.khuyenMaiRepository.findAll();
    }

    @Override
    public void save(KhuyenMai khuyenMai) {
        this.khuyenMaiRepository.save(khuyenMai);
    }

    @Override
    public void remove(Long id) {
        this.khuyenMaiRepository.deleteById(id);
    }

    @Override
    public List<KhuyenMai> findAllByMucGiamGia(String mucGiamGia) {
        return this.khuyenMaiRepository.findAllByMucGiamGia(mucGiamGia);
    }

    @Override
    public List<KhuyenMai> findAllByThoiGianBatDau(String thoiGianBatDau) {
        return this.khuyenMaiRepository.findAllByThoiGianBatDau(thoiGianBatDau);
    }

    @Override
    public List<KhuyenMai> findAllByThoiGianKetThuc(String thoigianketthuc) {
        return this.khuyenMaiRepository.findAllByThoiGianKetThuc(thoigianketthuc);
    }

    @Override
    public List<KhuyenMai> findAllByMucGiamGiaOrThoiGianBatDauOrThoiGianKetThuc(String mucGiamGia, String thoiGianBatDau, String thoigianketthuc) {
        return this.khuyenMaiRepository.findAllByMucGiamGiaOrThoiGianBatDauOrThoiGianKetThuc(mucGiamGia,thoiGianBatDau,thoigianketthuc);
    }

}