/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.saks.imobiliaria.controller;

import br.com.saks.imobiliaria.model.TipoImovel;
import br.com.saks.imobiliaria.repository.TipoImovelRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author 7915772
 */
@RestController
@RequestMapping("/tipoImoveis")
public class TipoImovelController {
    
    @Autowired
    private TipoImovelRepository tipoimovelRepository;
    
    //@Cacheable("listarTodos")
    @GetMapping
    public List<TipoImovel> listarTodos() {
        return tipoimovelRepository.findAll();
    }
    
    //@Cacheable("listarPeloId")
    @GetMapping(value="/{id}")
    public Optional<TipoImovel> listarPeloId(@PathVariable Long id) {
        return tipoimovelRepository.findById(id);
    }
    
    @PostMapping
    public TipoImovel adicionar(@RequestBody TipoImovel tipoimovel) {
        return tipoimovelRepository.save(tipoimovel);
    }
    
    @PutMapping(value="/{id}")
    public ResponseEntity editar(@PathVariable Long id, @RequestBody TipoImovel tipoimovel) {
        return tipoimovelRepository.findById(id)
                .map(record -> {
                    record.setNome(tipoimovel.getNome());
                    TipoImovel tipoimovelUpdated = tipoimovelRepository.save(record);
                    return ResponseEntity.ok().body(tipoimovelUpdated);
                }).orElse(ResponseEntity.notFound().build());
    }
    
    @DeleteMapping(value="/{id}")
    public ResponseEntity deletar(@PathVariable Long id) {
        return tipoimovelRepository.findById(id)
                .map(record-> {
                    tipoimovelRepository.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
    
}
