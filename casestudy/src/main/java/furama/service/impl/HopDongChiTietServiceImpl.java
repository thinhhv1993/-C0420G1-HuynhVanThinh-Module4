package furama.service.impl;


import furama.model.HopDongChiTiet;
import furama.repository.HopDongChiTietRepository;
import furama.service.HopDongChiTietService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class HopDongChiTietServiceImpl implements HopDongChiTietService {

    @Autowired
    HopDongChiTietRepository hopDongChiTietRepository;


    @Override
    public Page<HopDongChiTiet> findAll(Pageable pageable) {
        return this.hopDongChiTietRepository.findAll(pageable);
    }

    @Override
    public HopDongChiTiet findById(Long id) {
        return this.hopDongChiTietRepository.findById(id).orElse(null);
    }

    @Override
    public void save(HopDongChiTiet hopDongChiTiet) {
        this.hopDongChiTietRepository.save(hopDongChiTiet);
    }

    @Override
    public void remove(Long id) {
        this.hopDongChiTietRepository.deleteById(id);
    }
}
