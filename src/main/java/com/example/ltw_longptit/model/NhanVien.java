package com.example.ltw_longptit.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * CREATE BY HAHA
 * X
 * X
 * X
 * X
 * X
 * X
 * XX
 * X
 * X
 * 
 */

@Data
@Entity
@Table(name = "tblNhanVien")
public class NhanVien implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long idNhanVien;
    @NotBlank(message = "Tên đăng nhập không được để trống!")
    private String tenDangNhap;
    @NotBlank(message = "Mật khẩu không được để trống!")
    private String matKhau;
    private String CMND;
    private String hoTen;
    private String ngaySinh;
    private String diaChi;
    private String viTriCongViec;
    private int active;

    @PrePersist
    void createActive() {
        this.active = 1;
    }
    public NhanVien() {}
}
