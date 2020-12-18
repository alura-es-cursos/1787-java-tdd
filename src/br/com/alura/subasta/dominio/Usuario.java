package br.com.alura.subasta.dominio;

public class Usuario {

	private int id;
	private String nombre;
	
	public Usuario(String nombre) {
		this(0, nombre);
	}

	public Usuario(int id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}
	
	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}
	
	
	
}
