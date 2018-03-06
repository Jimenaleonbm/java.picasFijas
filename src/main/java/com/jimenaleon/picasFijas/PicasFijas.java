package com.jimenaleon.picasFijas;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Collections;


public class PicasFijas {

	int picas;
	int fijas;
	String[] numeroAleatorio;
	boolean juegoFinalizado = false;
		
	public PicasFijas() {
		
		this.numeroAleatorio = crearNumeroAleatorio();
		jugar();
	}
	
	PicasFijas(int picas, int fijas) {
		
		this.picas = picas;
		this.fijas = fijas;	
	}
	
	// Package
	PicasFijas(int picas, int fijas, String[] numeroAleatorio) {
		
		this.picas = picas;
		this.fijas = fijas;		
		this.numeroAleatorio = numeroAleatorio;
		
	}
	
	public void jugar() {
		while(!this.juegoFinalizado) {			
			System.out.println("Ingrese un numero de cuatro digitos");
			Scanner scanner = new Scanner(System.in);	
			String datoIngresado = scanner.nextLine();
			//
			if(validarDato(datoIngresado)) {
				String[] numeroAComparar = datoIngresado.split("");
				compararNumero(numeroAComparar);
			}else {
				scanner.close();
				throw new AssertionError("dato invalido");
			}
		}
	}
	
	public boolean validarDato(String cadena) {
		Pattern validacion = Pattern.compile("[0-9]{4}");
		Matcher mat = validacion.matcher(cadena);
		return mat.matches() ? true: false;
	}
	
	public String[] desorganizarLista(){
		
		List<String> numerosPosibles = Arrays.asList("0", "1", "2", "3", "4","5","6","7","8","9");	
		Collections.shuffle(numerosPosibles);
		
		String[] listaRandom = numerosPosibles.toArray(new String[numerosPosibles.size()]);
		return listaRandom;
	}
	
	
	public String[] crearNumeroAleatorio() {
		
		numeroAleatorio = Arrays.copyOf(desorganizarLista(), 4);
		return numeroAleatorio;	
	}
	
	
	public PicasFijas compararNumero(String[] numeroAComparar) {
		
		PicasFijas intento = new PicasFijas(0,0);
		
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				
				if(numeroAleatorio[i].equals(numeroAComparar[j]) && i != j) {
					intento.picas += 1;	
				}
			}
			
			if(numeroAleatorio[i].equals(numeroAComparar[i])) {
				intento.fijas += 1;
			}
		}
		
		System.out.println("Picas: " + intento.picas);
		System.out.println("Fijas: " + intento.fijas);
		
		this.juegoFinalizado = (intento.fijas == 4) ? true : false;

		return intento;
	}

}
