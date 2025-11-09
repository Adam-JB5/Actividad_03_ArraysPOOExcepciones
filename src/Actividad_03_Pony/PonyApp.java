package Actividad_03_Pony;

import java.util.Iterator;
import java.util.Scanner;

public class PonyApp {

	private static Pony[] ponies = { new Pony("Twilight Sparkle", 10), new Pony("Rainbow Dash", 8),
			new Pony("Pinky Pie", 6), new Pony("Rarity", 7), new Pony("Fluttershy", 3), new Pony("Applejack", 5), };

	private static final int MAX_LOG = 200;
	private static String[] logNombres = new String[MAX_LOG];
	private static int[] logNiveles = new int[MAX_LOG];
	private static int logIdX = 0;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		boolean salir = false;
		System.out.println("======  PONY APP  ======");
		while (!salir) {
			try {
				mostrarPonies();
				System.out.println("Elige un pony por su número || -1 Para mostrar los logs || 0 para salir");
				int opcionPony = sc.nextInt();

				if (opcionPony == 0) {
					salir = true;
					continue;
				} else if (opcionPony == -1) {
					mostrarLogs();
					continue;
				}

				int idX = opcionPony - 1;

				if (idX < 0 || idX > 5) {
					System.out.println("Opcion de Pony no válida");
					continue;
				}

				Pony pony = ponies[idX];

				System.out.println(
						"Has elegido a " + pony.getNombre() + "\n\tNivel de amistad: " + pony.getNivelAmistad());

				System.out.println("======  ACCIONES  ======");
				System.out.println("  1) Acariciar (+2)");
				System.out.println("  2) Dar de comer (+3)");
				System.out.println("  3) Criticar peinado (-4, puede lanzar excepción)");
				System.out.print("Elige una acción (1-3): ");

				int accion = sc.nextInt();

				switch (accion) {
				case 1: {
					pony.acariciar();
					break;
				}
				case 2: {
					pony.darDeComer();
					break;
				}
				case 3: {

					try {
						pony.criticarPeinado();
					} catch (IllegalStateException e) {
						System.out.println("Excepción: " + e);
					}
					break;

				}
				default:
					System.out.println("No se ha introducido una opción válida. Introduzca una opción válida (1-3)");
					continue;
				}

				registrarLog(pony.getNombre(), pony.getNivelAmistad());

				System.out.println(
						"Ahora: " + pony.getNombre() + " tiene un nivel de amistad de: " + pony.getNivelAmistad());
				System.out.println("(Log guardado: [" + pony.getNombre() + ", " + pony.getNivelAmistad() + "])");

			} catch (NumberFormatException e) {
				System.out.println("Entrada no válida. Escribe un número entero.");
				
			} catch (Exception e) {
				System.out.println("Ha habido un error: " + e.getMessage());
				
			}
			
			System.out.println("¡Hasta luego!");
			
			
		}
		sc.close();

//		Pony p = new Pony("PonyPrueba", 17);
//		
//		System.out.println(p);
//		
//		p.darDeComer(); // deberíallegar a 18 y “ponyevolucionar”
//		
//		System.out.println(p);
//		
	}

	private static void mostrarPonies() {
		System.out.println("\nPonies disponibles:");

		for (int i = 0; i < ponies.length; i++) {
			System.out.println((i + 1) + ". " + ponies[i]);
		}
	}

	private static void registrarLog(String nombre, int nivel) {
		if (logIdX < MAX_LOG) {
			logNombres[logIdX] = nombre;
			logNiveles[logIdX] = nivel;
			logIdX++;
		}
	}

	private static void mostrarLogs() {
		System.out.println("\n--- LOGS (nombre, nivelDeAmistad) ---");

		if (logIdX == 0) {
			System.out.println("Log vacío");
			return;
		}

		for (int i = 0; i < logIdX; i++) {
			System.out.println((i + 1) + ") " + logNombres[i] + " - " + logNiveles[i]);
		}

		System.out.println("--------------------  FIN  --------------------\n");
	}

}
