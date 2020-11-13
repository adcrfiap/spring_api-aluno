package br.com.fiap.cartaoFIAP.dto;

import br.com.fiap.cartaoFIAP.entity.Aluno;
import lombok.Data;

@Data
public class AlunoDTO {

    private  String nome;
    private  String rm;
    private  String num_cartao;

    public AlunoDTO(){};

    public AlunoDTO(Aluno aluno) {
        this.nome           = aluno.getNome();
        this.num_cartao     = aluno.getNumeroCartao();
        this.rm             = aluno.getRm();
    }
}
