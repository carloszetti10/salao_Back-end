package com.carlos.salaoApi.controller.mappers;

import com.carlos.salaoApi.controller.dto.UsuarioDTO;
import com.carlos.salaoApi.model.Usuario;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    Usuario toEntity(UsuarioDTO dto);
    UsuarioDTO toDTO(Usuario usuario);
}
