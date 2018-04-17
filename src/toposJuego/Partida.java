package toposJuego;

import java.util.ArrayList;

import elementos.Topo;
import toposEstructura.Escenario;

public class Partida {

	public static void main(String[] args) {
		Escenario escenario = new Escenario(10, 10);
		Topo topo1 = new Topo(1, 1);
		Topo topo2 = new Topo(2, 2);
		Topo topo3 = new Topo(3, 3);
		escenario.addTopo(topo1);
		escenario.addTopo(topo2);
		escenario.addTopo(topo3);
		escenario.iniciarPartida(600, 10);
	}

}
