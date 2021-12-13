package com.example.ltw_longptit.model;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity// biến 1 javabean thành 1 entity để thao tác với DB
public class Yta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_yta")
    private int id;
    private int ytaThamNien;
    private String ytaCMT;
    private String ytaTen;
    private String ytaSDT;
    private String ytaDiaChi;
    private String ytaNgaySinh;


}
