package toposPruebas;

import toposJuego.GestionJuego;

public class PruebaGestionJuego {

	public static void main(String[] args) throws InterruptedException {
		GestionJuego gestionJuego = new GestionJuego(60, 3);
		gestionJuego.arrancarPartida();
		System.out.println("partida arrandada, comprobando isEnJuego");
		System.out.println(gestionJuego.isEnJuego()+"");
		
		System.out.println("puntos deben ser 0 y son: " + gestionJuego.getPuntos());
		gestionJuego.decrementarDisparos(4);
		System.out.println("mostrando disparos despues de 4  DISPAROS = " + gestionJuego.getDisparos());
		gestionJuego.incrementarPuntos(5);
		System.out.println(gestionJuego.getInicioPartida());
		System.out.println(gestionJuego.getSegundosRestantes());
		Thread.sleep(4000);
		System.out.println("tiempo restante despues de 4 segundos  TIEMPO RESTANTE = " + gestionJuego.getSegundosRestantes());
		System.out.println("mostrando si tiempoFinalizazo = false TIEMPOFINALIZADO = " + gestionJuego.isTiempoFinalizado());
		System.out.println("mostrando si isEnjuego no hay disparos deberia ser false");
		System.out.println(gestionJuego.isEnJuego());
		System.out.println("mostrando si isFinalizado no hay disparos deberia ser true");
		System.out.println(gestionJuego.isFinalizada());
		System.out.println("mostrando puntos otra vez");
		System.out.println(gestionJuego.getPuntos());
	}

}
