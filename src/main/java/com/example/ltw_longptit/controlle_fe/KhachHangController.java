package com.example.ltw_longptit.controlle_fe;

import com.example.ltw_longptit.model.BenhNhan;
import com.example.ltw_longptit.model.KhachHang;
import com.example.ltw_longptit.repo.KhanhHangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/khachhang")
public class KhachHangController {

    @Autowired
    KhanhHangRepository khRepo;

    @GetMapping("/")
    public String getData(Model model)
    {
        List<KhachHang> listKhachHang = khRepo.findAll();
        model.addAttribute("listKhachHang",listKhachHang);
        return "sqa/QLKH";
    }

    @GetMapping("/addUser")
    public String addUser(Model model)
    {
        model.addAttribute("khachHang",new KhachHang());
        return "sqa/ThemKH";
    }

    @PostMapping(path = "/saveDelete")
    public String saveDelete(@RequestParam("idDelete") String idDelete)
    {
        System.out.println("haha");
        khRepo.deleteById(Long.parseLong(idDelete));
        return "redirect:/khachhang/";
    }


    @PostMapping(path = "/save")
    public String save(@ModelAttribute("khachHang") KhachHang khachHang, @RequestParam("gioiTinh") String gioiTinh)
    {
        System.out.println("haha");
        khachHang.setGender(gioiTinh);
        khRepo.save(khachHang);
        return "redirect:/khachhang/";
    }


}
