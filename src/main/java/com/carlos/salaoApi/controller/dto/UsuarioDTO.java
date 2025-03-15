package com.carlos.salaoApi.controller.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record UsuarioDTO(
        @NotBlank(message = "O nome não pode ser nulo.")
        @Pattern(regexp = "^[A-Za-zÀ-ÖØ-öø-ÿ]+\\s[A-Za-zÀ-ÖØ-öø-ÿ]+.*$", message = "O nome deve conter pelo menos um nome e um sobrenome")
        String nome,
        // @NotBlank(message = "O e-mail não pode ser nulo.")
        @Email(message = "O e-mail deve estar no formato correto.")
        String email,
        //@NotBlank(message = "A senha não pode ser nula.")
        String senha,

        @Pattern(regexp = "\\d{10,11}", message = "O telefone deve ter 10 ou 11 dígitos")
        String telefone
) {
}
