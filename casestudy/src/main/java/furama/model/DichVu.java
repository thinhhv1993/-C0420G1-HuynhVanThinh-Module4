package furama.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

@Entity
public class DichVu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Pattern(regexp="(DV)[\\d]{4,}",message = "Mã Dịch Vụ Có Dạng DVXXXX ")
    private String idDichVu;

    private String tenDichVu;

    @Min(value = 0, message = "Diện tích phải là số dương")
    private String dienTich;
    @Min(value = 0, message = "Số Tầng phải là số dương")
    private String soTang;
    @Min(value = 0, message = "Số người tối đa phải là số dương")
    private String soNguoiToiDa;
    @Min(value = 0, message = "Chi phí thuê phải là số dương")
    private String chiPhiThue;

    @ManyToOne
    @JoinColumn(name = "loaidichvu_id")
    private LoaiDichVu loaiDichVu;

    @ManyToOne
    @JoinColumn(name = "kieuthue_id")
    private KieuThue kieuThue;


    private String trangThai;


    public DichVu() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdDichVu() {
        return idDichVu;
    }

    public void setIdDichVu(String idDichVu) {
        this.idDichVu = idDichVu;
    }

    public String getTenDichVu() {
        return tenDichVu;
    }

    public void setTenDichVu(String tenDichVu) {
        this.tenDichVu = tenDichVu;
    }

    public String getDienTich() {
        return dienTich;
    }

    public void setDienTich(String dienTich) {
        this.dienTich = dienTich;
    }

    public String getSoTang() {
        return soTang;
    }

    public void setSoTang(String soTang) {
        this.soTang = soTang;
    }

    public String getSoNguoiToiDa() {
        return soNguoiToiDa;
    }

    public void setSoNguoiToiDa(String soNguoiToiDa) {
        this.soNguoiToiDa = soNguoiToiDa;
    }

    public String getChiPhiThue() {
        return chiPhiThue;
    }

    public void setChiPhiThue(String chiPhiThue) {
        this.chiPhiThue = chiPhiThue;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public LoaiDichVu getLoaiDichVu() {
        return loaiDichVu;
    }

    public void setLoaiDichVu(LoaiDichVu loaiDichVu) {
        this.loaiDichVu = loaiDichVu;
    }

    public KieuThue getKieuThue() {
        return kieuThue;
    }

    public void setKieuThue(KieuThue kieuThue) {
        this.kieuThue = kieuThue;
    }
}
