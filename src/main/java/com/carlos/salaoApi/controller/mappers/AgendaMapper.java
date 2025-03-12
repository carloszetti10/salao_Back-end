package com.carlos.salaoApi.controller.mappers;

import com.carlos.salaoApi.controller.dto.AgendaDTO;
import com.carlos.salaoApi.model.Agenda;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AgendaMapper{

    AgendaMapper INSTANCE = Mappers.getMapper(AgendaMapper.class);

    Agenda toEntity(AgendaDTO dto);

    AgendaDTO toDTO(Agenda agenda);
}
