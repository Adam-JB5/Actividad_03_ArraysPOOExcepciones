package Actividad_03_Pony;

public class PonyApp {

	public static void main(String[] args) {
		
		Pony p = new Pony("PonyPrueba", 17);
		
		System.out.println(p);
		
		p.darDeComer(); // deberíallegar a 18 y “ponyevolucionar”
		
		System.out.println(p);
		
	}

}
