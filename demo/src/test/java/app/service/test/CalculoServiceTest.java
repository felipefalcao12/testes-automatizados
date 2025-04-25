package app.service.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import app.service.CalculoService;

@SpringBootTest
public class CalculoServiceTest {
	
	@Autowired
	CalculoService calculoService;

	@Test
	@DisplayName("Cena 01 - Testando o método somar com valores válidos")
	void cenario01() {
		List<Integer> lista = new ArrayList<>();
		lista.add(3);
		lista.add(5);
		lista.add(2);
		
		int resultadoEsperado = 10;
		int resultadoObtido = this.calculoService.soma(lista);
		
		assertEquals(resultadoEsperado, resultadoObtido);
	}
	

	@Test
	@DisplayName("Cena 02 - Testando o método somar com valores inválidos")
	void cenario02() {
		List<Integer> lista = new ArrayList<>();
		lista.add(3);
		lista.add(null);
		lista.add(2);
				
		assertThrows(Exception.class,() -> {
			this.calculoService.soma(lista);
		});
		
		
	}
	
	
	
	
	@Test
	@DisplayName("Cena 03 - Testar mediana com número par de elementos")
	void cenario03() {
		List<Integer> lista = new ArrayList<>();
		lista.add(3);
		lista.add(2);
		lista.add(3);
		lista.add(4);
		
		assertEquals(3, this.calculoService.mediana(lista));
	}
	
	@Test
	@DisplayName("Cena 04 - Testar mediana com número ímpar de elementos")
	void cenario04() {
		List<Integer> lista = new ArrayList<>();
		lista.add(3);
		lista.add(2);
		lista.add(1);
		lista.add(9);
		lista.add(4);
		
		assertEquals(3, this.calculoService.mediana(lista));
	}
	
	
	@Test
	@DisplayName("Cena 05 - Testar mediana com número ímpar de elementos")
	void cenario05() {
		List<Integer> lista = new ArrayList<>();
		lista.add(8);
		lista.add(2);
		lista.add(1);
		lista.add(9);
		lista.add(39);
		lista.add(339);
		lista.add(4);
		
		assertEquals(8, this.calculoService.mediana(lista));
	}
	
	@Test
	@DisplayName("Cena 06 - Testando o método maiorValor com valores válidos")
	void cenario06() {
	    List<Integer> lista = new ArrayList<>();
	    lista.add(2);
	    lista.add(5);
	    lista.add(1);
	    
	    int resultadoEsperado = 5;
	    int resultadoObtido = this.calculoService.maiorNumero(lista);
	    
	    assertEquals(resultadoEsperado, resultadoObtido);
	}

	@Test
	@DisplayName("Cena 07 - Testando o método maiorValor com lista vazia")
	void cenario07() {
	    List<Integer> lista = new ArrayList<>();
	    
	    assertThrows(IllegalArgumentException.class, () -> {
	        this.calculoService.maiorNumero(lista);
	    });
	}

	@Test
	@DisplayName("Cena 08 - Testando o método maiorValor com valores negativos")
	void cenario08() {
	    List<Integer> lista = new ArrayList<>();
	    lista.add(-10);
	    lista.add(-5);
	    lista.add(-20);
	    
	    int resultadoEsperado = -5; 
	    int resultadoObtido = this.calculoService.maiorNumero(lista);
	    
	    assertEquals(resultadoEsperado, resultadoObtido);
	}
	
	@Test
	@DisplayName("Cena 09 - Testando o método menorValor com valores válidos")
	void cenario09() {
	    List<Integer> lista = new ArrayList<>();
	    lista.add(7);
	    lista.add(3);
	    lista.add(9);
	    
	    int resultadoEsperado = 3;
	    int resultadoObtido = this.calculoService.menorNumero(lista);
	    
	    assertEquals(resultadoEsperado, resultadoObtido);
	}

	@Test
	@DisplayName("Cena 10 - Testando o método menorValor com lista vazia")
	void cenario10() {
	    List<Integer> lista = new ArrayList<>();
	    
	    assertThrows(IllegalArgumentException.class, () -> {
	        this.calculoService.menorNumero(lista);
	    });
	}

