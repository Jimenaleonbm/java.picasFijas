package com.jimenaleon.picasFijas;

import static org.junit.Assert.assertThat;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;

public class picasFijasTest {


	
	@Test
	public void DosArreglosIgualesSonIgualesACuatroFijasCeroPicas() {
		String[] numeroElejido = {"1","2","3","4"};
		String[] numeroAComparar = {"1","2","3","4"};
		PicasFijas juego = new PicasFijas(0, 0, numeroElejido);
		
		assertThat(juego.compararNumero(numeroAComparar).fijas, is(4));
		assertThat(juego.compararNumero(numeroAComparar).picas, is(0));

	}
	
	@Test
	public void DosArreglosOpuestosSonIgualesACeroFijasCuatroPicas() {
		String[] numeroElejido = {"1","2","3","4"};
		String[] numeroAComparar = {"4","3","2","1"};
		PicasFijas juego = new PicasFijas(0, 0, numeroElejido);

		assertThat(juego.compararNumero(numeroAComparar).fijas, is(0));
		assertThat(juego.compararNumero(numeroAComparar).picas, is(4));
	}
	
	@Test
	public void DosArreglosDiferenteSinPicasYSinFijas() {
		String[] numeroElejido = {"1","2","3","4"};
		String[] numeroAComparar = {"5","6","7","8"};
		PicasFijas juego = new PicasFijas(0, 0, numeroElejido);
		
		assertThat(juego.compararNumero(numeroAComparar).fijas, is(0));
		assertThat(juego.compararNumero(numeroAComparar).picas, is(0));	
	}
	
	@Test
	public void DosArreglosConDosPicasYDosFijas() {
		String[] numeroElejido = {"1","2","3","4"};
		String[] numeroAComparar = {"1","2","4","3"};
		PicasFijas juego = new PicasFijas(0, 0, numeroElejido);
		
		assertThat(juego.compararNumero(numeroAComparar).fijas, is(2));
		assertThat(juego.compararNumero(numeroAComparar).picas, is(2));	
	}
}
