package com.example.ltw_longptit.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tblMatHangHoaDon")
public class MatHang_HoaDon {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    private String name;
    private double amount;
    private double price;
    private int discount;
    @ManyToOne
    @JoinColumn(name = "id_mat_hang")//name="tên cột khóa ngoại"
    MatHang matHang;
    @ManyToOne
    @JoinColumn(name = "id_hoa_don_ban_hang")//name="tên cột khóa ngoại"
    HoaDonBanHang hoaDonBanHang;
    private int isActive;
    @PrePersist
    void createActive() {
        this.isActive = 1;
    }
    public MatHang_HoaDon() {}
}
