package es.indra.formacion.springhibernate.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the LIBRERIA database table.
 * 
 */
@Entity
@Table(name="LIBRERIA")
@NamedQuery(name="Libreria.findAll", query="SELECT l FROM Libreria l")
public class Libreria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(nullable=false, length=9)
	private String cif;

	@Column(length=250)
	private String direccion;

	@Column(length=50)
	private String nombre;

	//bi-directional many-to-one association to Compra
	@OneToMany(mappedBy="libreria")
	private List<Compra> compras;

	//bi-directional many-to-one association to Ofrece
	@OneToMany(mappedBy="libreria")
	private List<Ofrece> ofreces;

	public Libreria() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCif() {
		return this.cif;
	}

	public void setCif(String cif) {
		this.cif = cif;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Compra> getCompras() {
		return this.compras;
	}

	public void setCompras(List<Compra> compras) {
		this.compras = compras;
	}

	public Compra addCompra(Compra compra) {
		getCompras().add(compra);
		compra.setLibreria(this);

		return compra;
	}

	public Compra removeCompra(Compra compra) {
		getCompras().remove(compra);
		compra.setLibreria(null);

		return compra;
	}

	public List<Ofrece> getOfreces() {
		return this.ofreces;
	}

	public void setOfreces(List<Ofrece> ofreces) {
		this.ofreces = ofreces;
	}

	public Ofrece addOfrece(Ofrece ofrece) {
		getOfreces().add(ofrece);
		ofrece.setLibreria(this);

		return ofrece;
	}

	public Ofrece removeOfrece(Ofrece ofrece) {
		getOfreces().remove(ofrece);
		ofrece.setLibreria(null);

		return ofrece;
	}

	@Override
	public String toString() {
		return "Libreria [id=" + id + ", cif=" + cif + ", direccion="
				+ direccion + ", nombre=" + nombre + "]";
	}

	
}