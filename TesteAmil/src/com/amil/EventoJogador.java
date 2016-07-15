package com.amil;

import java.util.Comparator;

public class EventoJogador extends Evento implements Comparator<EventoJogador> {
	Arma armaUsada;
	Jogador killer;

	public Jogador getKiller() {
		return killer;
	}
	public void setKiller(Jogador killer) {
		this.killer = killer;
	}
	public Arma getArmaUsada() {
		return armaUsada;
	}
	public void setArmaUsada(Arma armaUsada) {
		this.armaUsada = armaUsada;
	}
	@Override
	public int compare(EventoJogador eventoJogador1, EventoJogador eventoJogador2) {
		// TODO Auto-generated method stub
		return eventoJogador1.killer.nome.compareTo(eventoJogador2.killer.nome);
	}
	


	
}
