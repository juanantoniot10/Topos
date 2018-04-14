package toposEstructura;

public enum Direccion {
	izquierda(-1), derecha(1), arriba(1), abajo(-1);
	private int valor;

	private Direccion(int valor) {
		this.valor = valor;
	}

	public int getValor() {
		return valor;
	}
	
}

