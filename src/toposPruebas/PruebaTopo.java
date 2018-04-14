package toposPruebas;

import elementos.Topo;
import toposEstructura.Direccion;
import toposEstructura.Posicion;

public class PruebaTopo {

	public static void main(String[] args) {
		Topo topo1 = new Topo(0, 0);
		topo1.desplazarTopo(Direccion.derecha);
		Posicion posicion1 = new Posicion(topo1.getPosicion());
		topo1.desplazarTopo(Direccion.arriba);
		Posicion posicion2 = new Posicion(topo1.getPosicion());
		System.out.println("posicion del topo tras mover derecha "+posicion1.getX()+" "+ posicion1.getY());
		System.out.println("posicion del topo tras mover arriba "+posicion2.getX()+" "+ posicion2.getY());

	}

}
