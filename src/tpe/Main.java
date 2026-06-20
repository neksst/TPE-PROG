package tpe;

import java.util.LinkedList;

public class Main {

	public static void main(String[] args) {
		

		/*Servicios s = new Servicios("/home/agus/Escritorio/TPE/Camiones.csv","/home/agus/Escritorio/TPE/Paquetes.csv");
		
		System.out.println(s.servicio1("P022201"));
		System.out.println(s.servicio2(false));
		System.out.println(s.servicio3(1, 200));*/
		
		
		LinkedList<Camion> mioncas = CamionLoader.loadCamiones("/home/agus/Escritorio/TPE/Camiones.csv");
		LinkedList<Paquete> packs  = PaqueteLoader.loadPaquete("/home/agus/Escritorio/TPE/Paquetes.csv") ;
		Backtracking b = new Backtracking();
		
		b.resolver(mioncas, packs);
		System.out.println(b.getMejorSolucion());
		System.out.println(b.getEstadosGenerados());
		
		Greedy g = new Greedy();
		g.resolver(mioncas, packs);
		System.out.println(g.getSolucion());
	}

}
