package com.amil.dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Dados {
	

	
	public static BufferedReader  leArquivo (String path) throws FileNotFoundException{
		BufferedReader br = new BufferedReader(new FileReader(path));
		return br;
	}

}
