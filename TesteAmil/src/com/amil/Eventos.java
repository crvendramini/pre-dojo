package com.amil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class Eventos {
	ArrayList <Evento> eventos = new ArrayList<Evento>();
	ArrayList <Jogador> scoreJogador = new ArrayList<Jogador>();


	public void adicionarEventoJogador(Date dataHora, Jogador Killer, Jogador killed, Arma arma){
		EventoJogador eventoJogador = new EventoJogador();
		eventoJogador.setDataHoraEvento(dataHora);
		eventoJogador.setKiller(Killer);
		eventoJogador.setKilled(killed);
		eventoJogador.setArmaUsada(arma);
		eventos.add(eventoJogador);
	}
	
	public void adicionarEventoWorld(Date dataHora, Jogador killed, FormaAssassinato forma){
		EventoWorld eventoWorld = new EventoWorld();
		eventoWorld.setDataHoraEvento(dataHora);
		eventoWorld.setKilled(killed);
		eventoWorld.setFormaAssassinato(forma);
		eventos.add(eventoWorld);
		
	}

	
	public void printResultado(){
		getQtdeVezesJogadorMorreu();
		getQtdeVezesJogadorMatou();
		for(Jogador jog :scoreJogador){
			System.out.println(jog.nome + " matou :" + jog.qtdeKiller + "   e foi morto :" + jog.qtdeKilled );
			
		}

	}
	private void getQtdeVezesJogadorMorreu(){
		int indice = 0;
		Collections.sort(eventos);

		for (Evento ev : eventos){
			if (scoreJogador.isEmpty()){
				scoreJogador.add(eventos.get(0).getKilled());
			}
			if (ev.killed.nome.equals(scoreJogador.get(indice).nome)){
				scoreJogador.get(indice).qtdeKilled++;
				
			}
			else{
				scoreJogador.add(eventos.get(0).getKilled());
				scoreJogador.get(indice).qtdeKilled++;
				indice++;
			}
			
		}
	
	}
	private void getQtdeVezesJogadorMatou(){
		int indice = 0;
		Collections.sort(scoreJogador);
		
		for (Evento ev : eventos){
			if (ev instanceof EventoJogador){
				
				if (scoreJogador.isEmpty()){
					scoreJogador.add(((EventoJogador) ev).getKiller());
				}
				EventoJogador jog = (EventoJogador) ev;
				if (jog.killer.nome.equals(scoreJogador.get(indice).nome)){
					scoreJogador.get(indice).qtdeKiller++;
					
				}
				else{
					jog.killer.qtdeKiller=1;
					scoreJogador.add((jog.getKiller()));
					indice++;
				}
				
			}
			
		}


		
	}
	
	
	public ArrayList<Evento> getEventos() {
		return eventos;
	}

	public void setEventos(ArrayList<Evento> eventos) {
		this.eventos = eventos;
	}
	
	
}
