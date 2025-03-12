package com.carlos.salaoApi.repository;

import com.carlos.salaoApi.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
}
