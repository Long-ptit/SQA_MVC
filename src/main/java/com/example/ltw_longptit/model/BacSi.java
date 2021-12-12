package com.example.ltw_longptit.model;
import lombok.Data;
import javax.persistence.*;
@Data
@Entity
@Table
public class BacSi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_bs")
    private int id;
    @Column
    private int bacsyThamNien;
    @Column
    private String bacsyCMT;
    @Column
    private String bacsyTen;
    @Column
    private String bacsySDT;
    @Column
    private String bacsyDiaChi;
    @Column
    private String bacsyNgaySinh;
    @Column
    private String bacsyBacNghe;
    @Column
    private String bacsyTrinhDoDaoTao;
    @Column
    private String bacsyChuyenMon;
//    @JsonManagedReference
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bacSy", fetch = FetchType.LAZY)
//    private List<Kham> listKham = new ArrayList<>();
}
