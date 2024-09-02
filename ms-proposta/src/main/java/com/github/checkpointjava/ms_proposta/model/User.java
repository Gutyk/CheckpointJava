package com.github.checkpointjava.ms_proposta.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;


//Luis Gustavo Marques Martins 94577
//Gabriel Dario 95946

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@Entity(name = "User")
@Table(name = "tb_users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotNull(message = "Campo requerido")
    private String nome;

    @Column(nullable = false)
    @NotNull(message = "Campo requerido")
    private String sobrenome;

    @Column(nullable = false, unique = true)
    @NotNull(message = "Campo requerido")
    private String cpf;

    @Column(nullable = false)
    @NotNull(message = "Campo requerido")
    private String telefone;

    @Column(nullable = false)
    @NotNull(message = "Campo requerido")
    private BigDecimal renda;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Proposta> propostas;
}
