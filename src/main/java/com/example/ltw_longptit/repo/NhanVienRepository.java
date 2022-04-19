package com.example.ltw_longptit.repo;

import com.example.ltw_longptit.model.NhanVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface NhanVienRepository extends JpaRepository<NhanVien, Long> {
    @Transactional
    @Query(value="Select * from tbl_nhan_vien where ten_dang_nhap = ?1 "
            + "and mat_khau = ?2 and active = 1", nativeQuery=true)
    NhanVien findByUsernameAndPassword(String username, String password);
}
