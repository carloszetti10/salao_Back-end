package com.carlos.salaoApi.model;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InfoColaboradorMes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idInfoFuncionario;

    @ManyToOne
    @JoinColumn(name = "id_colaborador", nullable = false)
    private Colaborador colaborador;

    @Column(nullable = false)
    private LocalDate dataMes;

    @Column
    private Double saldoMes;

    @Column
    private Double saldoPago;

    @Column(name = "pago")
    private Boolean pago;

}
