package com.codegym.cinemamanager.model;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


@Entity
public class KhuyenMai implements Validator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Tiêu Đề không được để trống")
    private String tieude;

    @NotEmpty(message = "Ngày Bắt Đầu không được để trống")
    @Pattern(regexp = "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[13-9]|1[0-2])\\2))" +
            "(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|" +
            "(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|" +
            "[2-9]\\d)?\\d{2})$",message = "Ngay Thang Co Dinh Dang dd/mm/yyyy")
    private String thoiGianBatDau;

    @NotEmpty(message = "Ngày Kết Thúc không được để trống")
    @Pattern(regexp = "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[13-9]|1[0-2])\\2))" +
            "(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|" +
            "(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|" +
            "[2-9]\\d)?\\d{2})$",message = "Ngay Thang Co Dinh Dang dd/mm/yyyy")
    private String thoiGianKetThuc;

    @Min(value = 10000, message = "mức giảm giá phải lớn hơn 10000")
    private String mucGiamGia;

    @NotBlank(message = "Chi Tiết Không được để trống")
    private String chiTiet;

    public KhuyenMai() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTieude() {
        return tieude;
    }

    public void setTieude(String tieude) {
        this.tieude = tieude;
    }

    public String getThoiGianBatDau() {
        return thoiGianBatDau;
    }

    public void setThoiGianBatDau(String thoiGianBatDau) {
        this.thoiGianBatDau = thoiGianBatDau;
    }

    public String getThoiGianKetThuc() {
        return thoiGianKetThuc;
    }

    public void setThoiGianKetThuc(String thoiGianKetThuc) {
        this.thoiGianKetThuc = thoiGianKetThuc;
    }

    public String getMucGiamGia() {
        return mucGiamGia;
    }

    public void setMucGiamGia(String mucGiamGia) {
        this.mucGiamGia = mucGiamGia;
    }

    public String getChiTiet() {
        return chiTiet;
    }

    public void setChiTiet(String chiTiet) {
        this.chiTiet = chiTiet;
    }


    @Override
    public boolean supports(Class<?> aClass) {
        return KhuyenMai.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
        KhuyenMai khuyenMai = (KhuyenMai) o;
        try {
            String[] strartdate = khuyenMai.getThoiGianBatDau().split("/");
            for (int i=0; i<strartdate.length/2; i++) {
                String temp = strartdate[i];
                strartdate[i] = strartdate[strartdate.length - 1 - i];
                strartdate[strartdate.length - 1 - i] = temp;
            }
            String[] endtdate = khuyenMai.getThoiGianKetThuc().split("/");
            for (int i=0; i<endtdate.length/2; i++) {
                String temp = endtdate[i];
                endtdate[i] = endtdate[endtdate.length - 1 - i];
                endtdate[endtdate.length - 1 - i] = temp;
            }
            String strartdate1 ="";
            String endtdate1 = "";
            for (int i=0; i<strartdate.length; i++) {
                strartdate1 += strartdate[i] + "/";
            }
            for (int i=0; i<endtdate.length; i++) {
                endtdate1 += endtdate[i]+ "/";
            }
            Date date = new Date();
            Date start = formatter.parse(strartdate1);
            Date end = formatter.parse(endtdate1);
            if (!start.before(end)) {
                errors.rejectValue("thoiGianKetThuc", "date.compareTo1");
            }
            if (!start.after(date)) {
                errors.rejectValue("thoiGianBatDau", "date.compareTo");
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
