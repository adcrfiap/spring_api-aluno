package br.com.fiap.cartaoFIAP.dto;

import br.com.fiap.cartaoFIAP.entity.Aluno;
import lombok.Data;

@Data
public class AlunoDTO {

    private  String nome;
    private  Integer rm;
    private  Integer numeroCartao;

    public AlunoDTO(){};

    public AlunoDTO(Aluno aluno) {
        this.nome           = aluno.getNome();
        this.numeroCartao   = aluno.getNumeroCartao();
        this.rm             = aluno.getRm();
    }
}
