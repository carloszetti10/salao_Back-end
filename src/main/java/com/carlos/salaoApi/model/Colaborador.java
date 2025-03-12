package com.carlos.salaoApi.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Colaborador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @Column(unique = true, length = 14)
    private String cpf;

    @ManyToOne
    @JoinColumn(name = "salao_Id") //nullable = false)
    private Salao salao;

    @Column()
    private Boolean ativo;

    @ManyToMany(mappedBy = "colaboradores")
    private List<Permissao> permissaos = new ArrayList<>();

    @ManyToMany(mappedBy = "colaboradores")
    private List<Agenda> agendas = new ArrayList<>();
}
