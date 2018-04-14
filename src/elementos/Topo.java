package elementos;

import toposEstructura.Direccion;
import toposEstructura.Posicion;

public class Topo {
	private Posicion posicion;
	
	public Topo(int posicionX, int posicionY) {
		super();
		this.posicion= new Posicion(posicionX,posicionY);
	}

	/**
	 * desplaza el topo en la direccion indicada
	 * @param direccion enum de tipo Direccion
	 */
	public void desplazarTopo(Direccion direccion){
		this.getPosicion().desplazar(direccion);
	}




	public Posicion getPosicion() {
		return posicion;
	}
	
}
