package com.Spring.SpringBoot.web;

import com.Spring.SpringBoot.domain.Cliente;
import com.Spring.SpringBoot.servicio.ClienteService;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
    @GetMapping("/agregar")
    public String agregar(Cliente cliente){
        return "modificar";
    }
    @PostMapping("/guardar")
    public String guardar(Cliente cliente){
        clienteService.guardar(cliente);
        return "redirect:/";
    }
    @GetMapping("/editar/{id_cliente}")
    public String editar(Cliente cliente, Model model){
        cliente = clienteService.encontrarCliente(cliente);
        model.addAttribute("cliente", cliente);
        return "modificar";
    }
    @GetMapping("/eliminar")
    public String eliminar(Cliente cliente){
        clienteService.eliminar(cliente);
        return "redirect:/";
    }
}
