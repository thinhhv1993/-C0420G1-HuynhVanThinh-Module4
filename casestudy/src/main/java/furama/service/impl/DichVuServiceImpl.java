package furama.service.impl;

import furama.model.DichVu;
import furama.repository.DichVuRepository;
import furama.service.DichVuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class DichVuServiceImpl implements DichVuService {

    @Autowired
    DichVuRepository dichVuRepository;

    @Override
    public Page<DichVu> findAll(Pageable pageable) {
        return this.dichVuRepository.findAll(pageable);
    }

    @Override
    public DichVu findById(Long id) {
        return this.dichVuRepository.findById(id).orElse(null);
    }

    @Override
    public void save(DichVu dichVu) {
        this.dichVuRepository.save(dichVu);
    }

    @Override
    public void remove(Long id) {
        this.dichVuRepository.deleteById(id);
    }
}
