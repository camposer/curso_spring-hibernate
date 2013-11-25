package es.indra.formacion.springhibernate.gui;

import java.util.Scanner;

public class Principal {
	private Scanner scanner;

	public Principal() {
		this.scanner = new Scanner(System.in);
	}
	
	public void iniciar() {
		while (true) {
			System.out.println();
			System.out.println("Libros");
			System.out.println("1. Agregar");
			System.out.println("2. Modificar");
			System.out.println("3. Eliminar");
			System.out.println("4. Listar");
			System.out.println("? ");
			
			String opcion = scanner.nextLine();
			
			if (opcion.equals("1"))
				System.out.println("Menú de agregar");
			else if (opcion.equals("2"))
				System.out.println("Menú de modificar");
			else if (opcion.equals("3"))
				System.out.println("Menú de eliminar");
			else if (opcion.equals("4"))
				System.out.println("Lista");
		}
	}
	
	public static void main(String[] args) {
		new Principal().iniciar();
	}
}
