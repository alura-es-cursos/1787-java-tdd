package br.com.alura.subasta.dominio;

import org.junit.Test;

import junit.framework.Assert;

public class TestJunitNuevasReglasNegocio {

	// Regla 1: Un usuario no puede hacer 2 ofertas consecutivas
	// Regla 2: Un usuario no puede hacer mas de 5 ofertas
	
	@Test
	public void deberiaAceptarSolo1OfertaConsecutiva() {
		// Preparacion
		Usuario alexiz = new Usuario(2, "Alexiz");
		Oferta oferta1 = new Oferta(alexiz, 3000.00);
		Oferta oferta2 = new Oferta(alexiz, 50077.00);
		
		// Ejecucion
		Subasta subasta = new Subasta("Auto del anho");
		subasta.propone(oferta1);
		subasta.propone(oferta2);
		
		// Verificacion
		Assert.assertEquals(subasta.getOfertas().size(), 1);
	}
	
	@Test
	public void deberiaAceptar5ofertasComoMaximo() {
		// given
		int cantidadMaximaAceptada = 10;
		
		Usuario alexiz = new Usuario(2, "Alexiz");
		Usuario diego = new Usuario(1, "Diego");
		

		Oferta oferta1 = new Oferta(alexiz, 3000.00);
		Oferta oferta2 = new Oferta(diego, 50077.00);
		Oferta oferta3 = new Oferta(alexiz, 3000.00);
		Oferta oferta4 = new Oferta(diego, 50077.00);
		Oferta oferta5 = new Oferta(alexiz, 3000.00);
		Oferta oferta6 = new Oferta(diego, 50077.00);
		Oferta oferta7 = new Oferta(alexiz, 3000.00);
		Oferta oferta8 = new Oferta(diego, 50077.00);
		Oferta oferta9 = new Oferta(alexiz, 3000.00);
		Oferta oferta10 = new Oferta(diego, 50077.00);
		Oferta oferta11 = new Oferta(alexiz, 3000.00);
		
		// when
		Subasta subasta = new Subasta("Auto del anho");
		subasta.propone(oferta1);
		subasta.propone(oferta2);
		subasta.propone(oferta3);
		subasta.propone(oferta4);
		subasta.propone(oferta5);
		subasta.propone(oferta6);
		subasta.propone(oferta7);
		subasta.propone(oferta8);
		subasta.propone(oferta9);
		subasta.propone(oferta10);
		subasta.propone(oferta11);
		
		// then
		Assert.assertEquals(subasta.getOfertas().size(), cantidadMaximaAceptada);
		
	}
	
	
}
