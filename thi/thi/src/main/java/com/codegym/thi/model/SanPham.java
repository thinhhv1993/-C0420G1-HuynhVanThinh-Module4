package com.codegym.thi.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class SanPham {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Tên sản Phẩm không được để trống")
    @Size(min = 5,max = 50, message = "Độ dài tên sản phẩm từ 5 --> 50 ký tự")
    private String tensanpham;

    @NotBlank(message = "Giá sản phẩm không được để trống")
    @Min(value = 100000,message = "Giá sản phẩm thấp nhất 100000")
    private String giabatdau;

    @NotBlank(message = "Tình Trạng sản Phẩm không được để trống")
    private String tinhtrang;

    @ManyToOne
    @JoinColumn(name = "loaisanpham_id")
    private LoaiSanPham loaiSanPham;

    public SanPham() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTensanpham() {
        return tensanpham;
    }

    public void setTensanpham(String tensanpham) {
        this.tensanpham = tensanpham;
    }

    public String getGiabatdau() {
        return giabatdau;
    }

    public void setGiabatdau(String giabatdau) {
        this.giabatdau = giabatdau;
    }

    public LoaiSanPham getLoaiSanPham() {
        return loaiSanPham;
    }

    public void setLoaiSanPham(LoaiSanPham loaiSanPham) {
        this.loaiSanPham = loaiSanPham;
    }

    public String getTinhtrang() {
        return tinhtrang;
    }

    public void setTinhtrang(String tinhtrang) {
        this.tinhtrang = tinhtrang;
    }
}
