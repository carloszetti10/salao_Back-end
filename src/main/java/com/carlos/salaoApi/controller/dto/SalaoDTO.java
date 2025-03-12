package com.carlos.salaoApi.controller.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record SalaoDTO(
        @NotBlank(message = "campo obrigatorio")
        @Size(min = 5, message = "O nome deve ter pelo menos 5 caracteres")
        String nome
) {
}
