package com.codegym.thi.repository;

import com.codegym.thi.model.SanPham;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SanPhamRepository extends JpaRepository<SanPham,Long> {

    Page<SanPham> findAll(Pageable pageable);

    Page<SanPham> findAllByLoaiSanPham_Name(String name,Pageable pageable);
    Page<SanPham> findAllByGiabatdau(String name,Pageable pageable);
    Page<SanPham> findAllByLoaiSanPham_NameAndTensanpham(String name,String name1,Pageable pageable);
    Page<SanPham> findAllByLoaiSanPham_NameAndGiabatdau(String name,String name1,Pageable pageable);

    Page<SanPham> findAllByLoaiSanPham_NameAndTensanphamAndGiabatdau(String loaisanpham,String tensanpham,String giabatdau,Pageable pageable);

}
