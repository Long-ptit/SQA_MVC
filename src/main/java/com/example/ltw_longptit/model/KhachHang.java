package com.example.ltw_longptit.model;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@Entity
@Table(name = "tblKhachHang")
public class KhachHang {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long idKhachHang;
    @NotBlank(message = "Tên không được để trống!")
    private String name;
    @NotBlank(message = "Số điện thoại không được để trống!")
    private String phone;
    @NotBlank(message = "Email không được để trống!")
    private String email;
    @NotBlank(message = "Địa chỉ không được để trống!")
    private String address;
    private String gender;
    private double totalXu;
    private int isActive;
    @PrePersist
    void createActive() {
        this.isActive = 1;
    }
    public KhachHang() {}
}
