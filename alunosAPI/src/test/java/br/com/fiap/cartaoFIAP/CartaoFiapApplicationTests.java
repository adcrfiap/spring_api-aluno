package br.com.fiap.cartaoFIAP;

import br.com.fiap.cartaoFIAP.entity.Aluno;
import br.com.fiap.cartaoFIAP.repository.AlunoRepository;
import br.com.fiap.cartaoFIAP.service.AlunoService;
import br.com.fiap.cartaoFIAP.service.AlunoServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;

@SpringBootTest
class CartaoFiapApplicationTests {

	@Test
	void contextLoads() {

		AlunoRepository alunoRepository = Mockito.mock(AlunoRepository.class);
		List<Aluno> 	alunos = new ArrayList<>();

		alunos.add(new Aluno());
		alunos.add(new Aluno());
		alunos.add(new Aluno());

		Mockito.when(alunoRepository.findAll()).thenReturn(alunos);

		AlunoService alunoService = new AlunoServiceImpl(alunoRepository);

		assertEquals(alunoService.findAll().size(), 3);

		//Gerar erro no teste
		assertEquals(alunoService.findAll().size(), 2);

	}

}
