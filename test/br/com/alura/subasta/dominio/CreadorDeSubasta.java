package br.com.alura.subasta.dominio;

// Builder de subasta
public class CreadorDeSubasta {
	
	private Subasta subasta;

	public CreadorDeSubasta para(String string) {
		this.subasta = new Subasta(string);
		return this;
	}
	
	public CreadorDeSubasta oferta(Usuario usuario, double valor) {
		this.subasta.propone(new Oferta(usuario, valor));
		return this;
	}

	public Subasta construir() {
		return this.subasta;
	}
	
	

	
	
}
