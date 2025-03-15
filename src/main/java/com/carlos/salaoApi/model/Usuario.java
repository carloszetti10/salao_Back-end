package com.carlos.salaoApi.model;

import com.carlos.salaoApi.model.enumm.TipoUsuario;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 200)
    private String nome;

    @Column(unique = true, length = 255)
    private String email;

    @Column(length = 255)
    private String senha;

    @Column(length = 15)
    private String telefone;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private TipoUsuario tipoUsuario;

}

