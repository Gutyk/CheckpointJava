package com.github.checkpointjava.ms_proposta.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;

//Luis Gustavo Marques Martins 94577
//Gabriel Dario 95946

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "tb_proposta")
public class Proposta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotNull(message = "Campo requerido")
    private BigDecimal solicitado;

    @Column(nullable = false)
    @NotNull(message = "Campo requerido")
    private Integer meses;

    @Column(nullable = false)
    private Boolean validacao;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
