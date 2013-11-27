package es.indra.formacion.springhibernate.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the OFRECE database table.
 * 
 */
@Entity
@Table(name="OFRECE")
@NamedQuery(name="Ofrece.findAll", query="SELECT o FROM Ofrece o")
public class Ofrece implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Integer id;

	private Double precio;

	//bi-directional many-to-one association to Libreria
	@ManyToOne
	@JoinColumn(name="LIBRERIA_ID", nullable=false)
	private Libreria libreria;

	//bi-directional many-to-one association to Libro
	@ManyToOne
	@JoinColumn(name="LIBRO_ID", nullable=false)
	private Libro libro;

	public Ofrece() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getPrecio() {
		return this.precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Libreria getLibreria() {
		return this.libreria;
	}

	public void setLibreria(Libreria libreria) {
		this.libreria = libreria;
	}

	public Libro getLibro() {
		return this.libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}

}