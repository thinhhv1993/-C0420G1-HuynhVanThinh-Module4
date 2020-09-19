package furama.service;


import furama.model.KhachHang;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface KhachHangService {
    Page<KhachHang> findAll(Pageable pageable);

    Page<KhachHang> findAllByHoTenContaining(String name, Pageable pageable);

    KhachHang findById(Long id);

    void save(KhachHang khachHang);

    void remove(Long id);
}
