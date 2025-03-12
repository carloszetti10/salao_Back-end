package com.carlos.salaoApi.controller.mappers;

import com.carlos.salaoApi.controller.dto.AgendaDTO;
import com.carlos.salaoApi.model.Agenda;
//import org.mapstruct.Mapper;

//@Mapper(componentModel = "spring")
public interface AgendaMapper{

    Agenda toEntity(AgendaDTO dto);

    AgendaDTO toDTO(Agenda agenda);
}
