package com.carlos.salaoApi.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 255)
    private String rua;

    @Column(length = 10)
    private String numero;

    @Column(length = 100)
    private String bairro;

    @Column(nullable = false, length = 100)
    private String cidade;

    @Column(length = 50)
    private String estado;

    @Column(length = 10)
    private String cep;

    @OneToOne(mappedBy = "endereco")
    private Cliente cliente;

    @OneToOne(mappedBy = "endereco")
    private Salao salao;


}

