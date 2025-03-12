package com.carlos.salaoApi.controller.dto;

import com.carlos.salaoApi.model.enumm.DiaSemana;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.time.LocalTime;
import java.util.List;

public record HorarioDTO(

        @NotNull(message = "Campo obrigatório")
        @JsonFormat(pattern = "HH:mm")
        LocalTime horaInicial,
        @NotNull(message = "Campo obrigatório")
        @Min(value = 1, message = "Quantidade deve ser maior que um")
        Integer quantidadeDisponivel,
        @NotNull(message = "Campo obrigatório")
        List<DiaSemana> diasDaSemana) {
}
