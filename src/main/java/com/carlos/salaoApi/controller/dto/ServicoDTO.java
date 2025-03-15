package com.carlos.salaoApi.controller.dto;

import com.carlos.salaoApi.model.Servico;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalTime;

public record ServicoDTO(
        @NotBlank(message = "Campo obrigatorio")
        String nome,
        String imagemUrl,
        @Positive
        double valor,
        @NotNull(message = "Campo obrigatorio")
        LocalTime horaDemorada,
        int porcentagemColab) {
}
