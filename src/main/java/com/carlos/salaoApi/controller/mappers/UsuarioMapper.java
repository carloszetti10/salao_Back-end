package com.carlos.salaoApi.controller.mappers;

import com.carlos.salaoApi.controller.dto.UsuarioDTO;
import com.carlos.salaoApi.model.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    UsuarioMapper INSTANCE = Mappers.getMapper(UsuarioMapper.class);
    Usuario toEntity(UsuarioDTO dto);
    UsuarioDTO toDTO(Usuario usuario);
}
