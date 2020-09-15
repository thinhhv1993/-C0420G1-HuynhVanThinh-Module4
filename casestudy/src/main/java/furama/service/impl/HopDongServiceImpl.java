package furama.service.impl;


import furama.model.HopDong;
import furama.repository.HopDongRepository;
import furama.service.HopDongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class HopDongServiceImpl implements HopDongService {

    @Autowired
    private HopDongRepository hopDongRepository;


    @Override
    public Page<HopDong> findAll(Pageable pageable) {
        return this.hopDongRepository.findAll(pageable);
    }

    @Override
    public HopDong findById(Long id) {
        return this.hopDongRepository.findById(id).orElse(null);
    }

    @Override
    public void save(HopDong hopDong) {
        this.hopDongRepository.save(hopDong);
    }

    @Override
    public void remove(Long id) {
        this.hopDongRepository.deleteById(id);
    }
}
