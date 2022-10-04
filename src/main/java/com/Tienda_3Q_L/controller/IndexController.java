package com.Tienda_3Q_L.controller;

import com.Tienda_3Q_L.dao.ClienteDao;
import com.Tienda_3Q_L.domain.Cliente;
import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class IndexController {
    
    @Autowired
    private ClienteDao clienteDao;
    
    @GetMapping("/")
    public String inicio(Model model) {        
        log.info("Ahora se usa arquitectura MVC");
        
        Cliente cliente = new Cliente("Jonathan", "Brenes Blanco", "jbrenesbl@gmail.com", "8820-2655");
        //Cliente cliente2 = new Cliente("Alexander", "Lopez Oreamuno", "alopez@gmail.com", "8877-6655");
        
        //var clientes = Arrays.asList(cliente,cliente2);
        
        var clientes = clienteDao.findAll();
        
        model.addAttribute("cliente", cliente);
        
        model.addAttribute("clientes",clientes);

        return "index";
    }
    
}
