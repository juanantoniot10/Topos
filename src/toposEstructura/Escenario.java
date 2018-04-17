package toposEstructura;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

import elementos.Topo;
import topos.vista1.Alarma;
import topos.vista1.Pantalla;
import toposJuego.GestionJuego;

public class Escenario {
	private static final String TECLADISPARAR = " ";
	private static final String TECLAABAJO = "s";
	private static final String TECLADERECHA = "d";
	private static final String TECLAIZQUIERDA = "a";
	private static final String TECLAARRIBA = "w";
	private static final int TAMAÑOCUADRADO = 50;
	private static final Color COLORFONDO = Color.BLUE;

	
	private int ancho,alto;
	private PanelBasico paneles [][];
	private Posicion objetivo;
	private ArrayList<Topo> topos;
	private GestionJuego partida;
	private Pantalla pantalla;

	public Escenario(int ancho, int alto) {
		super();
		this.ancho = ancho;
		this.alto = alto;
		this.paneles = new PanelBasico[this.ancho][this.alto];
		for (int i = paneles.length-1; i >= 0; i--) {
			for (int j = paneles[i].length-1; j >= 0; j--) {
				this.paneles[j][i] = new PanelBasico(new Posicion(j, i));
			}
		}
		this.objetivo = new Posicion();
		topos = new ArrayList<Topo>();
	}
	
	public void disparar () {
		if(this.partida.isEnJuego()) {
			if(this.paneles[this.objetivo.getX()][this.objetivo.getY()].isVisible()) {
				this.paneles[this.objetivo.getX()][this.objetivo.getY()].golpear();
			}
			else if(this.checkTopo(this.objetivo.getX(), this.objetivo.getY())!=null) {
				this.checkTopo(this.objetivo.getX(), this.objetivo.getY()).setEscenario(null);
				this.topos.remove(checkTopo(this.objetivo.getX(), this.objetivo.getY()));
				this.partida.incrementarPuntos(1);
			}
		}
		this.partida.decrementarDisparos(1);
	}
	
	public void refrescarPantalla() {
		this.pantalla.resetear();
		for (int i = 0; i < this.paneles.length; i++) {
			for (int j = 0; j < paneles[i].length; j++) {
				
				if(this.paneles[i][j].isVisible()) {
					this.pantalla.addImagen(i, j, this.paneles[i][j].getImagen());
				}
				
				if(this.paneles[i][j].isVisible()) {
					if(this.isTopo(i, j)) {
						this.pantalla.addImagen(i, j, this.checkTopo(i, j).getImagen());
					}
				}
				
				if(this.objetivo.getX()==this.paneles[i][j].getPosicion().getX()&&
					this.objetivo.getY()==this.paneles[i][j].getPosicion().getY()) {
					this.pantalla.addImagen(i, j, "imagenes/objetivo.png");
				}
			}
		}
		this.pantalla.setBarraEstado("TIEMPO RESTANTE: "+
		this.partida.getSegundosRestantes()+
		"  DISPAROS: "+this.partida.getDisparos()+
		" PUNTOS: "+this.partida.getPuntos());
		this.pantalla.dibujar();
	}
	
	public void actualizar() {
		for (int i = 0; i < this.paneles.length; i++) {
			for (int j = 0; j < this.paneles[i].length; j++) {
				this.paneles[i][j].actualizar();
			}
		}
		for (Iterator<Topo> iterator = topos.iterator(); iterator.hasNext();) {
			Topo topo = iterator.next();
			topo.actuar();
		}
	}
	
	public void iniciarPartida(int segundos,int disparos) {
		this.partida = new GestionJuego(segundos, disparos);
		this.partida.arrancarPartida();
		this.pantalla = new Pantalla(ancho, alto, 50, COLORFONDO);
		this.refrescarPantalla();
		do {
			Alarma.dormir(300);
			if(this.pantalla.hayTecla()) { 
				switch (pantalla.leerTecla()) {
				case TECLAARRIBA:
					this.desplazarObjetivo(Direccion.arriba);
					break;
				case TECLAIZQUIERDA:
					this.desplazarObjetivo(Direccion.izquierda);
					break;
				case TECLADERECHA:
					this.desplazarObjetivo(Direccion.derecha);
					break;
				case TECLAABAJO:
					this.desplazarObjetivo(Direccion.abajo);
					break;
				case TECLADISPARAR:
					this.disparar();
					break;
				default:
					break;
				}
				
			}
			this.actualizar();
			this.refrescarPantalla();
		} while (this.partida.isEnJuego());
		this.pantalla.setBarraEstado("FIN PARTIDA  PUNTUACION:" + this.getPartida().getPuntos());
	}
	
