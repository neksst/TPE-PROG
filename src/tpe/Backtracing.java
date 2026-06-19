package tpe;

import java.util.ArrayList;

/*
 * Estrategia: se recorren los paquetes uno por uno (indice idx)
 * para cada paquete se prueban todas las asignaciones a camiones cumpliendo las restricciones de refrigeracion y capacidad
 * y tambien la opcion de no asignarlo
 * se lleva registro del peso no asignado actual y se actualiza la mejor solucion
 * cuando se procesa el ultimo paquete y el peso no asignado es menor al mejor conocido
 * 
 * poda: si el peso no asignado actual ya es mayor o igual al mejor conocido, se corta
 *
 * complejidad temporal: O((C+1)^N)
 * N = cantidad de paquetes, C = cantidad de camiones
 * por cada paquete hay C posibles asignaciones mas la opcion de no asignarlo
 */
public class Backtracing {

	private ArrayList<Camion> mejorSolucion;
	private int mejorPesoNoAsignado;
	private int estadosGenerados;

	public void resolver(ArrayList<Camion> camiones, ArrayList<Paquete> paquetes) {
		this.mejorPesoNoAsignado = Integer.MAX_VALUE;
		this.estadosGenerados = 0;
		this.mejorSolucion = null;

		backtracking(camiones, paquetes, 0, 0);
	}

	private void backtracking(ArrayList<Camion> camiones, ArrayList<Paquete> paquetes, int idx, int pesoNoAsignado) {

		estadosGenerados++;

		// poda: si ya supera la mejor solucion no seguir
		if (pesoNoAsignado >= mejorPesoNoAsignado)
			return;

		if (idx == paquetes.size()) {
			mejorPesoNoAsignado = pesoNoAsignado;
			mejorSolucion = copiarCamiones(camiones);
			return;
		}

		Paquete p = paquetes.get(idx);

		for (Camion c : camiones) {
			boolean cumpleRefrigeracion = !p.isContiene_alimentos() || c.isRefrigerado();
			boolean cumpleCapacidad = c.getCargaActual() + p.getPeso() <= c.getCapacidad();

			if (cumpleRefrigeracion && cumpleCapacidad) {
				c.asignarProducto(p);
				backtracking(camiones, paquetes, idx + 1, pesoNoAsignado);
				c.quitarProducto(p);
			}
		}

		backtracking(camiones, paquetes, idx + 1, pesoNoAsignado + p.getPeso());
	}

	// se copian los camiones para guardar el estado actual sin que el backtracking lo modifique

	private ArrayList<Camion> copiarCamiones(ArrayList<Camion> camiones) {
		ArrayList<Camion> copia = new ArrayList<>();
		for (Camion c : camiones) {
			Camion nuevo = new Camion(c.getId(), c.getPatente(), c.isRefrigerado(), c.getCapacidad());
			for (Paquete p : c.getProductos())
				nuevo.asignarProducto(p);
			copia.add(nuevo);
		}
		return copia;
	}

	public ArrayList<Camion> getMejorSolucion() {
		return mejorSolucion;
	}

	public int getMejorPesoNoAsignado() {
		return mejorPesoNoAsignado;
	}

	public int getEstadosGenerados() {
		return estadosGenerados;
	}
}
