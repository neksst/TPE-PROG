package tpe;

import java.util.ArrayList;
import java.util.LinkedList;

public class Main {

	public static void main(String[] args) {

		Servicios s = new Servicios("data/Camiones.csv", "data/Paquetes.csv");

		// Servicio 1
		System.out.println("Servicio 1: " + s.servicio1("P004"));

		// Servicio 2
		System.out.println("Servicio 2 (con alimentos): " + s.servicio2(true));
		System.out.println("Servicio 2 (sin alimentos): " + s.servicio2(false));

		// Servicio 3
		System.out.println("Servicio 3 (urgencia 50-90): " + s.servicio3(50, 90));

		// Backtracking
		ArrayList<Camion> camiones = new ArrayList<>(CamionLoader.loadCamiones("data/Camiones.csv"));
		ArrayList<Paquete> paquetes = new ArrayList<>(PaqueteLoader.loadPaquete("data/Paquetes.csv"));

		Backtracing bt = new Backtracing();
		bt.resolver(camiones, paquetes);
		System.out.println("\nBacktracking");
		for (Camion c : bt.getMejorSolucion())
			System.out.println(c);
		System.out.println("Peso no asignado: " + bt.getMejorPesoNoAsignado() + " kg.");
		System.out.println("Estados generados: " + bt.getEstadosGenerados());

		// Greedy
		ArrayList<Camion> camionesGreedy = new ArrayList<>(CamionLoader.loadCamiones("data/Camiones.csv"));
		Greedy g = new Greedy();
		g.resolver(camionesGreedy, paquetes);
		System.out.println("\nGreedy");
		for (Camion c : g.getSolucion())
			System.out.println(c);
		System.out.println("Peso no asignado: " + g.getPesoNoAsignado() + " kg.");
		System.out.println("Candidatos considerados: " + g.getCandidatosConsiderados());
	}

}
