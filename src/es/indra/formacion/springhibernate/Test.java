package es.indra.formacion.springhibernate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		// Carga el contexto de Spring!
		ApplicationContext ctx = 
				new ClassPathXmlApplicationContext("es/indra/formacion/"
						+ "springhibernate/config/applicationContext.xml");

		// Pidiendo beans según el ID al Contexto
		HolaMundo holaMundo = ctx.getBean("holaMundo", HolaMundo.class);
		holaMundo.setMensaje("Hola Juan");
		
		System.out.println(holaMundo.getMensaje());
			
	}
}
