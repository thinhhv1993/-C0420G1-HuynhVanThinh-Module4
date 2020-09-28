package furama.service.impl;

import furama.model.DichVu;
import furama.model.HopDong;
import furama.repository.DichVuRepository;
import furama.service.DichVuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Service
public class DichVuServiceImpl implements DichVuService {

    @Autowired
    DichVuRepository dichVuRepository;

    @Autowired
    HopDongServiceImpl hopDongService;


    @Override
    public Page<DichVu> findAll(Pageable pageable) {
        return this.dichVuRepository.findAll(pageable);
    }

    @Override
    public Page<DichVu> findAllByTenDichVuContaining(String name, Pageable pageable) {
        return this.dichVuRepository.findAllByTenDichVuContaining(name, pageable);
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
    public void remove(Long id, RedirectAttributes redirectAttributes) {
        if (hopDongService.findById(id).getId() == this.findById(id).getId()) {
            redirectAttributes.addFlashAttribute("message", "Dịch Vụ Đang Được Sử Dụng");
        } else {
            this.dichVuRepository.deleteById(id);
        }
    }
}
