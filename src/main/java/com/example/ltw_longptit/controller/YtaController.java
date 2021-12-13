package com.example.ltw_longptit.controller;


import com.example.ltw_longptit.model.Yta;
import com.example.ltw_longptit.repo.YtaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController// controller + responbody
@RequestMapping(path = "/yta", produces = "application/json")// anh xa http request
@CrossOrigin(origins = "*")// cho phép gọi api khác máy chủ localhost
public class YtaController {

    @Autowired
    private YtaRepository ytaRepository;

    @GetMapping
    public Iterable<Yta> getAllYta() {

        return ytaRepository.findAll();
    }

    @GetMapping("/{id}")
    public Yta getYtaById(@PathVariable("id") int id) {
        Optional<Yta> yTa = ytaRepository.findById(id);
        if (yTa.isPresent()) {
            return yTa.get();
        }
        return null;
    }

    @PostMapping(consumes = "application/json")
    public Yta createYta(@RequestBody Yta yta) {
        System.out.println(yta.getYtaTen());
        return ytaRepository.save(yta);
    }
    @PutMapping()
    public Yta updateYta(@RequestBody Yta yta) {
        return ytaRepository.save(yta);
    }

    @DeleteMapping("/{id}")
    public void deleteYta(@PathVariable("id") int id) {
               ytaRepository.deleteById(id);
    }

    @GetMapping("/search/{keyword}")
    public Iterable<Yta> searchNurse(@PathVariable("keyword") String keyword) {
        return ytaRepository.searchYta(keyword);
    }
}
