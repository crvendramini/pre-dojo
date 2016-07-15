package com.amil;


import java.util.Date;

public abstract class Evento implements Comparable<Evento> {

	Jogador killed;

	Date dataHoraEvento;



	public Evento() {
		super();
	}

	public Jogador getKilled() {
		return killed;
	}

	public void setKilled(Jogador killed) {
		this.killed = killed;
	}
	

	public Date getDataHoraEvento() {
		return dataHoraEvento;
	}

	public void setDataHoraEvento(Date dataHoraEvento) {
		this.dataHoraEvento = dataHoraEvento;
	}

	public int compareTo(Evento compareEvento){
		return (this.killed.nome).compareTo(compareEvento.killed.nome);
	}
	


}