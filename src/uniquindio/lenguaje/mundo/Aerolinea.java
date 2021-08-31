package uniquindio.lenguaje.mundo;

import java.util.ArrayList;

public class Aerolinea {
private ArrayList<Registro> registros = new ArrayList<Registro>();
private Vuelo vueloMede = new Vuelo(new Avion("Medellin"), 180000);
private Vuelo vueloBogo = new Vuelo(new Avion("Bogota"), 80000);

public Aerolinea () {
	
}

public Vuelo getVueloMasOcupado() {

	Vuelo vuelo = null;
	if(vueloMede.getAvion().getSillasOcupadas() > vueloBogo.getAvion().getSillasOcupadas())
	{
		vuelo= vueloMede;
	}else {
		vuelo = vueloBogo;
	}
		
   return vuelo;
}
public ArrayList<Registro> getRegistros() {
	return registros;
}
public void setRegistros(ArrayList<Registro> registros) {
	this.registros = registros;
}
public Vuelo getVueloMede() {
	return vueloMede;
}
public void setVueloMede(Vuelo vueloMede) {
	this.vueloMede = vueloMede;
}
public Vuelo getVueloBogo() {
	return vueloBogo;
}
public void setVueloBogo(Vuelo vueloBogo) {
	this.vueloBogo = vueloBogo;
}

}
