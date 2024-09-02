package com.github.checkpointjava.ms_proposta.dto;

import com.github.checkpointjava.ms_proposta.model.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class PropostaDTO {
    private Long id;
    private BigDecimal solicitado;
    private Integer meses;
    private Boolean validacao;
    private Long userId;

    public PropostaDTO(Long id, BigDecimal solicitado, Integer meses, Boolean aprovado, User user) {
        this.id = id;
        this.solicitado = solicitado;
        this.meses = meses;
        this.validacao = aprovado;
        this.userId = user.getId();
    }
}

