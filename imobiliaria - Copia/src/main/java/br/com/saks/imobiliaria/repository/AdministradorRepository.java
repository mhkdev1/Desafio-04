/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.saks.imobiliaria.repository;

import br.com.saks.imobiliaria.model.Administrador;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author 7915772
 */
public interface AdministradorRepository extends JpaRepository<Administrador, Long> {
    
}
