package br.com.fiap.cartaoFIAP.dto;

import lombok.Data;

@Data
public class MensagemDTO {

    private String mensagem;

    public MensagemDTO(String mensagem) {
        this.mensagem = mensagem;
    }
}
