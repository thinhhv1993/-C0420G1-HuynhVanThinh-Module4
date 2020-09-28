package com.codegym.thi.service;

import com.codegym.thi.model.SanPham;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SanPhamService {
    void save(SanPham sanPham);

    void remove(Long id);

    List<SanPham> fillAll();

    Page<SanPham> findAll(Pageable pageable);

    Page<SanPham> findAllByLoaiSanPham_Name(String name,Pageable pageable);
    Page<SanPham> findAllByGiabatdau(String name,Pageable pageable);

    Page<SanPham> findAllByLoaiSanPham_NameAndTensanphamAndGiabatdau(String loaisanpham,String tensanpham,String giabatdau,Pageable pageable);
    Page<SanPham> findAllByLoaiSanPham_NameAndTensanpham(String name,String name1,Pageable pageable);
    Page<SanPham> findAllByLoaiSanPham_NameAndGiabatdau(String name,String name1,Pageable pageable);

}
