package com.carlos.salaoApi.controller.dto;

import com.carlos.salaoApi.model.Agenda;
import com.carlos.salaoApi.model.Cliente;
import com.carlos.salaoApi.model.Salao;
import com.carlos.salaoApi.model.Servico;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public record AgendaDTO(
        @NotNull(message = "O cliente não pode ser nulo")
        Cliente cliente,
        @NotEmpty(message = "A lista de serviços não pode estar vazia")
        List<Servico> servicos,
        @NotNull(message = "Campo obrigatório")
        @JsonFormat(pattern = "HH:mm")
        LocalTime horaMarcada,
        @NotNull(message = "Campo obrigatório")
        @JsonFormat(pattern = "yyyy-MM-dd")
        LocalDate dataMarcada
        ){
}
