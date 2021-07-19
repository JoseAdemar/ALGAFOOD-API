package com.algaworks.algafood;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;

import javax.validation.ConstraintViolationException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.algaworks.algafood.domain.exception.EntidadeEmUsoException;
import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.service.CadastroCozinhaService;
import com.algaworks.algafood.domain.service.CadastroRestauranteService;

@SpringBootTest
public class CadastroCozinhaIntegracaoTests {

	@Autowired
	CadastroCozinhaService cadastroCozinha;

	@Autowired
	CadastroRestauranteService cadastroRestaurante;

	@Test
	public void deveCadastroCozinhaComSucesso() {
		// cenário

		Cozinha novaCozinha = new Cozinha();
		novaCozinha.setNome("Chinesa");

		// ação

		novaCozinha = cadastroCozinha.salvar(novaCozinha);

		// validação

		assertThat(novaCozinha).isNotNull();
		assertThat(novaCozinha.getId()).isNotNull();

	}

	@Test
	public void testar_cadastro_de_cozinha_sem_nome() {

		// cenário
		Cozinha novaCozinha = new Cozinha();
		novaCozinha.setNome(null);

		// ação
		ConstraintViolationException erroEsperado = Assertions.assertThrows(ConstraintViolationException.class, () -> {
			cadastroCozinha.salvar(novaCozinha);
		});

		// validação
		assertThat(erroEsperado).isNotNull();
	}

	@Test
	public void Salvar_DeveFalhar_QuandoExcluirCozinhaEmUso() {
		Cozinha cozinha = new Cozinha();
		cozinha.setNome("Coreana");
		cozinha = cadastroCozinha.salvar(cozinha);

		Restaurante restaurante = new Restaurante();
		restaurante.setNome("Restaurante coreano");
		restaurante.setTaxaFrete(BigDecimal.TEN);
		restaurante.setCozinha(cozinha);
		restaurante = cadastroRestaurante.salvar(restaurante);

		Long cozinhaEmUsoId = cozinha.getId();

		EntidadeEmUsoException erroEsperado = Assertions.assertThrows(EntidadeEmUsoException.class, () -> {
			cadastroCozinha.excluir(cozinhaEmUsoId);
		});

		assertThat(erroEsperado).isNotNull();
	}

//	@Test
//	public void deveFalhar_QuandoExcluirCozinhaInexistente() {
//       
//		cadastroCozinha.excluir(200L);
//       
//	}

}
