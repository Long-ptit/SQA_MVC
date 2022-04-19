package com.example.ltw_longptit.controller;


import com.example.ltw_longptit.model.BenhNhan;
import com.example.ltw_longptit.repo.BenhNhanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(path = "/benhnhan", produces = "application/json")
@CrossOrigin(origins = "*")
public class BenhNhanController {

    @Autowired
    private BenhNhanRepository benhNhanRepo;

    @GetMapping
    public Iterable<BenhNhan> getAllBenhNhan() {
        return benhNhanRepo.findAll();
    }

    @GetMapping("/")
    public String getBenhNhanById() {
        return "/sqa/register";
    }
    @PostMapping(consumes = "application/json")
    public BenhNhan createBenhNhan(@RequestBody BenhNhan benhNhan) {
        return benhNhanRepo.save(benhNhan);
    }

    @PutMapping("/{id}")
    public BenhNhan updateBenhNhan(@RequestBody BenhNhan benhNhan, @PathVariable("id") int id) {
        return benhNhanRepo.save(benhNhan);
    }

    @DeleteMapping("/{id}")
    public void deleteBenhNhan(@PathVariable("id") int id) {
            benhNhanRepo.deleteById(id);
    }
    @GetMapping("/search/{keyword}")
    public Iterable<BenhNhan> searchBenhNhan(@PathVariable("keyword") String keyword) {
        return benhNhanRepo.searchBenhNhan(keyword);
    }

}
