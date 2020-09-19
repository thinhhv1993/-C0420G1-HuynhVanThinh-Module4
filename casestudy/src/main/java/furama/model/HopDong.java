package furama.model;

import javax.persistence.*;

@Entity
public class HopDong {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "dichvu_idDichVu")
    private DichVu dichVu;

    @ManyToOne
    @JoinColumn(name = "khachhang_idKhachHang")
    private KhachHang khachHang;


    private String ngayBatDau;

    private String ngayKetthuc;

    private String soTienCocTruoc;

    private String tongTienThanhToan;

    private int delete1;

    public HopDong() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DichVu getDichVu() {
        return dichVu;
    }

    public void setDichVu(DichVu dichVu) {
        this.dichVu = dichVu;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }


    public String getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(String ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public String getNgayKetthuc() {
        return ngayKetthuc;
    }

    public void setNgayKetthuc(String ngayKetthuc) {
        this.ngayKetthuc = ngayKetthuc;
    }

    public String getSoTienCocTruoc() {
        return soTienCocTruoc;
    }

    public void setSoTienCocTruoc(String soTienCocTruoc) {
        this.soTienCocTruoc = soTienCocTruoc;
    }

    public String getTongTienThanhToan() {
        return tongTienThanhToan;
    }

    public void setTongTienThanhToan(String tongTienThanhToan) {
        this.tongTienThanhToan = tongTienThanhToan;
    }

    public int getDelete() {
        return delete1;
    }

    public void setDelete(int delete) {
        this.delete1 = delete;
    }
}
