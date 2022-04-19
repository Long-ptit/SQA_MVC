package com.example.ltw_longptit.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "tblHoaDon")
public class HoaDonBanHang {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long idHoaDonBanHang;
    private double totalPrice;
    private Date date;
    private int discount;
    private double actualPrice;
    @OneToOne
    @JoinColumn(name = "id_nhan_vien")//name="tên cột khóa ngoại"
    NhanVien nhanVien;
    @OneToOne
    @JoinColumn(name = "id_khach_hang")//name="tên cột khóa ngoại"
    KhachHang khachHang;
    private int isActive;
    @PrePersist
    void createActive() {
        this.isActive = 1;
    }
    public HoaDonBanHang() {}
}
