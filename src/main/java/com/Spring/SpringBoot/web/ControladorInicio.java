package com.Spring.SpringBoot.web;

import com.Spring.SpringBoot.servicio.ClienteService;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class ControladorInicio {

    @Autowired
    private ClienteService clienteService;
    @GetMapping("/")
    public String inicio(Model model){

        log.info("Ejecutando el controlador Spring MVC");

        var clientes = clienteService.listarClientes();

        model.addAttribute("clientes", clientes);
        return "index";
    }
}
