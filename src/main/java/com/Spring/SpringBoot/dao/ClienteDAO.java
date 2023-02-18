package com.Spring.SpringBoot.dao;

import com.Spring.SpringBoot.domain.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteDAO extends CrudRepository<Cliente, Long> {

}
