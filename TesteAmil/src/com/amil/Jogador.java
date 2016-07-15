/**
 * 
 */
package com.amil;

/**
 * @author Carlos
 *
 */
public class Jogador implements Comparable<Jogador> {
	String nome;
	StatusJogador statusJogador;
	int qtdeKilled = 0;
	int qtdeKiller = 0;
	

	public Jogador(String nome, StatusJogador statusJogador) {
		super();
		this.nome = nome;
		this.statusJogador = statusJogador;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public StatusJogador getStatusJogador() {
		return statusJogador;
	}
	
	public void setStatusJogador(StatusJogador statusJogador) {
		this.statusJogador = statusJogador;
	}
	
	
	public int getQtdeKilled() {
		return qtdeKilled;
	}

	public void setQtdeKilled(int qtdeKilled) {
		this.qtdeKilled = qtdeKilled;
	}

	public int getQtdeKiller() {
		return qtdeKiller;
	}

	public void setQtdeKiller(int qtdeKiller) {
		this.qtdeKiller = qtdeKiller;
	}

	@Override
	public String toString() {
		return "Jogador [nome=" + nome + ", statusJogador=" + statusJogador + "]";
	}

	@Override
	public int compareTo(Jogador o) {
		// TODO Auto-generated method stub
		return this.nome.compareTo(o.nome);
	}

	
}
