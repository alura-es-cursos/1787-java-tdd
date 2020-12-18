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
		int total = getTotalOfertasUsuario(oferta.getUsuario(), ofertas);
		if(ofertas.isEmpty() || 
				esElMismoUsuarioAnterior(oferta.getUsuario())
				&& total < 5) {
			ofertas.add(oferta);
	    }
		
	}
	
	private boolean esElMismoUsuarioAnterior(Usuario usuario) {
		return !ofertas.get(ofertas.size()-1).getUsuario().equals(usuario);
	}
	
	private int getTotalOfertasUsuario(Usuario usuario, List<Oferta> ofertas) {
		int total = 0;
	    for(Oferta l : ofertas) {
	        if(l.getUsuario().equals(usuario)) total++;
	    }
	    return total;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public List<Oferta> getOfertas() {
		return Collections.unmodifiableList(ofertas);
	}

}
