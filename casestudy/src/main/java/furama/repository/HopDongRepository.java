package furama.repository;



import furama.model.HopDong;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HopDongRepository extends JpaRepository<HopDong, Long> {
    Page<HopDong> findAll(Pageable pageable);
}
