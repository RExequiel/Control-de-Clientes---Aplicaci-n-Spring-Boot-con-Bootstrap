package com.Spring.SpringBoot.servicio;

import com.Spring.SpringBoot.domain.Cliente;

import java.util.List;

public interface ClienteService {
    public List<Cliente> listarClientes();

    public void guardar(Cliente cliente);
    public void eliminar(Cliente cliente);
    public Cliente encontrarCliente(Cliente cliente);
}
