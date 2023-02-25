package com.Spring.SpringBoot.dao;

import com.Spring.SpringBoot.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
//otra forma de hacerlo con --->   import org.springframework.data.repository.CrudRepository;

public interface ClienteDAO extends JpaRepository<Cliente, Long> {

}
