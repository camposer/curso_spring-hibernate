package es.indra.formacion.springhibernate;

public class Envoltorio {
	private HolaMundo cualquierCosa;

	public HolaMundo getHolaMundo() {
		return cualquierCosa;
	}

	public void setHolaMundo(HolaMundo cualquierCosa) {
		this.cualquierCosa = cualquierCosa;
	}
	
	public void imprimir() {
		System.out.println("Hola: " + cualquierCosa.getMensaje());
	}
	
}
