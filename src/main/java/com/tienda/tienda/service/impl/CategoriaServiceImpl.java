/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.tienda.tienda.service.impl;

import com.tienda.tienda.dao.CategoriaDao;
import com.tienda.tienda.domain.Categoria;
import com.tienda.tienda.service.CategoriaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoriaServiceImpl implements CategoriaService{
    
    @Autowired
    private CategoriaDao categoriaDao;
    
    public List<Categoria> getCategorias(boolean activos){
        var lista = categoriaDao.findAll();
        
        if (activos){
            lista.removeIf(c -> c.isActivo());
        }
        return lista;
    }
}
