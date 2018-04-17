package toposEstructura;

public class PanelBasico{
	private static final int TIEMPOACTUALIZAR = 5000;
	private boolean visible;
	private Posicion posicion;
	private long tiempo;
	
	
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
	
	public String getImagen() {
		return new String("imagenes/panel-basico.gif");
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
		if(this.visible) {
			this.visible=false;
			this.tiempo = System.currentTimeMillis();
		}
	}
	
	
	
	public void actualizar() {
		if(!this.visible && System.currentTimeMillis()-TIEMPOACTUALIZAR>=this.tiempo) {
			this.visible=true;
		}
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

	public long getTiempo() {
		return tiempo;
	}

	
}
