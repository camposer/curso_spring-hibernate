package es.indra.formacion.springhibernate.basico;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		// Carga el contexto de Spring!
		ApplicationContext ctx = 
				new ClassPathXmlApplicationContext("es/indra/formacion/"
						+ "springhibernate/config/applicationContext.xml");

		// Pidiendo beans según el ID al Contexto
		HolaMundo holaMundo1 = ctx.getBean("holaMundo", HolaMundo.class); // En el constructor define Hola Pedro		
		System.out.println(holaMundo1.getMensaje()); 
		
		holaMundo1.setMensaje("Cualquier cosa");
		System.out.println(holaMundo1.getMensaje()); 
		
		HolaMundo holaMundo2 = ctx.getBean("holaMundo", HolaMundo.class);
		System.out.println(holaMundo2.getMensaje());

		System.out.println("\n****************\n");
		Envoltorio envoltorio = ctx.getBean("envoltorio", Envoltorio.class);
		envoltorio.imprimir();

	
	}
}
