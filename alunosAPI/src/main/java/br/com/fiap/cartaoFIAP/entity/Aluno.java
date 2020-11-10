package br.com.fiap.cartaoFIAP.entity;

import com.mongodb.lang.NonNull;
import lombok.Data;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Document
public class Aluno {

    @Id
    private String id;

    private Integer rm;

    private  String nome;

    @Indexed(
            unique = true
    )
    private  Integer numeroCartao;

    public Aluno() {

    }
}
