package es.indra.formacion.springhibernate;

public class HolaMundo {
	private String mensaje;

	public HolaMundo(String mensaje) {
		this.mensaje = mensaje;
	}
	
	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
}
