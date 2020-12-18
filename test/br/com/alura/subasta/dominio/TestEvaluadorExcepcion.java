package br.com.alura.subasta.dominio;

import org.junit.Test;

public class TestEvaluadorExcepcion {

	@Test(expected = RuntimeException.class)
	public void deberiaRetornarExcepcionCuanoNoHayOfertas() {
		Subasta subasta = new CreadorDeSubasta().para("TV")
				.construir();

		Evaluador evaluador = new Evaluador();
		evaluador.evalua(subasta);
		
	}
	
}
