package com.dio.live.controller;

import com.dio.live.model.BancoHoras;
import com.dio.live.model.JornadaTrabalho;
import com.dio.live.service.BancoHorasService;
import com.dio.live.service.JornadaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/bancohoras")
public class BancoHorasController {
    @Autowired
    BancoHorasService bancoHorasService;

    @PostMapping
    public BancoHoras createBancoHoras(@RequestBody BancoHoras bancoHoras){
        return bancoHorasService.saveBanco(bancoHoras);
    }

    @GetMapping
    public List<BancoHoras> getJornadaList(){
       return bancoHorasService.findAll();
    }

    @GetMapping("/{idBancoHoras}")
    public ResponseEntity<BancoHoras> getBancoById(@PathVariable("idBanco") Long idBanco) throws Exception {
        return ResponseEntity.ok(bancoHorasService.getById(idBanco).orElseThrow(()-> new NoSuchElementException(("Não encontrado!!!"))));

    }
    @PutMapping
    public BancoHoras updateBancoHoras(@RequestBody BancoHoras bancoHoras){
        return bancoHorasService.updateBancoHoras(bancoHoras);
    }
    @DeleteMapping("/{idBanco}")
    public ResponseEntity deleteById(@PathVariable("idBanco") Long idBanco) throws Exception {
        try {
            bancoHorasService.deleteBancoHoras(idBanco);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return (ResponseEntity<BancoHoras>) ResponseEntity.ok();

    }

}
