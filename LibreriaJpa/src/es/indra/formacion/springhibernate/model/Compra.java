package es.indra.formacion.springhibernate.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the COMPRA database table.
 * 
 */
@Entity
@Table(name="COMPRA")
@NamedQuery(name="Compra.findAll", query="SELECT c FROM Compra c")
public class Compra implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Integer id;

	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	private Date fecha;

	@Column(nullable=false)
	private Double montante;

	//bi-directional many-to-one association to Lector
	@ManyToOne
	@JoinColumn(name="LECTOR_ID", nullable=false)
	private Lector lector;

	//bi-directional many-to-one association to Libreria
	@ManyToOne
	@JoinColumn(name="LIBRERIA_ID", nullable=false)
	private Libreria libreria;

	//bi-directional many-to-one association to Libro
	@ManyToOne
	@JoinColumn(name="LIBRO_ID", nullable=false)
	private Libro libro;

	public Compra() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Double getMontante() {
		return this.montante;
	}

	public void setMontante(Double montante) {
		this.montante = montante;
	}

	public Lector getLector() {
		return this.lector;
	}

	public void setLector(Lector lector) {
		this.lector = lector;
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