package br.com.fiap.cartaoFIAP.dto;

import br.com.fiap.cartaoFIAP.entity.Aluno;
import lombok.Data;

@Data
public class AlunoDTO {

    private  String nome;
    private  String rm;
    private  String numeroCartao;

    public AlunoDTO(){};

    public AlunoDTO(Aluno aluno) {
        this.nome           = aluno.getNome();
        this.numeroCartao   = aluno.getNumeroCartao();
        this.rm             = aluno.getRm();
    }
}
