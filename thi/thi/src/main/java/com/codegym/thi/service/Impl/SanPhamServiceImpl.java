package com.codegym.thi.service.Impl;

import com.codegym.thi.model.SanPham;
import com.codegym.thi.repository.SanPhamRepository;
import com.codegym.thi.service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SanPhamServiceImpl implements SanPhamService {

    @Autowired
    private SanPhamRepository sanPhamRepository;


    @Override
    public void save(SanPham sanPham) {
        this.sanPhamRepository.save(sanPham);
    }

    @Override
    public void remove(Long id) {
        this.sanPhamRepository.deleteById(id);
    }

    @Override
    public List<SanPham> fillAll() {
        return this.sanPhamRepository.findAll();
    }

    @Override
    public Page<SanPham> findAll(Pageable pageable) {
        return this.sanPhamRepository.findAll(pageable);
    }

    @Override
    public Page<SanPham> findAllByLoaiSanPham_Name(String name, Pageable pageable) {
        return this.sanPhamRepository.findAllByLoaiSanPham_Name(name,pageable);
    }

    @Override
    public Page<SanPham> findAllByGiabatdau(String name, Pageable pageable) {
        return this.sanPhamRepository.findAllByGiabatdau(name,pageable);
    }

    @Override
    public Page<SanPham> findAllByLoaiSanPham_NameAndTensanphamAndGiabatdau(String loaisanpham, String tensanpham, String giabatdau, Pageable pageable) {
        return this.sanPhamRepository.findAllByLoaiSanPham_NameAndTensanphamAndGiabatdau(loaisanpham,tensanpham,giabatdau,pageable);
    }


    @Override
    public Page<SanPham> findAllByLoaiSanPham_NameAndTensanpham(String name, String name1, Pageable pageable) {
        return this.sanPhamRepository.findAllByLoaiSanPham_NameAndTensanpham(name,name1,pageable);
    }

    @Override
    public Page<SanPham> findAllByLoaiSanPham_NameAndGiabatdau(String name, String name1, Pageable pageable) {
        return this.sanPhamRepository.findAllByLoaiSanPham_NameAndGiabatdau(name,name1,pageable);
    }
}
