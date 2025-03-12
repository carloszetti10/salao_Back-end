package com.carlos.salaoApi.controller.mappers;

import com.carlos.salaoApi.controller.dto.ServicoDTO;
import com.carlos.salaoApi.model.Servico;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ServicoMapper {
    Servico toEntity(ServicoDTO dto);
    ServicoDTO toDTO(Servico servico);
}
