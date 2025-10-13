package Actividad_03_Pony;

public class Pony {
	private String nombre;
	private int nivelAmistad;

	public Pony(String nombre, int nivelAmistad) {
		this.nombre = nombre;
		this.nivelAmistad = nivelAmistad;
	}

	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}


