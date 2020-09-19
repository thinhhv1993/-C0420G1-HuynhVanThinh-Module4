package furama.service.impl;

import furama.model.DichVuDiKem;
import furama.repository.DichVuDiKemRepository;
import furama.service.DichVuDiKemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DichVuDiKemServiceImpl implements DichVuDiKemService {

    @Autowired
    private DichVuDiKemRepository dichVuDiKemRepository;

    @Override
    public List<DichVuDiKem> findAll() {
        return this.dichVuDiKemRepository.findAll();
    }
}
