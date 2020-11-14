package br.com.fiap.cartaoFIAP.service;

import br.com.fiap.cartaoFIAP.dto.AlunoDTO;
import br.com.fiap.cartaoFIAP.entity.Aluno;
import br.com.fiap.cartaoFIAP.repository.AlunoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlunoServiceImpl implements AlunoService{

    private final AlunoRepository alunoRepository;

    public AlunoServiceImpl(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }


    @Override
    public AlunoDTO findByNumeroCartao(String numeroCartao) {

        return new AlunoDTO(
                alunoRepository.findByNumeroCartao(numeroCartao)
        );
    }

    @Override
    public AlunoDTO create(AlunoDTO alunoDTO) {
        Aluno aluno = new Aluno();

        aluno.setNome(alunoDTO.getNome());
        aluno.setNumeroCartao(alunoDTO.getNumeroCartao());
        aluno.setRm(alunoDTO.getRm());

        Aluno savedAluno = alunoRepository.save(aluno);

        return new AlunoDTO(savedAluno);
    }

    @Override
    public List<AlunoDTO> findAll() {
        return alunoRepository.findAll()
                .stream()
                .map( aluno -> new AlunoDTO(aluno))
                .collect(Collectors.toList());
    }

    @Override
    public Boolean delete(String numeroCartao) {

        Aluno aluno = alunoRepository.findByNumeroCartao(numeroCartao);

        if(aluno != null){
            alunoRepository.delete(aluno);
            return true;
        }else{
            return false;
        }
    }
}
