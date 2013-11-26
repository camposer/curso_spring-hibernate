package es.indra.formacion.springhibernate.model;

import java.io.Serializable;
import java.util.Date;

public class Libro implements Serializable {
	private static final long serialVersionUID = 514204529527520683L;

	public static final int TIPO_TAPA_DURA = 0;
	public static final int TIPO_DE_BOLSILLO = 1;
	
	private Integer id;
	private String titulo;
	private String autor;
	private String editorial;
	private Date anio;
	private Integer tipo;
	
	public Libro() { }
	

	public Libro(String titulo, String autor, String editorial,
			Date anio, Integer tipo) {

		this.titulo = titulo;
		this.autor = autor;
		this.editorial = editorial;
		this.anio = anio;
		this.tipo = tipo;
	}

	public Libro(String titulo, String autor, String editorial,
			Date anio) {

		this(titulo, autor, editorial, anio, null);
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getEditorial() {
		return editorial;
	}
	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}
	public Date getAnio() {
		return anio;
	}
	public void setAnio(Date anio) {
		this.anio = anio;
	}
	public Integer getTipo() {
		return tipo;
	}
	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}
	
	@Override
	public String toString() {
		return "Libro [id=" + id + ", titulo=" + titulo + ", autor=" + autor
				+ ", editorial=" + editorial + ", anio=" + anio + ", tipo="
				+ tipo + "]";
	}
}
