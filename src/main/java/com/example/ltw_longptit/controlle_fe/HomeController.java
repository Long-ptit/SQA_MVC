package com.example.ltw_longptit.controlle_fe;

import com.example.ltw_longptit.model.NhanVien;
import com.example.ltw_longptit.repo.NhanVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class HomeController {

    @Autowired
    NhanVienRepository repository;

    @GetMapping("/home")
    public String home()
    {
        return "index";
    }

    @GetMapping("/")
    public String home1(Model model) {
        //System.out.println("==========> " + myVariable);
        model.addAttribute("nhanvien", new NhanVien());
        return "login";
    }

    @PostMapping("/")
    public String login(@Valid @ModelAttribute("nhanvien") NhanVien nhanVien, Errors errors, Model model, HttpSession session)
    {
        System.out.println(errors.toString());
        if (errors.hasErrors()){
            System.out.println("hehe");
            return "login";
        }
        NhanVien nhanVien1 = repository.findByUsernameAndPassword(nhanVien.getTenDangNhap(), nhanVien.getMatKhau());
        if (nhanVien1 != null) {
            model.addAttribute("nhanvien", nhanVien1);
            session.setAttribute("nhanvien", nhanVien1);
            if (nhanVien1.getViTriCongViec().equals("nhanvien")) {
                return "home_nhanvien";
            } else {
                return "home_admin";
            }
         } else {
            System.out.println("haha");
            return "login";
        }
    }

    @GetMapping("/logout")
    public String loginView(Model model, HttpSession session) {
        model.addAttribute("nhanvien", new NhanVien());
        session.removeAttribute("nhanvien");
        return "login";
    }

    @GetMapping("/developing")
    public String viewDeveloping() {
        return "develop";
    }
}
