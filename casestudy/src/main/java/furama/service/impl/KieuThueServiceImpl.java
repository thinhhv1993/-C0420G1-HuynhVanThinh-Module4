package furama.service.impl;

import furama.model.KieuThue;
import furama.repository.KieuThueRepository;
import furama.service.KieuThueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KieuThueServiceImpl implements KieuThueService {
    @Autowired
    private KieuThueRepository kieuThueRepository;
    @Override
    public List<KieuThue> findAll() {
        return this.kieuThueRepository.findAll();
    }
}
