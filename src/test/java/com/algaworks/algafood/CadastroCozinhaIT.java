package com.algaworks.algafood;

import static org.hamcrest.Matchers.hasSize;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class CadastroCozinhaIT {
   
	@LocalServerPort
	private int port;
	
	@BeforeEach
	public void setUp() {
		RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
		RestAssured.port = port;
		RestAssured.basePath = "/cozinhas";
	}
	
	
	@Test
	public void deveRetornarStatus200_quandoConsultarCozinha() {
		 
	     RestAssured.given()
	     .accept(ContentType.JSON)
	     .when()
	     .get()
	     .then()
	     .statusCode(HttpStatus.OK.value());
	}
	
	
	@Test
	public void deveConter4Cozinhas_QuandoConsultarCozinhas() {
		
		RestAssured.given()
			.accept(ContentType.JSON)
		    .when()
			.get()
		    .then()
			.body("", hasSize(4));
//			.body("nome", hasItems("Indiana", "Tailandesa"));
	}
}