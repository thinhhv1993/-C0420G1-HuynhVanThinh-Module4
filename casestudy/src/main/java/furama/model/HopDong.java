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

    private String idHopDong;

    private String ngayBatDau;

    private String ngayKetthuc;

    private String soTienCocTruoc;

    private String tongTienThanhToan;
}
