package com.carlos.salaoApi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Servico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idServico;

    @Column
    @NotNull(message = "O nome não pode ser nulo.")
    private String nome;

    @Column
    private LocalTime horaDemorada;

    @Column(nullable = false)
    private double valor;

    @Column(nullable = false)
    private int porcentagemFuncionario;

    @Column(nullable = true)
    private String imagemUrl;  // Armazenar o caminho da imagem ou URL

    @ManyToOne
    @JoinColumn(name = "id_salao")
    private Salao salao;

    @ManyToMany(mappedBy = "servicos")
    @JsonIgnore
    private List<Agenda> agendas = new ArrayList<>();
}

