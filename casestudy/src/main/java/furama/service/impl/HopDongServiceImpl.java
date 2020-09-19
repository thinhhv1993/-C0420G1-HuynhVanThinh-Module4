package furama.service.impl;



import furama.model.HopDong;

import furama.model.HopDongChiTiet;
import furama.repository.HopDongRepository;
import furama.service.HopDongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;

@Service
public class HopDongServiceImpl implements HopDongService {

    @Autowired
    private HopDongRepository hopDongRepository;


    @Override
    public Page<HopDong> findAllByDelete1(Pageable pageable, Integer integer) {
        return this.hopDongRepository.findAllByDelete1(pageable,integer);
    }

    @Override
    public Page<HopDong> findAllByKhachHang_HoTenContainingAndAndDelete1(String Khachhang, Pageable pageable, Integer integer) {
        return this.hopDongRepository.findAllByKhachHang_HoTenContainingAndAndDelete1(Khachhang,pageable,integer);
    }


    @Override
    public List<HopDong> findAll() {
        return this.findAll();
    }

    @Override
    public HopDong findById(Long id) {
        return this.hopDongRepository.findById(id).orElse(null);
    }

    @Override
    public void save(HopDong hopDong) {
        this.hopDongRepository.save(hopDong);
    }

    @Override
    public void remove(Long id) {
        this.hopDongRepository.deleteById(id);
    }

    public Double tongTien(HopDongChiTiet hopDongChiTiet){
        Double tongTien = 0.0;
        for (HopDong hopdong : hopDongRepository.findAll()){
            tongTien = Double.parseDouble(hopdong.getTongTienThanhToan());
            if(hopdong.getId() == hopDongChiTiet.getHopDong().getId()){
                tongTien += Double.parseDouble(hopdong.getTongTienThanhToan()) + (Double.parseDouble(hopDongChiTiet.getSoLuong()) * Double.parseDouble(hopDongChiTiet.getDichVuDiKem().getGia()));
            }
            Formatter formatter = new Formatter();
            formatter.format("% .0f",tongTien);
            hopdong.setTongTienThanhToan(String.valueOf(formatter));
            hopDongRepository.save(hopdong);
        }
        return tongTien;
    }

    public HopDong addCookies(Long idhopdong){
        for (HopDong hopDong : hopDongRepository.findAll()){
            if(hopDong.getId() == idhopdong){
                return hopDong;
            }
        }
        return null;
    }
}
