package uniquindio.lenguaje.mundo;

public abstract class Persona {

protected String nombre;
protected String id;
protected String edad;
public abstract String toString();
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getEdad() {
	return edad;
}
public void setEdad(String edad) {
	this.edad = edad;
}
public Persona(String nombre, String id, String edad) {
	super();
	this.nombre = nombre;
	this.id = id;
	this.edad = edad;
}

public boolean equals(Pasajero p) {

if(p.getId().equals(id))
{
	return true;
}
	return false;
}
}
