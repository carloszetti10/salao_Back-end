package com.carlos.salaoApi.service;

import com.carlos.salaoApi.controller.dto.AgendaDTO;
import com.carlos.salaoApi.controller.mappers.AgendaMapper;
import com.carlos.salaoApi.model.Agenda;
import com.carlos.salaoApi.repository.AgendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AgendaService {

    @Autowired
    AgendaRepository repository;
    @Autowired
    AgendaMapper mapper;
    public Agenda salvar(Agenda agenda) {
        return repository.save(agenda);
    }

    public List<AgendaDTO> listar(){
       List<Agenda> agendas = repository.findAll();
       List<AgendaDTO> agendaDTOS = new ArrayList<>();
        for (Agenda a: agendas){
            AgendaDTO dto = mapper.toDTO(a);
            agendaDTOS.add(dto);
        }
        return agendaDTOS;
        //agendas.stream().map(AgendaDTO::new).collect(Collectors.toList());
    }
}
