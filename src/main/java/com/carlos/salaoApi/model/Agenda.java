package com.carlos.salaoApi.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "agenda")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Agenda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAgenda;

    @ManyToMany
    @JoinTable(
            name = "agenda_servico", // Nome da tabela intermediária
            joinColumns = @JoinColumn(name = "id_agenda"), // FK para Agenda
            inverseJoinColumns = @JoinColumn(name = "id_servico") // FK para Servico
    )
    @JsonManagedReference
    private List<Servico> servicos = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "id_horario", nullable = false)
    private Horario horario;


    private Boolean concluido = false;


    @ManyToMany
    @JoinTable(
            name = "agenda_colaborador", // Nome da tabela intermediária
            joinColumns = @JoinColumn(name = "id_agenda"),
            inverseJoinColumns = @JoinColumn(name = "id_colaborador")
    )
    private List<Colaborador> colaboradores = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "salao_id")
    private Salao salao;


}

