package com.amil;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.amil.dao.Dados;

public class Partida {
	int id;
	Eventos eventos = new Eventos();
	Date inicio;
	Date fim;
	
	public boolean carregaPartida(String path){

		File f = new File(path);
		if(!f.exists()) { 
		    return false;
		}
   		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		BufferedReader br;
		Date dataHoraEvento;
		Jogador killer;
		Jogador killed;
		Arma arma;
		FormaAssassinato forma;
		try {
			br = Dados.leArquivo(path);
			
			while(br.ready()){ 
		   		String linha = br.readLine(); 

		        dataHoraEvento = simpleDateFormat.parse(linha.substring(0,18));
	
		   		if (linha.contains("has started")){
		   			//início da partida
		   			inicio = dataHoraEvento;
			   		id = Integer.parseInt( linha.substring(21).replaceAll("\\D+", ""));
		   			
		   		}
		   		else if (linha.contains("has ended")){
		   			//fim da partida
		   			fim = dataHoraEvento;
		   			System.out.println("partida número: " + id);
		   			System.out.println("Iniciada em : " + (simpleDateFormat.format(inicio)));
	   			
		   			printResultado();
		   			
		   			System.out.println("Terminada em: "+  (simpleDateFormat.format(fim)));	
		   		}
		   		else{
		   			String itens[] = linha.split(" ");
		   			//Evento da partida corrente
		   			if (itens[3].trim().equals(EventoWorld.WORLD)){
		   				killed = new Jogador(itens[5], StatusJogador.morto);
		   				forma = new FormaAssassinato();
		   				forma.setModo(itens[7]);
		   				eventos.adicionarEventoWorld(dataHoraEvento,killed,forma);	
		   			}
		   			else{
		   				killer = new Jogador(itens[3],StatusJogador.vivo);
		   				killed = new Jogador(itens[5],StatusJogador.morto);
		   				arma = new Arma();
		   				arma.setNome(itens[7]);
		   				eventos.adicionarEventoJogador(dataHoraEvento,killer,killed,arma);
		   			}
		   			
		   		}
		   	
		   		
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		return true;
		
	}
	
	public void printResultado(){
		eventos.printResultado();
	}
	
	public int getID() {
		return id;
	}
	public void setID(int Id) {
		id = Id;
	}
	public Eventos getEventos() {
		return eventos;
	}
	public void setEventos(Eventos eventos) {
		this.eventos = eventos;
	}
	public Date getInicio() {
		return inicio;
	}
	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}
	public Date getFim() {
		return fim;
	}
	public void setFim(Date fim) {
		this.fim = fim;
	}
	

}
