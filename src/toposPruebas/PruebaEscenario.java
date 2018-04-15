package toposPruebas;

import java.util.ArrayList;

import elementos.Topo;
import toposEstructura.Direccion;
import toposEstructura.Escenario;
import toposEstructura.PanelBasico;
import toposEstructura.Posicion;

public class PruebaEscenario {

	public static void main(String[] args) {
		Escenario escenario = new Escenario(5, 5);
		for (int i = 0; i < escenario.getPaneles().length; i++) {
			for (int j = 0; j < escenario.getPaneles()[i].length; j++) {
				System.out.println("panel " + i + " " + j +
						" = PosicionX: " + escenario.getPaneles()[i][j].getPosicion().getX() +
						" PosicionY: " +escenario.getPaneles()[i][j].getPosicion().getY());
				System.out.println(escenario.getPaneles()[i][j].isVisible()+"");
			}
		}
		System.out.println("probando si posicion 1 , 2 esta en limites");
		System.out.println(escenario.checkLimit(1, 2));
		
		System.out.println("probando si posicion 4 , 5 esta en limites");
		System.out.println(escenario.checkLimit(4, 5));
		
		PanelBasico basicoNoVisible = new PanelBasico(new Posicion(2,3),false);
		escenario.setNewPanel(basicoNoVisible, basicoNoVisible.getPosicion());
		
		System.out.println("comprobando si el panelBasico del escenario es el que acabo de crear");
		System.out.println(basicoNoVisible.equals(escenario.getPaneles()[2][3]));
		
		System.out.println("comprobando si el panel aniadido al escenario esta visible");
		System.out.println(basicoNoVisible.isVisible()+"");
		
		System.out.println("moviendo objetivo a la derecha");
		escenario.desplazarObjetivo(Direccion.derecha);
		System.out.println("La posicion del objetivo despues de desplazarlo a la derecha: X = " + escenario.getObjetivo().getX() + " Y = " + escenario.getObjetivo().getY());
		
		
		Topo topo1 = new Topo(1,2);
		Topo topo2 = new Topo(2,3);
		ArrayList<Topo> toposPrueba = new ArrayList<Topo>();
		toposPrueba.add(topo1);
		toposPrueba.add(topo2);
		
		ArrayList<Topo> toposDevueltos = escenario.addTopo(toposPrueba);
		
		System.out.println("tamanio de topos escenario = " + escenario.getTopos().size());
		System.out.println("numero de topos de retorno en el array topos prueba = "+toposDevueltos.size());
	
		System.out.println("comprobando que en 1,2 hay topo");
		System.out.println(escenario.checkTopo(1, 2));
		System.out.println("probando que es topo1");
		System.out.println(topo1.equals(escenario.checkTopo(1, 2)));
		
		Topo topo3 = new Topo(2	, 3);
		System.out.println("intentando anadir topo en posicion con topo");
		System.out.println(escenario.addTopo(topo3));
		System.out.println("tamanio de topos escenario = " + escenario.getTopos().size());
		
		System.out.println("mostrando escenario de topo1");
		System.out.println("topo1 escenario = "+topo1.getEscenario());
		System.out.println("comprobando si su escenario es el creado aqui ");
		System.out.println(escenario.equals(topo1.getEscenario()));
		
		System.out.println(System.currentTimeMillis());
	}

}
