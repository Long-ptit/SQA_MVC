package com.example.ltw_longptit.model;

import lombok.Data;

@Data
public class ItemCart {
    private long id;
    private String name;
    private int soLuong;
    private double giaTien;

    public ItemCart() {

    }

    public ItemCart(long id, String name, int soLuong, double giaTien) {
        this.id = id;
        this.name = name;
        this.soLuong = soLuong;
        this.giaTien = giaTien;
    }
}
