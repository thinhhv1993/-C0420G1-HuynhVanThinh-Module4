package furama.service.impl;


import furama.model.KhachHang;
import furama.repository.KhachHangReponsitory;
import furama.service.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class KhachHangServiceImpl implements KhachHangService {

    @Autowired
    private KhachHangReponsitory khachHangReponsitory;

    @Override
    public Page<KhachHang> findAll(Pageable pageable) {
        return this.khachHangReponsitory.findAll(pageable);
    }

    @Override
    public KhachHang findById(Long id) {
        return this.khachHangReponsitory.findById(id).orElse(null);
    }

    @Override
    public void save(KhachHang khachHang) {
        this.khachHangReponsitory.save(khachHang);
    }

    @Override
    public void remove(Long id) {
        this.khachHangReponsitory.deleteById(id);
    }
}
