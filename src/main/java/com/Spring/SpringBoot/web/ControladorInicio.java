package com.Spring.SpringBoot.web;

import com.Spring.SpringBoot.domain.Cliente;
import com.Spring.SpringBoot.servicio.ClienteService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class ControladorInicio {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/")
    public String inicio(Model model, @AuthenticationPrincipal User user){

        log.info("Ejecutando el controlador Spring MVC");
        log.info("Usuario que hizo login: "+ user);

        var clientes = clienteService.listarClientes();
        var saldoTotal = 0D;

        for (var p: clientes) {
            saldoTotal += p.getSaldo();
        }

        model.addAttribute("clientes", clientes);
        model.addAttribute("saldoTotal", saldoTotal);
        model.addAttribute("totalClientes", clientes.size());
        return "index";
    }
    @GetMapping("/agregar")
    public String agregar(Cliente cliente){
        return "modificar";
    }
    @PostMapping("/guardar")
    public String guardar(@Valid Cliente cliente, Errors errors){
        if(errors.hasErrors()){
            return "modificar";
        }
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
