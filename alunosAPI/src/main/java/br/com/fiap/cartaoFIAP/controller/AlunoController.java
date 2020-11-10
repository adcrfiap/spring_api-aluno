package br.com.fiap.cartaoFIAP.controller;

import br.com.fiap.cartaoFIAP.dto.AlunoDTO;
import br.com.fiap.cartaoFIAP.dto.MensagemDTO;
import br.com.fiap.cartaoFIAP.service.AlunoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("alunos")
public class  AlunoController {

    private  final AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @GetMapping()
    public ResponseEntity<List<AlunoDTO>> listAll(){
        try {
            return new ResponseEntity(alunoService.findAll(), HttpStatus.OK);

        }catch( Exception e ){
            return new ResponseEntity((MultiValueMap)null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


    @GetMapping("{numeroCartao}")
    public ResponseEntity<AlunoDTO> findByNumeroCartao(@PathVariable Integer numeroCartao){
        try {
            return new ResponseEntity(alunoService.findByNumeroCartao(numeroCartao),
                    HttpStatus.OK);
        }catch( Exception e ){
            return new ResponseEntity(new MensagemDTO("Nenhum registro encontrado!"),
                    HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<AlunoDTO> create(@RequestBody AlunoDTO alunoDTO){

        try {
            return new ResponseEntity(alunoService.create(alunoDTO),
                    HttpStatus.OK);
        }catch( Exception e ){
            return new ResponseEntity(new MensagemDTO("Não foi possivel criar o registro"),
                                      HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("{numeroCartao}")
    public ResponseEntity deleteByNumeroCartao(@PathVariable Integer numeroCartao){

        if( alunoService.delete(numeroCartao)){
            return new ResponseEntity(new MensagemDTO("Registro removido"),
                    HttpStatus.OK);
        }else {
            return new ResponseEntity(new MensagemDTO("Não foi possivel remover o registro"),
                    HttpStatus.BAD_REQUEST);
        }

    }

}
