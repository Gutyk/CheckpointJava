package com.github.checkpointjava.ms_proposta.dto;

import com.github.checkpointjava.ms_proposta.model.Proposta;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class UserDTO {
    private Long id;
    private String nome;
    private String sobrenome;
    private String cpf;
    private String telefone;
    private BigDecimal renda;
    private List<Long> propostasIds = new ArrayList<>();

    public UserDTO(Long id, List<Proposta> propostas, BigDecimal renda, String telefone, String cpf, String sobrenome, String nome) {
        this.id = id;
        this.renda = renda;
        this.telefone = telefone;
        this.cpf = cpf;
        this.sobrenome = sobrenome;
        this.nome = nome;

        if (propostas != null) {
            this.propostasIds = propostas.stream()
                    .map(Proposta::getId)
                    .collect(Collectors.toList());
        }
    }


}
