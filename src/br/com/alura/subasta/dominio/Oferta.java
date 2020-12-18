package br.com.alura.subasta.dominio;

public class Oferta {

	private Usuario usuario;
	private double valor;
	
	public Oferta(Usuario usuario, double valor) {
		this.usuario = usuario;
		this.valor = valor;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public double getValor() {
		return valor;
	}
	
	
	
}
