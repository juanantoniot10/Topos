package toposJuego;

public class GestionJuego {
	private int segundos;
	private int disparos;
	private int puntos;
	private long segundosRestantes;
	private long inicioPartida;
	
	
	public GestionJuego(int segundos,int disparos) {
	 this.segundos = segundos;
	 this.puntos = 0;
	 this.disparos = disparos;
	 }

	public boolean isEnJuego(){
		return ((!this.isTiempoFinalizado())&&(this.getDisparos()>0));
	}
	
	public boolean isFinalizada(){
		return ((this.isTiempoFinalizado())||(this.getDisparos()== 0));
	}
	
	public boolean isTiempoFinalizado() {
		return this.segundosRestantes<=0;
	}
	
	public void arrancarPartida() {
		this.inicioPartida = System.currentTimeMillis();
		this.segundosRestantes =  (segundos*1000)-getTiempoTranscurrido();
	}
	
	public long getTiempoTranscurrido() {
	 // La marca de tiempo "ahora" será igual o posterior a "inicio"

	 long ahora = System.currentTimeMillis();
	 long tiempo = ahora - this.inicioPartida;

	 return tiempo; // retorna el tiempo transcurrido en milisegundos
	 }

	public int getSegundos() {
		return segundos;
	}

	public void incrementarSegundos(int segundos) {
		this.segundos += segundos;
	}

	public void decrementarSegundos(int segundos) {
		if(this.segundos-segundos>=0)this.segundos -= segundos;
		else this.segundos = 0;
	}
	
	public int getDisparos() {
		return disparos;
	}

	public void incrementarDisparos(int disparos) {
		this.disparos += disparos;
	}

	public void decrementarDisparos(int disparos) {
		if(this.disparos - disparos >= 0)this.disparos -= disparos;
		else this.disparos = 0;
	}
	
	public int getPuntos() {
		return puntos;
	}

	public void incrementarPuntos(int puntos) {
		this.puntos += puntos;
	}

	public void decrementarPuntos(int puntos) {
		this.puntos += puntos;
	}
	
	public long getInicioPartida() {
		return inicioPartida;
	}

	public long getSegundosRestantes() {
		return this.segundos-(getTiempoTranscurrido()/1000);
	} 
	
	
}
