package furama.service.impl;

import furama.model.LoaiKhachHang;
import furama.repository.LoaiKhachHangRepository;
import furama.service.LoaiKhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoaiKhachHangServiceImpl implements LoaiKhachHangService {


    @Autowired
    private LoaiKhachHangRepository loaiKhachHangRepository;

    @Override
    public List<LoaiKhachHang> findAll() {
        return this.loaiKhachHangRepository.findAll();
    }
}
