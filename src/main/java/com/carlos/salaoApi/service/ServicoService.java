package com.carlos.salaoApi.service;

import com.carlos.salaoApi.model.Servico;
import com.carlos.salaoApi.repository.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicoService {

    @Autowired
    ServicoRepository repository;
    public Servico salva(Servico servico){
        return repository.save(servico);
    }
}
