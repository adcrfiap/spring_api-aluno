package br.com.fiap.cartaoFIAP.entity;

import com.mongodb.lang.NonNull;
import lombok.Data;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Document(collection = "alunos")
public class Aluno {

    @Id
    private String id;

    private String rm;

    private  String nome;

    private  String numeroCartao;

    public Aluno() {

    }
}
