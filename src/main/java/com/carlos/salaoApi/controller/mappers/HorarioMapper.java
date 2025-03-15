package com.carlos.salaoApi.controller.mappers;

import com.carlos.salaoApi.controller.dto.HorarioDTO;
import com.carlos.salaoApi.model.Horario;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface HorarioMapper {

    HorarioMapper INSTANCE = Mappers.getMapper(HorarioMapper.class);
    Horario toHorario(HorarioDTO dto);
    HorarioDTO toDTO(Horario horario);

}
