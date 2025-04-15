
import com.tienda.tienda.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.tienda.tienda.service.ItemService; 
import org.springframework.web.servlet.ModelAndView;
import com.tienda.tienda.domain.Item;


@Controller
public class IndexController {
    
    @Autowired
    ProductoService productoService;
    
    @RequestMapping("/")
    public String page(Model model) { 
        var listaProductos = productoService.getProductos(true);
        model.addAttribute("productos", listaProductos);
        return "index";
    }
	
	@Autowired
    private ItemService itemService;
	
	@RequestMapping("/refrescarBoton")
    public ModelAndView refrescarBoton(Model model) { 
        var lista = itemService.gets();
        var totalCarritos = 0;
        var carritoTotalVenta = 0;
        for (Item i : lista) {
            totalCarritos += i.getCantidad();
            carritoTotalVenta += (i.getCantidad() * i.getPrecio());
        }
        model.addAttribute("listaItems", lista);
        model.addAttribute("listaTotal", totalCarritos);
        model.addAttribute("carritoTotal", carritoTotalVenta);
        return new ModelAndView("/carrito/fragmentos :: verCarrito");
    }    
}
