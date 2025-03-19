/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.tienda.tienda.controller;

import com.tienda.tienda.domain.Producto;
import com.tienda.tienda.domain.Categoria;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.tienda.tienda.service.ProductoService;
import com.tienda.tienda.service.CategoriaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/producto")
public class ProductoController {
    
     @Autowired
    private ProductoService productoService;
    
    @Autowired
    private CategoriaService categoriaService;
    
    @RequestMapping("/listado")
    public String inicio(Model model) {
        //List<Producto> productos  = productoService.getProductos(false);
        List<Producto> productos = productoService.findByExistencias(5);
        List<Categoria> listaCategoriaActivas  = categoriaService.getCategorias(false);
        
        model.addAttribute("productos", productos);
        model.addAttribute("totalProductos", productos.size());
        model.addAttribute("categorias", listaCategoriaActivas);
        return "/producto/listado";
    }
    
    @GetMapping("/eliminar/{idProducto}")
    public String productoEliminar(Producto producto) {
        productoService.delete(producto);
        return "redirect:/producto/listado";
    }

    @GetMapping("/modificar/{idProducto}")
    public String productoModificar(Producto producto, Model model) {
        producto = productoService.getProducto(producto);
        List<Categoria> listaCategoriaActivas  = categoriaService.getCategorias(false );
        model.addAttribute("producto", producto);
        model.addAttribute("categorias", listaCategoriaActivas);
        return "/producto/modifica";
    }
    
    @GetMapping("/nuevo")
    public String productoNuevo(Producto producto) {
        return "/producto/modifica";
    }
    
    @PostMapping("/guardar")
    public String productoGuardar(Producto producto, Model model){
        productoService.save(producto);
        return "redirect:/producto/listado";
    }
    
   
}
