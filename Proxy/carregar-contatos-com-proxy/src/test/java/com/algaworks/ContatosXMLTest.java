package com.algaworks;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.algaworks.contatos.ContatosXMLProxy;
import com.algaworks.repository.Contatos;

public class ContatosXMLTest {

	@Test
	public void deveRetornarContato() {
		Contatos contatos = new ContatosXMLProxy("contatos1.xml", "contatos2.xml");
		String nome = contatos.buscarPor("jose@email.com");
		assertEquals("José Santos", nome);
	}
	
}
