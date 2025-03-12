package com.carlos.salaoApi.controller.mappers;

import com.carlos.salaoApi.controller.dto.SalaoDTO;
import com.carlos.salaoApi.model.Salao;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface SalaoMapper {
   SalaoMapper INSTANCE = Mappers.getMapper(SalaoMapper.class);
    Salao toEntity(SalaoDTO dto);
    SalaoDTO toDTO(Salao salao);
}
