package uniquindio.lenguaje.mundo;

public class Silla {

	private Clase clase;
	private Ubicacion ubicacion;
	private Pasajero pasajero;
	private String id;
	private boolean ocupada = false;
	public Silla(Clase clase, Ubicacion ubicacion, String id) {
		super();
		this.clase = clase;
		this.ubicacion = ubicacion;
		this.id = id;
	}
	public Clase getClase() {
		return clase;
	}
	public void setClase(Clase clase) {
		this.clase = clase;
	}
	public Ubicacion getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(Ubicacion ubicacion) {
		this.ubicacion = ubicacion;
	}
	public Pasajero getPasajero() {
		return pasajero;
	}
	public void setPasajero(Pasajero pasajero) {
		this.pasajero = pasajero;
	}
	
	public boolean isIn(Pasajero p) {
		boolean is=false;
		if(p.getId().equals(pasajero.getId()))
		{
			is = true;
		}
		
		return is;
	}
	
	public void quitarPasajero()
	{
		pasajero = null;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public boolean isOcupada() {
		return ocupada;
	}
	public void setOcupada(boolean ocupada) {
		this.ocupada = ocupada;
	}
}
