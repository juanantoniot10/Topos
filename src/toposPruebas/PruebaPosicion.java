package toposPruebas;

import toposEstructura.Direccion;
import toposEstructura.Posicion;

public class PruebaPosicion {

	public static void main(String[] args) {
		//creacion de nuevo objeto de la clase posicion en las coordenadas 1,3
		Posicion posicion1 = new Posicion(1,3);
		System.out.println("La posicion x posicion1 "+posicion1.getX());
		System.out.println("La posicion y posicion1 "+posicion1.getY());
		
//		creando un nuevo objeto posicion usando el constructor sin parametros
//		para comprobar si sus coordenadas son 0,0
		Posicion posicion2 = new Posicion();
		System.out.println("La posicion x posicion2 "+posicion2.getX());
		System.out.println("La posicion y posicion2 "+posicion2.getY());
		
//		creando nuevo objeto posicion pasando al constructor el objeto posicion1
		Posicion posicion3 = new Posicion(posicion1);
		System.out.println("La posicion x posicion3 "+posicion3.getX());
		System.out.println("La posicion y posicion3 "+posicion3.getY());
		
//		creando nuevo objeto posicion pasando al constructor el objeto posicion2
		Posicion posicion4 = new Posicion(posicion2);
//		modificando valores de posicion2
		posicion2.setX(5);
		posicion2.setY(4);
		System.out.println("La posicion x posicion2 es "+posicion2.getX());
		System.out.println("La posicion y posicion2 es "+posicion2.getY());
		System.out.println("La posicion x posicion4 es "+posicion4.getX());
		System.out.println("La posicion y posicion4 es "+posicion4.getY());
		
//		probando desplazamiento
		posicion4.desplazar(Direccion.izquierda);
		posicion4.desplazar(Direccion.arriba);
		System.out.println("La posicion x posicion4 desplazada izquierda y arriba es "+posicion4.getX());
		System.out.println("La posicion y posicion4 desplazada izquierda y arriba es "+posicion4.getY());
		posicion4.desplazar(Direccion.derecha);
		posicion4.desplazar(Direccion.abajo);
		System.out.println("La posicion y posicion4 desplazada izquierda y arriba derecha y abajo es "+posicion4.getX());
		System.out.println("La posicion y posicion4 desplazada izquierda y arriba derecha y abajo es "+posicion4.getY());

		//probando obtener vecina
		Posicion posicion5 = new Posicion(posicion4.getVecina(Direccion.arriba));
		System.out.println("la vecina de arriba de Posicion4 0,0 es " + posicion5.getX() + " , " + posicion5.getY());
		posicion5 = new Posicion(posicion4.getVecina(Direccion.abajo));
		System.out.println("la vecina de abajo de Posicion4 0,0 es " + posicion5.getX() + " , " + posicion5.getY());
		posicion5 = new Posicion(posicion4.getVecina(Direccion.izquierda));
		System.out.println("la vecina de izquierda de Posicion4 0,0 es " + posicion5.getX() + " , " + posicion5.getY() );
		posicion5 = new Posicion(posicion4.getVecina(Direccion.derecha));
		System.out.println("la vecina de derecha de Posicion4 0,0 es " + posicion5.getX() + " , " + posicion5.getY());
		
		
	}

}
