package furama.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class LoaiKhachHang {


    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;


    private String tenLoaiKhachHang;

    @OneToMany
    private List<KhachHang> khachHangs;

    public LoaiKhachHang() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getTenLoaiKhachHang() {
        return tenLoaiKhachHang;
    }

    public void setTenLoaiKhachHang(String tenLoaiKhachHang) {
        this.tenLoaiKhachHang = tenLoaiKhachHang;
    }

    public List<KhachHang> getKhachHangs() {
        return khachHangs;
    }

    public void setKhachHangs(List<KhachHang> khachHangs) {
        this.khachHangs = khachHangs;
    }
}
