package toposEstructura;

public class Escenario {
	private int ancho,alto;
	private PanelBasico paneles [][];
	private Posicion objetivo;
	
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
