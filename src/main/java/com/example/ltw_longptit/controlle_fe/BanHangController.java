package com.example.ltw_longptit.controlle_fe;

import com.example.ltw_longptit.model.*;
import com.example.ltw_longptit.repo.KhanhHangRepository;
import com.example.ltw_longptit.repo.MatHangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("banhang")
public class BanHangController {

    @Autowired
    MatHangRepository matHangRepository;
    @Autowired
    KhanhHangRepository khRepo;


    @GetMapping("/home")
    public String getProperties(Model model, HttpSession session) {
        List<MatHang> listMatHang = matHangRepository.findAll();
        List<KhachHang> listKhachHang = khRepo.findAll();
        HoaDonBanHang hoaDonBanHang = new HoaDonBanHang();
        List<ItemCart> listCart = new ArrayList<>();
        //
        session.setAttribute("listMatHang", listMatHang);
        model.addAttribute("hoadon", hoaDonBanHang);
        session.setAttribute("listKhachHang", listKhachHang);
        session.setAttribute("listCart", listCart);
        session.setAttribute("khachhang", new KhachHang());
        session.setAttribute("keySearchUser", "");
        session.setAttribute("tongSoLuong", 0);
        session.setAttribute("tongTien", 0.0);
        return "/sqa/BanHang";
    }




    @GetMapping("/clickKhachHang")
    public String clickKhachHang(Model model, HttpSession session, @RequestParam("id") String id) {
       session.setAttribute("khachhang", khRepo.getById(Long.parseLong(id)));
        session.setAttribute("keySearchUser", "");
        return "/sqa/BanHang";
    }

    @GetMapping("/addsanpham")
    public String addSanPham(Model model, HttpSession session, @RequestParam("key") String key,@RequestParam("soLuong") String soLuong) {
        System.out.println(key);
//        session.setAttribute("khachhang", khRepo.getById(Long.parseLong(id)));
//        session.setAttribute("keySearchUser", "");
        List<ItemCart> cartList = (List<ItemCart>) session.getAttribute("listCart");
        MatHang matHang = matHangRepository.getById(Long.parseLong(key));
        ItemCart itemCart = new ItemCart();
        itemCart.setId(matHang.getIdMatHang());
        itemCart.setName(matHang.getName());
        itemCart.setGiaTien(Double.valueOf(matHang.getPrice())*Integer.parseInt(soLuong));
        itemCart.setSoLuong(Integer.parseInt(soLuong));
        cartList.add(itemCart);
        session.setAttribute("listCart", cartList);
        int soLuongTong = 0;
        double tongTien = 0.0;
        for (ItemCart item: cartList) {
            soLuongTong += item.getSoLuong();
            tongTien += item.getGiaTien();
        }
        session.setAttribute("tongTien", tongTien);
        session.setAttribute("tongSoLuong", soLuongTong);
        return "/sqa/BanHang";
    }

    @GetMapping("/deleteClick")
    public String deleteClick(Model model, HttpSession session, @RequestParam("id") String id) {
       model.addAttribute("nameModal", id);
        return "/sqa/BanHang";
    }

}
