package uniquindio.lenguaje.mundo;

import java.util.ArrayList;

public class Vuelo {

	private Avion avion;
	private String destino;
	private int precio;
	private ArrayList<Pasajero> pasajeros = new ArrayList<Pasajero>();
	public Vuelo(Avion avion, int precio) {
		super();
		this.avion = avion;
		this.precio = precio;
		this.destino = avion.getDestino();
	}
	public Avion getAvion() {
		return avion;
	}
	public void setAvion(Avion avion) {
		this.avion = avion;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public void añadirPasajero(Pasajero p)
	{
	pasajeros.add(p);
	}
	
	public int getDineroRecaudado() {
		int dinero = 0;
        for(int i=0;i<pasajeros.size();i++)
        {
        	dinero += precio;
        }
		
		return dinero;
	}
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	
}
