package elementos;

import javax.swing.ImageIcon;

import toposEstructura.Direccion;
import toposEstructura.Escenario;
import toposEstructura.Posicion;
import toposJuego.GestionJuego;

public class Topo implements Comparable<Topo>{
	private static final int TIEMPOACTUAR = 2;
	private Posicion posicion;
	private Escenario escenario;
	private long instanteAcual;
	
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

	public void actualizaPartida(GestionJuego gestionJuego) {
		gestionJuego.incrementarPuntos(1);
	}
	
	
	public void actuar() {
		if(this.escenario!=null&& escenario.getPaneles()[this.getPosicion().getX()][this.getPosicion().getY()].isVisible()) {
			this.instanteAcual = System.currentTimeMillis();
		}
		if(((TIEMPOACTUAR * 1000)-(System.currentTimeMillis()-this.instanteAcual))/1000<=0) {
			Direccion direccion = Direccion.values()[crearRandom(0, 3)];
			if (this.escenario.checkLimit(this.posicion.getVecina(direccion).getX(),this.posicion.getVecina(direccion).getY()) &&
					this.escenario.checkTopo(this.posicion.getVecina(direccion).getX(),this.posicion.getVecina(direccion).getY())==null) {
				this.desplazarTopo(direccion);
				this.instanteAcual = System.currentTimeMillis();
			}
		}
	}
	
	/**
	 * crea un numero random 
	 * @param min numero minimo
	 * @param max numero maximo
	 * @return int aleatorio entre min y max
	 */
	public int crearRandom(int min,int max) {
		int numeroAleatorio=((int)(Math.random()*((max-min)+1)))+min;
		return numeroAleatorio;
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
	
	public String getImagen() {
		return new String("imagenes/topo.png");
	}
	
}
