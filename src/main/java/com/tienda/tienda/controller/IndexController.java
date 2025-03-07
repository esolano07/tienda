
package com.tienda.tienda.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author ever1
 */
@Controller
public class IndexController {

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("attribute", "value");
        return "index";
    }
    
    @RequestMapping("/informacion")
    public String informacion(Model model) {
        model.addAttribute("attribute", "value");
        return "contacto";
    }

}
