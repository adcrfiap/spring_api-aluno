package br.com.fiap.cartaoFIAP.repository;

import br.com.fiap.cartaoFIAP.entity.Aluno;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AlunoRepository extends MongoRepository<Aluno, String> {

    Aluno findByNumeroCartao(Integer numeroCartao);
    List<Aluno> findAll();
}
