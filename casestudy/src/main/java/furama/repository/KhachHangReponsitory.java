package furama.repository;

import furama.model.KhachHang;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KhachHangReponsitory extends JpaRepository<KhachHang, Long> {
    Page<KhachHang> findAll(Pageable pageable);

    Page<KhachHang> findAllByHoTenContaining(String name, Pageable pageable);
}
