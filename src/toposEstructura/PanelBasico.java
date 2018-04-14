package toposEstructura;

public class PanelBasico{
	private boolean visible;
	private Posicion posicion;
	
	
	public PanelBasico(int posicionX, int posicionY, boolean visible) {
		super();
		this.posicion = new Posicion(posicionX,posicionY);
		this.visible = visible;
	}
	
	public PanelBasico(int posicionX, int posicionY) {
		super();
		this.posicion = new Posicion(posicionX,posicionY);
		this.visible = true;
	}
	
	public PanelBasico(Posicion posicion, boolean visible) {
		super();
		this.posicion =new Posicion(posicion.getX(),posicion.getY()) ;
		this.visible = visible;
	}
	
	
	public PanelBasico(Posicion posicion) {
		super();
		this.posicion = posicion;
		this.visible = true;
	}
	
	/**
	 * golpea una casilla y oculta su contenido
	 */
	public void golpear() {
		if(this.visible)this.visible=false;
	}
	
	
	
	public Posicion getPosicion() {
		return posicion;
	}

	public void setPosicion(Posicion posicion) {
		this.posicion = posicion;
	}

	public boolean isVisible() {
		return visible;
	}
	
}
