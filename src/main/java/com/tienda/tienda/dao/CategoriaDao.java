/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package com.tienda.tienda.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import com.tienda.tienda.domain.Categoria;

/**
 *
 * @author ever1
 */
public interface CategoriaDao extends JpaRepository<Categoria, Long> {

}
