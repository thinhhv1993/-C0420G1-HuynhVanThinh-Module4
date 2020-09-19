package furama.model;


import furama.validate.CheckPhone;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

@Entity
public class KhachHang {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Pattern(regexp="(KH)[\\d]{4,}",message = "Mã Khách Hàng Có Dạng KHXXXX ")
    private String idKhachHang;

    private String hoTen;

    private String ngaySinh;

    private String gioiTinh;

    @Pattern(regexp="[\\d]{3,}\\s[\\d]{3,}\\s[\\d]{3,}",message = "CMND Không Đúng")
    private String soCMND;

    @CheckPhone
    private String sDT;

    @Pattern(regexp="^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$", message = "Email Sai Định Dạng")
    private String email;


    private String diaChi;

    @ManyToOne
    @JoinColumn(name = "loaikhachhang_id")
    private LoaiKhachHang loaiKhachHang;

    public KhachHang() {
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdKhachHang() {
        return idKhachHang;
    }

    public void setIdKhachHang(String idKhachHang) {
        this.idKhachHang = idKhachHang;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getSoCMND() {
        return soCMND;
    }

    public void setSoCMND(String soCMND) {
        this.soCMND = soCMND;
    }

    public String getsDT() {
        return sDT;
    }

    public void setsDT(String sDT) {
        this.sDT = sDT;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public LoaiKhachHang getLoaiKhachHang() {
        return loaiKhachHang;
    }

    public void setLoaiKhachHang(LoaiKhachHang loaiKhachHang) {
        this.loaiKhachHang = loaiKhachHang;
    }
}
