package tpe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;


public class Servicios {

	private LinkedList<Paquete> paquetes;
	private LinkedList<Camion> camiones;
	private HashMap<String, Paquete> PaquetesMap;
	private ArrayList<Paquete>[] paquetesPorUrgencia;


	/*
	 * Complejidad temporal del constructor: O(N)
	 * N = cantidad de paquetes. Se recorre una vez para poblar el HashMap y el array de urgencias.
	 */
	public Servicios(String pathCamiones, String pathPaquetes) {
		this.camiones = new LinkedList<Camion>();
		this.paquetes = new LinkedList<Paquete>();
		this.PaquetesMap = new HashMap<String, Paquete>();

		this.camiones = CamionLoader.loadCamiones(pathCamiones);
		this.paquetes = PaqueteLoader.loadPaquete(pathPaquetes);
		this.paquetesPorUrgencia = new ArrayList[101];
		for (Paquete p : this.paquetes) {
			this.PaquetesMap.put(p.getCodigo_paquete(), p);
			int u = p.getNivel_urgencia();
			if (this.paquetesPorUrgencia[u] == null)
				this.paquetesPorUrgencia[u] = new ArrayList<>();
			this.paquetesPorUrgencia[u].add(p);
		}
	}


	/*
	 * Complejidad temporal del servicio 1: O(1)
	 * Acceso directo al HashMap por codigo de paquete.
	 */
	public Paquete servicio1(String codigoPaquete) {
		return this.PaquetesMap.get(codigoPaquete);
	}

	
	/*
	 * Complejidad temporal del servicio 2: O(N)
	 * N = cantidad de paquetes. Se recorre la lista completa para filtrar.
	 */
	public List<Paquete> servicio2(boolean contieneAlimentos) {

		ArrayList<Paquete> l = new ArrayList<>();
		for (Paquete p : this.paquetes) {
			if (p.isContiene_alimentos() == contieneAlimentos) {
				l.add(p);
			}

		}
		return l;

	}


	/*
	 * Complejidad temporal del servicio 3: O(rango + resultado)
	 * rango = urgenciaMaxima - urgenciaMinima. Se accede directamente por indice al array de urgencias.
	 */
	public List<Paquete> servicio3(int urgenciaMinima, int urgenciaMaxima) {
		ArrayList<Paquete> resultado = new ArrayList<>();
		for (int i = urgenciaMinima; i <= urgenciaMaxima; i++) {
			if (this.paquetesPorUrgencia[i] != null)
				resultado.addAll(this.paquetesPorUrgencia[i]);
		}
		return resultado;
	}

}
