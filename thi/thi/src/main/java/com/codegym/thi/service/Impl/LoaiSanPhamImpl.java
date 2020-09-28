package com.codegym.thi.service.Impl;


import com.codegym.thi.model.LoaiSanPham;
import com.codegym.thi.repository.LoaiSanPhamRepository;
import com.codegym.thi.service.LoaiSanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class LoaiSanPhamImpl implements LoaiSanPhamService {

    @Autowired
    private LoaiSanPhamRepository loaiSanPhamRepository;

    @Override
    public List<LoaiSanPham> findAll() {
        return this.loaiSanPhamRepository.findAll();
    }
}
