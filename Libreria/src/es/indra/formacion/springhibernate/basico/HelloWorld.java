package es.indra.formacion.springhibernate.basico;

public class HelloWorld implements IHolaMundo {
	private String message;

	public HelloWorld(String message) {
		this.message = message;
	}
	
	@Override
	public String getMensaje() {
		return "Hello: " + message;
	}

	@Override
	public void setMensaje(String mensaje) {
		this.message = mensaje;
	}

}
