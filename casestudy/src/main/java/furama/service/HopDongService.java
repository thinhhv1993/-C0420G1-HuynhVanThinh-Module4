package furama.service;

import furama.model.HopDong;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface HopDongService {
    Page<HopDong> findAll(Pageable pageable);

    HopDong findById(Long id);

    void save(HopDong hopDong);

    void remove(Long id);
}
