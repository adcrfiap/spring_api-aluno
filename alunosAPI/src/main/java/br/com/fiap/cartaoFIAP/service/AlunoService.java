package br.com.fiap.cartaoFIAP.service;

import br.com.fiap.cartaoFIAP.dto.AlunoDTO;
import br.com.fiap.cartaoFIAP.entity.Aluno;

import java.util.List;

public interface AlunoService {

    AlunoDTO findByNumeroCartao(String numeroCartao);
    AlunoDTO create(AlunoDTO alunoDTO);
    List<AlunoDTO> findAll();
    Boolean delete( String numeroCartao );


}
