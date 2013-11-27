package es.indra.formacion.springhibernate.gui;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import es.indra.formacion.springhibernate.model.Lector;
import es.indra.formacion.springhibernate.model.Libreria;
import es.indra.formacion.springhibernate.model.Libro;
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

	public void listarLibreriaPorLibro() {
		System.out.println("Id?");
		String sid = scanner.nextLine();

		Integer id = Integer.parseInt(sid);
		for (Libreria l : libroService.obtenerLibreriasPorLibro(id)) {
			System.out.println(l);
		}
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
			System.out.println("6. Listar librerías");
			System.out.println("7. Listar lectores");
			System.out.println("8. Listar lectores mayores de edad");
			System.out.println("9. Listar de autores");
			System.out.println("10. Listar libro más vendido");
			System.out.println("11. Listar autor más vendido y cuánto vendió");
			System.out.println("12. Listar libros vendido por año");
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
