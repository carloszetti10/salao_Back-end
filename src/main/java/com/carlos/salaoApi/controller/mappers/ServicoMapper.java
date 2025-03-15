package com.carlos.salaoApi.controller.mappers;

import com.carlos.salaoApi.controller.dto.ServicoDTO;
import com.carlos.salaoApi.model.Servico;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ServicoMapper {
    ServicoMapper INSTANCE = Mappers.getMapper(ServicoMapper.class);
    Servico toEntity(ServicoDTO dto);
    ServicoDTO toDTO(Servico servico);
}
