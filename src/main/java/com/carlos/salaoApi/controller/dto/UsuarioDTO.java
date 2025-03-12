package com.carlos.salaoApi.controller.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UsuarioDTO(
        @NotBlank(message = "O nome não pode ser nulo.")
        String nome,
        @NotBlank(message = "O e-mail não pode ser nulo.")
        @Email(message = "O e-mail deve estar no formato correto.")
        String email,
        @NotBlank(message = "A senha não pode ser nula.")
        String senha,
        String telefone
) {
}
