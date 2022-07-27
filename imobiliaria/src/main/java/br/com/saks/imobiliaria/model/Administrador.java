/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.saks.imobiliaria.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;

/**
 *
 * @author 7915772
 */
@Data
@Entity
public class Administrador { // implements Serializable
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(length = 100)
    private String nome;
    
    
    @Column(nullable = false, length = 200)
    private String email;
    
    @Column(nullable = false, length = 200)
    private String senha;
    
    private int status;
}
