package br.com.alura.subasta.dominio;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class TestJunitEvaluador {
	
	private Subasta subasta;
	
	@Before
	public void prepararEscenario() {
		System.out.println("PREPARANDO ESCENARIO");
		
		this.subasta = new CreadorDeSubasta().para("TV 55")
				.oferta(new Usuario("Diego"), 300)
				.oferta(new Usuario("Alexiz"), 500)
				.oferta(new Usuario("Daniel"), 700)
				.construir();
	}
	
	// Primer escenario
	@Test
	public void deberiaRetornarElMayorValor() {
		
		// Ejecucion del metodo
		Evaluador evaluador = new Evaluador();
		evaluador.evalua(subasta);
				
		// Verificacion
		assertThat(evaluador.getMayorQueTodos(), equalTo(700.0));
		assertThat(evaluador.getMenorQueTodos(), equalTo(300.0));
	}
	
	// test case de equivalencia
	@Test
	public void deberiaRetornarElMayorValorConNumerosDe5Cifras() {
		
		// Ejecucion -> When
		Evaluador evaluador = new Evaluador();
		evaluador.evalua(subasta);

		// Validacion -> Then
		Assert.assertEquals(300, evaluador.getMenorQueTodos(), 0.0001);
		assertThat(evaluador.getMayorQueTodos(), equalTo(700.0));
	}
	
	@Test
	public void deberiaRetornarLas3MayoresOfertas() {
		// Preparacion
		this.subasta = new CreadorDeSubasta().para("TV 55")
				.oferta(new Usuario("Diego"), 3044.00)
				.oferta(new Usuario("Alexiz"), 50077.00)
				.oferta(new Usuario("Daniel"), 70088.00)
				.oferta(new Usuario("Sandro"), 54333.00)
				.oferta(new Usuario("Eduardo"), 9888.00)
				.construir();
		
		Evaluador evaluador = new Evaluador();
		evaluador.evalua(subasta);
		
		Assert.assertEquals(evaluador.getMayoresOfertas().size(), 3);
		Assert.assertEquals(evaluador.getMayoresOfertas().get(0).getValor(), 70088.00);
		Assert.assertEquals(evaluador.getMayoresOfertas().get(1).getValor(), 54333.00);
		Assert.assertEquals(evaluador.getMayoresOfertas().get(2).getValor(), 50077.00);
	}
	
}
