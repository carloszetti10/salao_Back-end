package com.carlos.salaoApi.repository;

import com.carlos.salaoApi.model.Cliente;
import com.carlos.salaoApi.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
