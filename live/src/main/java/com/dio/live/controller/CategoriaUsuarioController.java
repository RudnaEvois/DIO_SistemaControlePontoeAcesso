package com.dio.live.controller;

import com.dio.live.model.CategoriaUsuario;
import com.dio.live.model.JornadaTrabalho;
import com.dio.live.service.CategoriaUsuarioService;
import com.dio.live.service.JornadaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/categoria")
public class CategoriaUsuarioController {
    @Autowired
    CategoriaUsuarioService categoriaUsuarioService;

    @PostMapping
    public CategoriaUsuario createCategoria(@RequestBody CategoriaUsuario categoriaUsuario){
        return categoriaUsuarioService.saveCategoria(categoriaUsuario);
    }

    @GetMapping
    public List<CategoriaUsuario> getCategoriaList(){
       return categoriaUsuarioService.findAll();
    }

    @GetMapping("/{idJornada}")
    public ResponseEntity<CategoriaUsuario> getCategoriaById(@PathVariable("idCategoria") Long idCategoria) throws Exception {
        return ResponseEntity.ok(categoriaUsuarioService.getById(idCategoria).orElseThrow(()-> new NoSuchElementException(("Não encontrado!!!"))));

    }
    @PutMapping
    public CategoriaUsuario updateCategoria(@RequestBody CategoriaUsuario categoriaUsuario){
        return categoriaUsuarioService.updateCategoria(categoriaUsuario);
    }
    @DeleteMapping("/{idCategoria}")
    public ResponseEntity deleteById(@PathVariable("idCategoria") Long idCategoria) throws Exception {
        try {
            categoriaUsuarioService.deleteCategoria(idCategoria);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return (ResponseEntity<CategoriaUsuario>) ResponseEntity.ok();

    }

}
