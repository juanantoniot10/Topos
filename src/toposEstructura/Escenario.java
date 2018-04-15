package toposEstructura;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

import elementos.Topo;

public class Escenario {
	private int ancho,alto;
	private PanelBasico paneles [][];
	private Posicion objetivo;
	private ArrayList<Topo> topos;
	
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
		boolean aniadible = false;
		for (ListIterator<Topo> iterator2 = this.topos.listIterator(); iterator2.hasNext();) {
			Topo topoEscenario = iterator2.next();
			if (topo3.compareTo(topoEscenario) == 0) {
				aniadible=false;
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

	
}
