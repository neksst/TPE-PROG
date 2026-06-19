package tpe;

import java.util.ArrayList;

/*
 * estrategia: se ordenan los paquetes por peso descendente y se asigna cada uno
 * al primer camion que cumpla las restricciones de refrigeracion y capacidad
 * si ningun camion puede recibirlo, el paquete queda sin asignar
 * se cuenta cada vez que se evalua un camion como candidato para un paquete
 *
 * complejidad temporal: O(N log N + N*C)
 * N = cantidad de paquetes, C = cantidad de camiones
 * N log N por el ordenamiento, N*C por la asignacion de cada paquete a cada camion
 */
public class Greedy {

	private ArrayList<Camion> solucion;
	private int pesoNoAsignado;
	private int candidatosConsiderados;

	public void resolver(ArrayList<Camion> camiones, ArrayList<Paquete> paquetes) {
		this.pesoNoAsignado = 0;
		this.candidatosConsiderados = 0;
		this.solucion = camiones;

		ArrayList<Paquete> ordenados = new ArrayList<>(paquetes);
		ordenados.sort((a, b) -> b.getPeso() - a.getPeso());

		for (Paquete p : ordenados) {
			boolean asignado = false;

			for (Camion c : camiones) {
				candidatosConsiderados++;

				boolean cumpleRefrigeracion = !p.isContiene_alimentos() || c.isRefrigerado();
				boolean cumpleCapacidad = c.getCargaActual() + p.getPeso() <= c.getCapacidad();

				if (cumpleRefrigeracion && cumpleCapacidad) {
					c.asignarProducto(p);
					asignado = true;
					break;
				}
			}

			if (!asignado)
				pesoNoAsignado += p.getPeso();
		}
	}

	public ArrayList<Camion> getSolucion() {
		return solucion;
	}

	public int getPesoNoAsignado() {
		return pesoNoAsignado;
	}

	public int getCandidatosConsiderados() {
		return candidatosConsiderados;
	}
}
