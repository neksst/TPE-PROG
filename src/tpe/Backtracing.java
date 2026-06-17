package tpe;

import java.util.ArrayList;

public class Backtracing {
	private ArrayList<Camion> mejorSolucion;
	private int mejorPesoAsignado = -1;

	public ArrayList<Camion> resolver(ArrayList<Camion> camiones, ArrayList<Paquete> paquetes) {

		backtracking(camiones, paquetes, 0, 0);

		return mejorSolucion;
	}

	private void backtracking(ArrayList<Camion> camiones, ArrayList<Paquete> productos, int idx, int pesoAsignado) {

		if (idx == productos.size()) {

			if (pesoAsignado > mejorPesoAsignado) {
				mejorPesoAsignado = pesoAsignado;
				mejorSolucion = copiarCamiones(camiones);
			}

			return;
		}

		Paquete p = productos.get(idx);

		// Intentar asignarlo a cada camión válido
		for (Camion c : camiones) {

			boolean cumpleRefrigeracion = !p.isContiene_alimentos() || c.isRefrigerado();

			boolean cumpleCapacidad = c.getCapacidad() + p.getPeso() <= c.getCapacidad();

			if (cumpleRefrigeracion && cumpleCapacidad) {

				c.asignarProducto(p);

				backtracking(camiones, productos, idx + 1, pesoAsignado + p.getPeso());

				c.quitarProducto(p);
			}
		}

	}

	private ArrayList<Camion> copiarCamiones(ArrayList<Camion> camiones) {

		ArrayList<Camion> copia = new ArrayList<>();

		for (Camion c : camiones) {
			copia.add(c); // 
		}

		return copia;
	}
}
