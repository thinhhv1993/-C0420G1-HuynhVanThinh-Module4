package furama.service;

import furama.model.DichVuDiKem;
import furama.model.LoaiDichVu;

import java.util.List;

public interface DichVuDiKemService {
    List<DichVuDiKem> findAll();
}
