package es.indra.formacion.springhibernate;

public class HolaMundo implements IHolaMundo {
	private String mensaje;

	public HolaMundo(String mensaje) {
		this.mensaje = mensaje;
	}
	
	@Override
	public String getMensaje() {
		return "Hola: " + mensaje;
	}

	@Override
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
}
