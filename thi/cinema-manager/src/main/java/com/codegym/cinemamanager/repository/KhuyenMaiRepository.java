package com.codegym.cinemamanager.repository;

import com.codegym.cinemamanager.model.KhuyenMai;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface KhuyenMaiRepository  extends JpaRepository<KhuyenMai,Long> {

    List<KhuyenMai> findAllByMucGiamGia(String mucGiamGia);
    List<KhuyenMai> findAllByThoiGianBatDau(String thoiGianBatDau);
    List<KhuyenMai> findAllByThoiGianKetThuc(String thoigianketthuc);
    List<KhuyenMai> findAllByMucGiamGiaOrThoiGianBatDauOrThoiGianKetThuc(String mucGiamGia,String thoiGianBatDau,String thoigianketthuc);
//    List<KhuyenMai> findAllByThoiGianBatDauIsBetweenAndThoiGianKetThuc(String thoiGianBatDau,String thoigianketthuc);

}
