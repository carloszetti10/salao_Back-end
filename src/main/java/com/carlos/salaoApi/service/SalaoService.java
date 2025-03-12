package com.carlos.salaoApi.service;

import com.carlos.salaoApi.model.Salao;
import com.carlos.salaoApi.repository.SalaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalaoService {

    @Autowired
    SalaoRepository repository;

    public Salao salvar(Salao salao){
        return repository.save(salao);
    }
}