package toposPruebas;

import toposEstructura.Direccion;
import toposEstructura.PanelBasico;
import toposEstructura.Posicion;

public class PruebaPanelBasico {
	public static void main(String[] args) {
		
		//el objetivo de mostrar los valores en consola mediante metodos redundantes
//		es dar semantica al codigo de las pruebas y ahorrar comentarios
		
		PanelBasico panel1 = new PanelBasico(0, 0);
		PanelBasico panel2 = new PanelBasico(0, 1, false);
		mostrarPanel1(panel1);
		mostrarPanel2(panel2);
		Posicion posicion = new Posicion(2,2);
		mostrarPosicionDespuesDeAsignarValoresDePanel1(posicion);
		panel1.setPosicion(new Posicion(posicion));
		mostrarPanel1EnNuevaPosicion(panel1);
		panel1.getPosicion().desplazar(Direccion.arriba);
		mostrarPanel1DesplazadoArriba(panel1);
		panel2.setPosicion(new Posicion(posicion));
		mostrarPanel2EnAntiguaPosicionDePanel1(panel2);
		posicion.setX(panel1.getPosicion().getX());
		posicion.setY(panel1.getPosicion().getY());
		mostrarPosicionDespuesDeAsignarValoresDePanel1(posicion);
		posicion.desplazar(Direccion.derecha);
		mostrarPosicionDesplazadaDerecha(posicion);
		mostrarPanel1(panel1);
		System.out.println("PANELES SIN GOLPEAR");
		mostrarPanel1(panel1);
		mostrarPanel2(panel2);
		panel1.golpear();
		panel2.golpear();
		System.out.println("PANELES GOLPEADOS");
		mostrarPanel1(panel1);
		mostrarPanel2(panel2);

	}

	/**
	 * @param posicion
	 */
	private static void mostrarPosicionDesplazadaDerecha(Posicion posicion) {
		System.out.println("posicion deplazada derecha = "+posicion.getX() + "  " + posicion.getY());
	}

	/**
	 * @param panel2
	 */
	private static void mostrarPanel2EnAntiguaPosicionDePanel1(PanelBasico panel2) {
		System.out.println("panel2 en antigua posicion de panel1 = "+ panel2.getPosicion().getX() + "  " + panel2.getPosicion().getY()+ "  " + String.valueOf(panel2.isVisible()));
	}

	/**
	 * @param panel1
	 */
	private static void mostrarPanel1DesplazadoArriba(PanelBasico panel1) {
		System.out.println("panel1 desplazado arriba = "+panel1.getPosicion().getX() + "  " + panel1.getPosicion().getY()+ "  " + String.valueOf(panel1.isVisible()));
	}

	/**
	 * @param panel1
	 */
	private static void mostrarPanel1EnNuevaPosicion(PanelBasico panel1) {
		System.out.println("panel1 en nueva posicion = "+panel1.getPosicion().getX() + "  " + panel1.getPosicion().getY()+ "  " + String.valueOf(panel1.isVisible()));
	}

	/**
	 * @param posicion
	 */
	private static void mostrarPosicionDespuesDeAsignarValoresDePanel1(Posicion posicion) {
		System.out.println("posicion despues de asignar valores de panel1 = "+posicion.getX() + "  " + posicion.getY());
	}

	/**
	 * @param panel2
	 */
	private static void mostrarPanel2(PanelBasico panel2) {
		System.out.println("panel2 = "+panel2.getPosicion().getX() + "  " + panel2.getPosicion().getY()+ "  " + String.valueOf(panel2.isVisible()));
	}

	/**
	 * @param panel1
	 */
	private static void mostrarPanel1(PanelBasico panel1) {
		System.out.println("panel1 = "+panel1.getPosicion().getX() + "  " + panel1.getPosicion().getY()+ "  " + String.valueOf(panel1.isVisible()));
	}
	
}
