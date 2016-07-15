package com.amil.test;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.amil.Partida;


public class TesteJogo {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testCarregaPartida() {
		
		Partida partida = new Partida();
		
		Assert.assertEquals("Arquivo precisa existir", true, !partida.carregaPartida("C://arquivonaoexiste"));
		Assert.assertEquals("Arquivo precisa conter dados válidos", true, !partida.carregaPartida("c://jogo//logJogoInvalido.txt"));
		Assert.assertEquals("Este teste é esperado sucesso", false, !partida.carregaPartida("c://jogo//logJogo.txt"));
	}

	@Test
	public void testSetEventos() {
		fail("Not yet implemented");
	}

}
