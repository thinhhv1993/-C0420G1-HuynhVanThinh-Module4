package furama.repository;

import furama.model.DichVu;
import furama.model.KhachHang;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DichVuRepository extends JpaRepository<DichVu, Long> {
    Page<DichVu> findAll(Pageable pageable);
}
