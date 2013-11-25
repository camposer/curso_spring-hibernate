package es.indra.formacion.springhibernate;

public class Envoltorio {
	private IHolaMundo cualquierCosa;

	public IHolaMundo getHolaMundo() {
		return cualquierCosa;
	}

	public void setHolaMundo(IHolaMundo cualquierCosa) {
		this.cualquierCosa = cualquierCosa;
	}
	
	public void imprimir() {
		System.out.println("Envoltorio: " + cualquierCosa.getMensaje());
	}
	
}
