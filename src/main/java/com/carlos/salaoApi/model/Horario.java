package com.carlos.salaoApi.model;

import com.carlos.salaoApi.model.enumm.DiaSemana;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "horario_agendamento")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Horario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalTime horaInicial;

    @Column(nullable = false)
    private LocalDate data;

    @Column(nullable = false)
    private Integer quantidadeDisponivel;

    @Column
    private Boolean disponivel = true;

    @ManyToOne
    @JoinColumn(name = "salao_Id") //nullable = false)
    private Salao salao;

    @ElementCollection
    @CollectionTable(
            name = "horario_dias",
            joinColumns = @JoinColumn(name = "horario_id"))
    @Column(name = "dia_semana")
    @Enumerated(EnumType.STRING)  // Armazena como texto
    private List<DiaSemana> diasDaSemana;
}
