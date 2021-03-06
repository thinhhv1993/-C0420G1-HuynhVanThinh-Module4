package furama.repository;



import furama.model.HopDong;
import furama.model.HopDongChiTiet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HopDongChiTietRepository extends JpaRepository<HopDongChiTiet, Long> {
    Page<HopDongChiTiet> findAll(Pageable pageable);

    Page<HopDong> findAllByHopDong_Id(Integer id, Pageable pageable);
}
