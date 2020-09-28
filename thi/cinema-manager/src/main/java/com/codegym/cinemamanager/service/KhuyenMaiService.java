package com.codegym.cinemamanager.service;

import com.codegym.cinemamanager.model.KhuyenMai;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface KhuyenMaiService  {
    List<KhuyenMai> fillAll();
    void save(KhuyenMai khuyenMai) ;
    void remove(Long id) ;
    List<KhuyenMai> findAllByMucGiamGia(String mucGiamGia);
    List<KhuyenMai> findAllByThoiGianBatDau(String thoiGianBatDau);
    List<KhuyenMai> findAllByThoiGianKetThuc(String thoigianketthuc);
    List<KhuyenMai> findAllByMucGiamGiaOrThoiGianBatDauOrThoiGianKetThuc(String mucGiamGia,String thoiGianBatDau,String thoigianketthuc);
}
