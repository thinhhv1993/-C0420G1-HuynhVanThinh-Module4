package furama.service.impl;

import furama.model.DichVu;

import furama.model.LoaiDichVu;
import furama.repository.LoaiDichVuRepository;
import furama.service.LoaiDichVuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
    public class LoaiDichVuServiceImpl implements LoaiDichVuService {

    @Autowired
    private LoaiDichVuRepository loaiDichVuRepository;

    @Override
    public List<LoaiDichVu> findAll() {
        return this.loaiDichVuRepository.findAll();
    }
}
