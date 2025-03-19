/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.tienda.tienda.controller;

import com.tienda.tienda.domain.Producto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.tienda.tienda.service.ProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/practica")
public class PracticaController {
    
     @Autowired
    private ProductoService productoService;

    // Los métodos siguientes son para la prueba de consultas ampliadas
    @GetMapping("/practica")
    public String practica(Model model) {
        var productos = productoService.getProductos(false);
        model.addAttribute("productos", productos);
        return "/practica/practica";
    }
    
    @PostMapping("/query1")
    public String consultaQuery1(@RequestParam(value = "existenciasInf") int existenciasInf,
                                 @RequestParam(value = "existenciasSup") int existenciasSup, 
                                 Model model) {
        var productos = productoService.findByExistenciasBetweenOrderByDescripcion(existenciasInf, existenciasSup);
        model.addAttribute("productos", productos);
        model.addAttribute("existenciasInf", existenciasInf);
        model.addAttribute("existenciasSup", existenciasSup);
        return "/practica/practica";
    }
}
