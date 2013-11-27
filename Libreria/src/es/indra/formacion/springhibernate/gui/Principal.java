package es.indra.formacion.springhibernate.gui;

import java.util.Date;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import es.indra.formacion.springhibernate.model.Lector;
import es.indra.formacion.springhibernate.model.Libreria;
import es.indra.formacion.springhibernate.model.Libro;
import es.indra.formacion.springhibernate.service.ICompraService;
import es.indra.formacion.springhibernate.service.ILectorService;
import es.indra.formacion.springhibernate.service.ILibreriaService;
import es.indra.formacion.springhibernate.service.ILibroService;

public class Principal {
	private Scanner scanner;
	@Autowired
	private ILibroService libroService;
	@Autowired
	private ILibreriaService libreriaService;
	@Autowired
	private ILectorService lectorService;
	@Autowired
	private ICompraService compraService;

	public Principal() {
		this.scanner = new Scanner(System.in);
	}
	
	private void agregar() {
		System.out.println("Título?");
		String titulo = scanner.nextLine();
		System.out.println("Autor?");
		String autor = scanner.nextLine();
		System.out.println("Precio?");
		String precio = scanner.nextLine();
		
		Libro l = new Libro(titulo, autor, Double.parseDouble(precio));
		
		libroService.agregarLibro(l);
	}
	
	private void modificar() {
		System.out.println("Id?");
		String sid = scanner.nextLine();
		System.out.println("Título?");
		String titulo = scanner.nextLine();
		System.out.println("Autor?");
		String autor = scanner.nextLine();
		System.out.println("Precio?");
		String precio = scanner.nextLine();
		
		Libro l = new Libro(titulo, autor, Double.parseDouble(precio));
		l.setId(Integer.parseInt(sid));
		
		libroService.modificarLibro(l);
	}

	private void eliminar() {
		System.out.println("Id?");
		String sid = scanner.nextLine();
		
		libroService.eliminarLibro(Integer.parseInt(sid));
	}

	private void listar() {
		for (Libro l : libroService.obtenerLibros()) {
			System.out.println(l);
		}
	}

	public void listarLibreriaPorLibro(Integer libroId) {
		for (Libreria l : libroService.obtenerLibreriasPorLibro(libroId)) {
			System.out.println(l);
		}
	}

	public void listarLibreriaPorLibro() {
		System.out.println("Id?");
		String sid = scanner.nextLine();
		
		listarLibreriaPorLibro(Integer.parseInt(sid));
	}
	
	public void listarLibrerias() {
		for (Libreria l : libreriaService.obtenerLibrerias())
			System.out.println(l);
	}
	
	public void listarLectores() {
		for (Lector l : lectorService.obtenerLectores())
			System.out.println(l);
	}
	
	public void listarLectoresMayorEdad() {
		for (Lector l : lectorService.obtenerLectoresMayorEdad())
			System.out.println(l);		
	}

	public void listarAutores() {
		for (String a : libroService.obtenerAutores())
			System.out.println(a);			
	}
	
	public void listarLibroMasVendido() {
		System.out.println(libroService.obtenerLibroMasVendido());					
	}
	
	public void listarAutorMasVendidoVentas() {
		Object[] valores = libroService.obtenerAutorMasVendidoVentas();
		String autor = (String) valores[0];
		Long cuenta = (Long) valores[1];
		
		System.out.println(autor + ", vendió: " + cuenta);							
	}
	
	public void listarLibrosVendidosPorAnio() {
		for (Object[] obj : libroService.obtenerLibrosVendidosPorAnio()) {
			Integer id = (Integer) obj[0];
			String titulo = (String) obj[1]; 
			Integer anio = (Integer) obj[2];
			
			System.out.println("id: " + id + ", título: " + titulo + ", anio: " + anio);
		}
	}
	
	public void comprar() {
		listar();
		System.out.println("libroId? ");
		String slibroId = scanner.nextLine();
		Integer libroId = Integer.parseInt(slibroId);
		
		listarLibreriaPorLibro(libroId);
		System.out.println("libreriaId? ");
		String slibreriaId = scanner.nextLine();
		Integer libreriaId = Integer.parseInt(slibreriaId);
		
		System.out.println("Lector: ");
		System.out.println("Nombre? ");
		String nombre = scanner.nextLine();
		System.out.println("Apellido? ");
		String apellido = scanner.nextLine();
		System.out.println("Dirección? ");
		String direccion = scanner.nextLine();
		System.out.println("Fecha de nac? ");
		String sfechaNacimiento = scanner.nextLine();

		Date fecha = new Date(); // TODO: Se debería hacer un parse de sfechaNacimiento
		
		// Buscando referencias
		Libro libro = libroService.obtenerLibro(libroId);
		Libreria libreria = libreriaService.obtenerLibreria(libreriaId);
		
		// Construyendo el lector
		Lector lector = new Lector();
		lector.setNombre(nombre);
		lector.setApellido(apellido);
		lector.setDireccion(direccion);
		lector.setFechaNacimiento(fecha);
		
		// Comprando...
		compraService.comprar(libro, libreria, lector);
		
		
	}
	
	public void iniciar() {
		while (true) {
			System.out.println();
			System.out.println("Libros");
			System.out.println("1. Agregar");
			System.out.println("2. Modificar");
			System.out.println("3. Eliminar");
			System.out.println("4. Listar");
			System.out.println("Reportes:");
			System.out.println("5. Listar librerías en donde es ofrecido un libro");
			System.out.println("6. LLECTOR (id, apellido, direccion, FECHA_NACIMIENTO, nombre) values (default, ?, ?, ?, ?)
Hibernate: values identity_val_local()
Hibernate: insert into COMPRA (id, fecha, LECTOR_ID, LIBRERIA_ID, LIBRO_ID, montante) values (default, ?, ?, ?, ?, ?)
Hibernate: values identityistar librerías");
			System.out.println("7. Listar lectores");
			System.out.println("8. Listar lectores mayores de edad");
			System.out.println("9. Listar de autores");
			System.out.println("10. Listar libro más vendido");
			System.out.println("11. Listar autor más vendido y cuánto vendió");
			System.out.println("12. Listar libros vendido por año");
			System.out.println("Compra:");
			System.out.println("13. Comprar");
			System.out.println("? ");
			
			String opcion = scanner.nextLine();
			
			if (opcion.equals("1"))
				agregar();
			else if (opcion.equals("2"))
				modificar();
			else if (opcion.equals("3"))
				eliminar();
			else if (opcion.equals("4"))
				listar();
			else if (opcion.equals("5"))
				listarLibreriaPorLibro();
			else if (opcion.equals("6"))
				listarLibrerias();
			else if (opcion.equals("7"))
				listarLectores();
			else if (opcion.equals("8"))
				listarLectoresMayorEdad();
			else if (opcion.equals("9"))
				listarAutores();
			else if (opcion.equals("10"))
				listarLibroMasVendido();
			else if (opcion.equals("11"))
				listarAutorMasVendidoVentas();
			else if (opcion.equals("12"))
				listarLibrosVendidosPorAnio();
			else if (opcion.equals("13"))
				comprar();
		}
	}
	
	public void setLibroService(ILibroService libroService) {
		this.libroService = libroService;
	}
	
	public static void main(String[] args) {
		ApplicationContext ctx = 
				new ClassPathXmlApplicationContext("es/indra/formacion/springhibernate/config/applicationContext-annotation.xml");
		
		ctx.getBean("principal", Principal.class).iniciar();
	}
	
}
