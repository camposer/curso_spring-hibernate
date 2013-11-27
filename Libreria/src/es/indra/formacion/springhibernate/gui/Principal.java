package es.indra.formacion.springhibernate.gui;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import es.indra.formacion.springhibernate.model.Libreria;
import es.indra.formacion.springhibernate.model.Libro;
import es.indra.formacion.springhibernate.service.ILibroService;

public class Principal {
	private Scanner scanner;
	@Autowired
	private ILibroService libroService;

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
	
	public void iniciar() {
		while (true) {
			System.out.println();
			System.out.println("Libros");
			System.out.println("1. Agregar");
			System.out.println("2. Modificar");
			System.out.println("3. Eliminar");
			System.out.println("4. Listar");
			System.out.println("5. Listar librerías en donde es ofrecido un libro");
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
