package toposEstructura;

public class Posicion {
	private int x;
	private int y;
	
	
	
	
	
	public Posicion(Posicion posicion) {
		//para probar que un objeto tiene acceso a las
//		propiedades privadas de otro objeto de su misma clase
		this.x = posicion.x;
		this.y = posicion.y;
	}
	
	public Posicion() {
		super();
		this.x = 0;
		this.y = 0;
	}
	public Posicion(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	/**
	 * desplaza en la coordenada x e y 
	 * @param x desplazamiento lateral (valor - izq) (valor + der)
	 * @param y desplazamiento vertical (valor - abajo) (valor + arriba)
	 */
	public void desplazar(int x,int y) {
		this.x += x;
		this.y += y;
	}
	
	/**
	 * desplaza la posicion en la direccion pasada por parametro
	 * @param direccion enum tipo Direccion
	 * @return retorna la posicion con la posicion modificada
	 */
	public Posicion desplazar(Direccion direccion) {
		if(direccion.name()=="derecha")this.setX(this.getX()+direccion.getValor());
		else if(direccion.name()=="izquierda")this.setX(this.getX()+direccion.getValor());
		else if(direccion.name()=="arriba")this.setY(this.getY()+direccion.getValor());
		else if(direccion.name()=="abajo")this.setY(this.getY()+direccion.getValor());
		return this;
	}
	
	/**
	 * Obtiene una nueva posicion al lado de la Posicion llamadora
	 * en la direccion indicada
	 * @param direccion enum tipo direccion 
	 * @return nueva posicion al lado de la Posicion llamadora
	 * en la direccion indicada
	 */
	public Posicion getVecina(Direccion direccion){
		return new Posicion(this.getX(),this.getY()).desplazar(direccion);
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
}
