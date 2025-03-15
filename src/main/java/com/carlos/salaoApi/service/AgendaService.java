package com.carlos.salaoApi.service;

import com.carlos.salaoApi.controller.dto.AgendaDTO;
import com.carlos.salaoApi.controller.mappers.AgendaMapper;
import com.carlos.salaoApi.model.Agenda;
import com.carlos.salaoApi.model.Servico;
import com.carlos.salaoApi.repository.AgendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class AgendaService {

    @Autowired
    AgendaRepository repository;
    @Autowired
    AgendaMapper mapper;
    public Agenda salvar(Agenda agenda) {
        //pegar o horario demorado dos serviços
        LocalTime periodoHora = calcularHora(agenda);
        //pegar hora incial para somar com o periodo de tempo
        LocalTime horaInicial = agenda.getHorario().getHoraInicial();
        //somar as horas dos serviços para achar a hora do terminio
        agenda.setHoraTerminio(somarHoras(horaInicial,periodoHora));
        return repository.save(agenda);
    }

    public LocalTime calcularHora(Agenda agenda){
        //pegar os serviços e calcular o horario demorado
        List<Servico> servicos = agenda.getServicos();
        //iniciar a hora com 0
        LocalTime horaSomada = LocalTime.of(0, 0);
        for(Servico s: servicos){
            LocalTime horaDemorada = s.getHoraDemorada();
            // somar horas
            horaSomada = somarHoras(horaSomada, horaDemorada);
        }
        return horaSomada;
    }

    public LocalTime somarHoras(LocalTime hora1, LocalTime hora2) {
        return hora1.plusHours(hora2.getHour())
                .plusMinutes(hora2.getMinute())
                .plusSeconds(hora2.getSecond());
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
