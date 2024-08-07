package com.algaworks.service.frete;

import com.algaworks.service.Frete;

public class Normal implements Frete {

	public double calcularPreco(int distancia) {
		return distancia * 1.25 + 10;
	}
	
}
