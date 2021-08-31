package uniquindio.lenguaje.mundo;

public class Registro {
private Vuelo vuelo;
private Pasajero pasajero;
public Vuelo getAvion() {
	return vuelo;
}
public void setAvion(Vuelo avion) {
	this.vuelo = avion;
}
public Pasajero getPasajero() {
	return pasajero;
}
public void setPasajero(Pasajero pasajero) {
	this.pasajero = pasajero;
}
public Registro(Vuelo avion, Pasajero pasajero) {
	super();
	this.vuelo = avion;
	this.pasajero = pasajero;
}

}