	@Test
	@DisplayName("Cena 11 - Testando o método menorValor com valores negativos")
	void cenario11() {
	    List<Integer> lista = new ArrayList<>();
	    lista.add(-10);
	    lista.add(-5);
	    lista.add(-20);
	    
	    int resultadoEsperado = -20; 
	    int resultadoObtido = this.calculoService.menorNumero(lista);
	    
	    assertEquals(resultadoEsperado, resultadoObtido);
	}
	
	@Test
	@DisplayName("Cena 12 - Testando o método multiplicacao com valores válidos")
	void cenario12() {
	    List<Integer> lista = new ArrayList<>();
	    lista.add(2);
	    lista.add(3);
	    lista.add(4);
	    
	    int resultadoEsperado = 24; 
	    int resultadoObtido = this.calculoService.multiplicacao(lista);
	    
	    assertEquals(resultadoEsperado, resultadoObtido);
	}

	@Test
	@DisplayName("Cena 13 - Testando o método multiplicacao com lista vazia")
	void cenario13() {
	    List<Integer> lista = new ArrayList<>();
	    
	    assertThrows(IllegalArgumentException.class, () -> {
	        this.calculoService.multiplicacao(lista);
	    });
	}

	@Test
	@DisplayName("Cena 14 - Testando o método multiplicacao com valor zero")
	void cenario14() {
	    List<Integer> lista = new ArrayList<>();
	    lista.add(5);
	    lista.add(0);
	    lista.add(4);
	    
	    int resultadoEsperado = 0; 
	    int resultadoObtido = this.calculoService.multiplicacao(lista);
	    
	    assertEquals(resultadoEsperado, resultadoObtido);
	}
	
	@Test
	@DisplayName("Cena 15 - Testando o método moda com lista de valores válidos")
	void cenario15() {
	    List<Integer> lista = new ArrayList<>();
	    lista.add(3);
	    lista.add(3);
	    lista.add(5);
	    lista.add(5);
	    lista.add(5);
	    
	    int resultadoEsperado = 5; 
	    int resultadoObtido = this.calculoService.moda(lista);
	    
	    assertEquals(resultadoEsperado, resultadoObtido);
	}

	@Test
	@DisplayName("Cena 16 - Testando o método moda com lista sem moda clara")
	void cenario16() {
	    List<Integer> lista = new ArrayList<>();
	    lista.add(1);
	    lista.add(2);
	    lista.add(3);
	    
	    int resultadoEsperado = 1; 
	    int resultadoObtido = this.calculoService.moda(lista);
	    
	    assertEquals(resultadoEsperado, resultadoObtido);
	}

	@Test
	@DisplayName("Cena 17 - Testando o método moda com lista vazia")
	void cenario17() {
	    List<Integer> lista = new ArrayList<>();
	    
	    assertThrows(IllegalArgumentException.class, () -> {
	        this.calculoService.moda(lista);
	    });
	}
	
	@Test
	@DisplayName("Cena 18 - Testando o método somaAoQuadrado com valores válidos")
	void cenario18() {
	    List<Integer> lista = new ArrayList<>();
	    lista.add(2);
	    lista.add(3);
	    lista.add(1);
	    
	    int resultadoEsperado = 36; 
	    int resultadoObtido = this.calculoService.somaAoQuadrado(lista);
	    
	    assertEquals(resultadoEsperado, resultadoObtido);
	}

	@Test
	@DisplayName("Cena 19 - Testando o método somaAoQuadrado com lista vazia")
	void cenario19() {
	    List<Integer> lista = new ArrayList<>();
	    
	    assertThrows(IllegalArgumentException.class, () -> {
	        this.calculoService.somaAoQuadrado(lista);
	    });
	}

	@Test
	@DisplayName("Cena 20 - Testando o método somaAoQuadrado com valores negativos")
	void cenario20() {
	    List<Integer> lista = new ArrayList<>();
	    lista.add(-2);
	    lista.add(-3);
	    lista.add(-1);
	    
	    int resultadoEsperado = 36; 
	    int resultadoObtido = this.calculoService.somaAoQuadrado(lista);
	    
	    assertEquals(resultadoEsperado, resultadoObtido);
	}


	

}