	public boolean isTopo(int i , int j) {
		if(checkTopo(i, j)!=null)return true;
		return false;
	}
	
	public ArrayList<Topo> getTopos() {
		return topos;
	}

	public Topo checkTopo (int i,int j) {
		for (ListIterator<Topo> iterator = topos.listIterator(); iterator.hasNext();) {
			Topo topo = iterator.next();
			if(topo.getPosicion().getX()==i&&topo.getPosicion().getY()==j) {
				return topo;
			}
		}
		return null;
	}
	
	public boolean addTopo(Topo topo3) {
		boolean aniadible = true;
		if(this.topos.size()>0) {
			for (ListIterator<Topo> iterator2 = this.topos.listIterator(); iterator2.hasNext();) {
				Topo topoEscenario = iterator2.next();
				if (topo3.compareTo(topoEscenario) == 0) {
					aniadible=false;
				}
			}
		}
		if(aniadible==true) {
			topo3.setEscenario(this);
			this.topos.add(topo3);
		}
		return aniadible;
	}
	
	
	public ArrayList<Topo> addTopo (ArrayList<Topo> toposAd) {
		for (ListIterator<Topo> iterator = toposAd.listIterator(); iterator.hasNext();) {
			Topo topoAdd = iterator.next();
			boolean aniadible = true;
			if(this.topos.size()>0) {
				for (ListIterator<Topo> iterator2 = this.topos.listIterator(); iterator2.hasNext();) {
					Topo topoEscenario = iterator2.next();
					if (topoAdd.compareTo(topoEscenario) == 0) {
						aniadible=false;
					}
				}
				if(aniadible==true) {
					topoAdd.setEscenario(this);
					this.topos.add(topoAdd);
				}
			}
			else {
				topoAdd.setEscenario(this);
				this.topos.add(topoAdd);
			}
		}
		for (ListIterator<Topo> iterator = this.topos.listIterator(); iterator.hasNext();) {
			Topo topoEscenario = iterator.next();
			boolean borrable = false;
				for (ListIterator<Topo> iterator2 = toposAd.listIterator(); iterator2.hasNext();) {
					Topo topoAdd = iterator2.next();
					if (topoEscenario.compareTo(topoAdd) == 0) {
						borrable=true;
					}
				}
				if(borrable) {
					toposAd.remove(topoEscenario);
				}
		}
		return toposAd;
	}
	
	public void desplazarObjetivo(Direccion direccion){
		if(this.checkLimit(objetivo.getVecina(direccion).getX(),objetivo.getVecina(direccion).getY())) {
			this.objetivo.desplazar(direccion);
		}
	}
	
	public Posicion getObjetivo() {
		return objetivo;
	}


	public void desplazarPanel(int i,int j,Direccion direccion) {
		if(this.checkLimit(paneles[i][j].getPosicion().getVecina(direccion).getX(), paneles[i][j].getPosicion().getVecina(direccion).getY())) {
			this.setNewPanel(paneles[i][j],new Posicion().getVecina(direccion));
		}
		
	}
	
	public boolean checkLimit(int i,int j) {
		return (i>-1 && i<ancho-1&&j>-1&&j<alto-1);
	}
	
	public boolean isVisible(int i,int j) {
		return paneles[i][j].isVisible();
	}
	
	public void setNewPanel(PanelBasico panelBasico,Posicion nuevaPosicion) {
		this.paneles[nuevaPosicion.getX()][nuevaPosicion.getY()]= panelBasico;
	}
	
	public PanelBasico getPosicion(int i,int j){
		return this.paneles[i][j];
	}
	
	public PanelBasico[][] getPaneles() {
		return paneles;
	}
	
	public GestionJuego getPartida() {
		return partida;
	}
	
}
