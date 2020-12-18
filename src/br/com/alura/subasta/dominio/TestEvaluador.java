package br.com.alura.subasta.dominio;

public class TestEvaluador {
	
	public static void main(String[] args) {
		
		Usuario diego = new Usuario(1, "Diego");
		Usuario alexiz = new Usuario(2, "Alexiz");
		Usuario daniel = new Usuario(3, "Daniel");
		
		Oferta oferta1 = new Oferta(diego, 300.00);
		Oferta oferta2 = new Oferta(alexiz, 500.00);
		Oferta oferta3 = new Oferta(daniel, 700.00);
		
		Subasta subasta = new Subasta("Auto del anho");
		subasta.propone(oferta1);
		subasta.propone(oferta2);
		subasta.propone(oferta3);
		
		Evaluador evaluador = new Evaluador();
		evaluador.evalua(subasta);
		
		System.out.println(evaluador.getMayorQueTodos());
		System.out.println(evaluador.getMenorQueTodos());
		
		
	}

}
