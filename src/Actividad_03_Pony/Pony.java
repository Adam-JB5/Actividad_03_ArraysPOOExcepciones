package Actividad_03_Pony;

public class Pony {
	private String nombre;
	private int nivelAmistad;

	public Pony(String nombre, int nivelAmistad) {
		this.nombre = nombre;
		this.nivelAmistad = clamp(nivelAmistad, 0, 18);
	}

	public void acariciar() {
		System.out.println("Has acariciado al Pony");
		subir(2);
	}

	public void darDeComer() {
		System.out.println("Has dado de comer al Pony");
		subir(3);
	}

	public void criticarPeinado() {
		int nuevo = nivelAmistad - 4;
		
		if (nuevo < 0) {
			throw new IllegalStateException("El nivel de amistad no puede ser negativo (intento: " + nuevo + ").");
		}
		nivelAmistad = nuevo;
    }

	private void subir(int valorASumar) {

		nivelAmistad = Math.min(18, nivelAmistad + valorASumar);

		if (nivelAmistad == 18) {
			System.out.println("✨ " + this.nombre + " ha PONIEVOLUCIONADO al alcanzar amistad 18 ✨");
		}
	}

	private int clamp(int nivelAmistad, int min, int max) {

		if (nivelAmistad < min) {
			return min;
		}

		if (nivelAmistad > max) {
			return max;
		}

		return nivelAmistad;
	}

	@Override
	public String toString() {
		return "Nombre: " + nombre + " | Nivel de amistad: " + nivelAmistad;
	}

	// Getters y Setters nombre
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	// Getters y Setters nivelAmistad
	public int getNivelAmistad() {
		return nivelAmistad;
	}

	public void setNivelAmistad(int nivelAmistad) {
		this.nivelAmistad = nivelAmistad;
	}

}
