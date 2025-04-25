package app.service;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.dto.Entrada;
import app.entity.Calculo;
import app.repository.CalculoRepository;

@Service
public class CalculoService {

	@Autowired
	private CalculoRepository calculoRepository;

	public Calculo calcular(Entrada entrada) {

		Calculo calculo = new Calculo();
		calculo.setLista(entrada.getLista());
		calculo.setSoma(this.soma(entrada.getLista()));
		calculo.setMedia(this.media(entrada.getLista()));
		calculo.setMediana(this.mediana(entrada.getLista()));
		calculo.setMaiorNumero(this.maiorNumero(entrada.getLista()));
		calculo.setMenorNumero(this.menorNumero(entrada.getLista()));
		calculo.setModa(this.moda(entrada.getLista()));
		calculo.setSomaAoQuadrado(this.somaAoQuadrado(entrada.getLista()));
		return calculo;

	}


	public int soma(List<Integer> lista) {
		int soma = 0;
		for (int i = 0; i < lista.size(); i++) {
			if(lista.get(i) == null)
				throw new RuntimeException("dslçfjakd");
			else
				soma += lista.get(i);
		}
		return soma;
	}


	public double media(List<Integer> lista) {
		return this.soma(lista) / lista.size();
	}


	public double mediana(List<Integer> lista) {
		if (lista == null || lista.isEmpty()) {
	        throw new IllegalArgumentException("A lista não pode ser nula ou vazia");
	    }
		
		Collections.sort(lista);

	    if (lista.size() % 2 == 1) { //ÍMPAR
	        return lista.get(lista.size() / 2);
	    } else {
	        int meio1 = lista.get(lista.size() / 2 - 1);
	        int meio2 = lista.get(lista.size() / 2);
	        return (meio1 + meio2) / 2;
	    }
	}
	
	public int maiorNumero(List<Integer> lista) {
		if (lista == null || lista.isEmpty()) {
			throw new IllegalArgumentException("A lista não pode ser nula ou vazia");
		}

		int maior = lista.get(0);
		for (int i = 1; i < lista.size(); i++) {
			if (lista.get(i) > maior) {
				maior = lista.get(i);
			}
		}
		return maior;
	}
	
	public int menorNumero(List<Integer> lista) {
		if (lista == null || lista.isEmpty()) {
			throw new IllegalArgumentException("A lista não pode ser nula ou vazia");
		}

		int menor = lista.get(0);
		for (int i = 1; i < lista.size(); i++) {
			if (lista.get(i) < menor) {
				menor = lista.get(i);
			}
		}
		return menor;
	}
	
	public int moda(List<Integer> lista) {
		if (lista == null || lista.isEmpty()) {
			throw new IllegalArgumentException("A lista não pode ser nula ou vazia");
		}

		Map<Integer, Integer> frequencia = new HashMap<>();
		for (Integer numero : lista) {
			frequencia.put(numero, frequencia.getOrDefault(numero, 0) + 1);
		}

		int moda = lista.get(0);
		int maxFrequencia = 1;

		for (Map.Entry<Integer, Integer> entry : frequencia.entrySet()) {
			if (entry.getValue() > maxFrequencia) {
				moda = entry.getKey();
				maxFrequencia = entry.getValue();
			}
		}

		return moda;
	}
	
	public int multiplicacao(List<Integer> lista) {
		if (lista == null || lista.isEmpty()) {
			throw new IllegalArgumentException("A lista não pode ser nula ou vazia");
		}

		int resultado = 1;
		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i) == null)
				throw new RuntimeException("Valor nulo encontrado na lista");
			else
				resultado *= lista.get(i);
		}

		return resultado;
	}
	
	public int somaAoQuadrado(List<Integer> lista) {
		if (lista == null || lista.isEmpty()) {
			throw new IllegalArgumentException("A lista não pode ser nula ou vazia");
		}

		int soma = this.soma(lista);
		return soma * soma;
	}

}
