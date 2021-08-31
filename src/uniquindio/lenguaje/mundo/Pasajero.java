package uniquindio.lenguaje.mundo;

public class Pasajero extends Persona {
	private String email;
	private String direccion;
	public Pasajero(String nombre, String id, String edad, String email, String direccion) {
		super(nombre, id, edad);
		this.direccion = direccion;
		this.email = email;
	}
	@Override
	public String toString() {
		String cadena = nombre + ", " + id;
		return cadena;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

}
