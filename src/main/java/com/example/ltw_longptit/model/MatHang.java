package com.example.ltw_longptit.model;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tblMatHang")
public class MatHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idMatHang;
    private String name;
    private String price;
    private int discount;
    private int isActive;

    @PrePersist
    void createActive() {
        this.isActive = 1;
    }

    public MatHang() {
    }
}
