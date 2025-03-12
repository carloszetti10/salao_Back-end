package com.carlos.salaoApi.controller.mappers;

import com.carlos.salaoApi.controller.dto.HorarioDTO;
import com.carlos.salaoApi.model.Horario;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface HorarioMapper {

    Horario toHorario(HorarioDTO dto);
    HorarioDTO toDTO(Horario horario);

}
