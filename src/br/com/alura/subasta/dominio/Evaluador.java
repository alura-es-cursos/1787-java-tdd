package br.com.alura.subasta.dominio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.management.RuntimeErrorException;

public class Evaluador {
	
	private double mayorQueTodos = Double.NEGATIVE_INFINITY;
	private double menorQueTodos = Double.POSITIVE_INFINITY;
	private List<Oferta> mayoresOfertas = new ArrayList<Oferta>();
	
	public void evalua(Subasta subasta) {
		if (subasta.getOfertas().isEmpty()) {
			throw new RuntimeException("La subasta no tiene ofertas");
		}
		for (Oferta oferta : subasta.getOfertas()) {
			if (oferta.getValor() > mayorQueTodos) {
				mayorQueTodos = oferta.getValor();
			} 
			if(oferta.getValor() < menorQueTodos) {
				menorQueTodos = oferta.getValor();
			}
			
		}
		mayoresOfertas = new ArrayList<Oferta>(subasta.getOfertas());
		Collections.sort(mayoresOfertas, new Comparator<Oferta>() {
			public int compare(Oferta oferta1, Oferta oferta2) {
				if (oferta1.getValor() < oferta2.getValor()) return 1;
				if (oferta1.getValor() > oferta2.getValor()) return -1;
				return 0;
			}
		});
		mayoresOfertas = mayoresOfertas.subList(0,  3);
	}
	
	

	public double getMayorQueTodos() {
		return mayorQueTodos;
	}

	public double getMenorQueTodos() {
		return menorQueTodos;
	}



	public List<Oferta> getMayoresOfertas() {
		return mayoresOfertas;
	}
	

}
