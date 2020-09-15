package furama.service;

import furama.model.DichVu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface DichVuService {
    Page<DichVu> findAll(Pageable pageable);

    DichVu findById(Long id);

    void save(DichVu dichVu);

    void remove(Long id);
}
