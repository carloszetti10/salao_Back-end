package com.carlos.salaoApi.model;

import com.carlos.salaoApi.model.enumm.TipoPermissao;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Permissao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(unique = true, nullable = false, length = 50)
    private TipoPermissao nome;

    @ManyToOne
    @JoinColumn(name = "salaoId")
    private Salao salao;


    @ManyToMany
    @JoinTable(
            name = "permissao_colaborador",
            joinColumns = @JoinColumn(name = "id_permissao"),
            inverseJoinColumns = @JoinColumn(name = "id_colaborador")
    )
    private List<Colaborador> colaboradores = new ArrayList<>();
}
