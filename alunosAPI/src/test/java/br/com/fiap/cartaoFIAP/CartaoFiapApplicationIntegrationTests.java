package br.com.fiap.cartaoFIAP;

import br.com.fiap.cartaoFIAP.entity.Aluno;
import br.com.fiap.cartaoFIAP.repository.AlunoRepository;
import br.com.fiap.cartaoFIAP.service.AlunoService;
import br.com.fiap.cartaoFIAP.service.AlunoServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.MockMvcPrint;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class CartaoFiapApplicationIntegrationTests {

	@Autowired
	private AlunoRepository alunoRepository;

	@Autowired
	private MockMvc mockMvc;


	@Test
	void contextLoads() throws Exception {

		AlunoService alunoService = new AlunoServiceImpl(alunoRepository);

		Aluno aluno = new Aluno();
		aluno.setId("123456");
		aluno.setNumeroCartao("999999");

		//Inserir registor de teste na base de dados
		alunoService.delete(aluno.getNumeroCartao());
		alunoRepository.save(aluno);

		//Verifica se registro foi inserido com sucesso
		this.mockMvc.perform(MockMvcRequestBuilders.get("/alunos/"+aluno.getNumeroCartao())
		.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
		.andDo(MockMvcResultHandlers.print())
		.andExpect(MockMvcResultMatchers.status().isOk());

		//Remover dados de teste da base
		this.mockMvc.perform(MockMvcRequestBuilders.delete("/alunos/"+aluno.getNumeroCartao())
				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
				.andDo(MockMvcResultHandlers.print())
				.andExpect(MockMvcResultMatchers.status().isOk());

	}

}
