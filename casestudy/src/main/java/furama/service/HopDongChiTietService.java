package furama.service;

import furama.model.HopDong;
import furama.model.HopDongChiTiet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface HopDongChiTietService {
    Page<HopDongChiTiet> findAll(Pageable pageable);

    Page<HopDong> findAllByHopDong_Id(Integer id, Pageable pageable);

    HopDongChiTiet findById(Long id);

    void save(HopDongChiTiet hopDongChiTiet);

    void remove(Long id);
}
