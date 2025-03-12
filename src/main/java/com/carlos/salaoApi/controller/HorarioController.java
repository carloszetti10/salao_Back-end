package com.carlos.salaoApi.controller;

import com.carlos.salaoApi.controller.dto.HorarioDTO;
import com.carlos.salaoApi.controller.mappers.HorarioMapper;
import com.carlos.salaoApi.model.Horario;
import com.carlos.salaoApi.service.HorarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("horario")
public class HorarioController {

    @Autowired
    private HorarioService horarioService;
    @Autowired
    HorarioMapper mapper;

    @PostMapping
    public List<Horario> salvarHorario(@RequestBody @Valid HorarioDTO dto){
        Horario horario = mapper.toHorario(dto);
        return horarioService.gerarHorariosSemana(horario);
    }
}
