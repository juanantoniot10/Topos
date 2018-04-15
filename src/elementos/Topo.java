package elementos;

import toposEstructura.Direccion;
import toposEstructura.Escenario;
import toposEstructura.Posicion;

public class Topo implements Comparable<Topo>{
	private Posicion posicion;
	private Escenario escenario;
	
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

	@Override
	public int compareTo(Topo o) {
		return String.valueOf(posicion.getX()+posicion.getY()).compareTo(String.valueOf(o.posicion.getX() + o.posicion.getY()));
	}

	public Escenario getEscenario() {
		return escenario;
	}

	public void setEscenario(Escenario escenario) {
		this.escenario = escenario;
	}
	
}
