package com.carlos.salaoApi.repository;

import com.carlos.salaoApi.model.Permissao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissaoRepository extends JpaRepository<Permissao, Long> {
}
