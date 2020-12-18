package br.com.alura.subasta.dominio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Subasta {

	private String descripcion;
	private List<Oferta> ofertas;
	
	public Subasta(String descripcion) {
		this.descripcion = descripcion;
		this.ofertas = new ArrayList<Oferta>();
	}
	
	public void propone(Oferta oferta) {
		ofertas.add(oferta);
	}

	public String getDescripcion() {
		return descripcion;
	}

	public List<Oferta> getOfertas() {
		return Collections.unmodifiableList(ofertas);
	}

}
