package tpe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

//Completar con las estructuras y métodos privados que se
//requieran.

public class Servicios {

	private LinkedList<Paquete> paquetes;
	private LinkedList<Camion> camiones;
	private HashMap<String, Paquete> PaquetesMap;

	/*
	 * Expresar la complejidad temporal del constructor.
	 */
	
	// O(C + P) C -> Carga de camiones + P -> Carga de paquetes
	public Servicios(String pathCamiones, String pathPaquetes) {
		this.camiones = new LinkedList<Camion>();
		this.paquetes = new LinkedList<Paquete>();
		this.PaquetesMap = new HashMap<String, Paquete>();

		this.camiones = CamionLoader.loadCamiones(pathCamiones);
		this.paquetes = PaqueteLoader.loadPaquete(pathPaquetes);
		for (Paquete p : this.paquetes) {
			this.PaquetesMap.put(p.getCodigo_paquete(), p);
		}
	}

	/*
	 * Expresar la complejidad temporal del servicio 1.
	 */
	
	// O(1) Consulta de hashmap
	public Paquete servicio1(String codigoPaquete) {
		return this.PaquetesMap.get(codigoPaquete);
	}

	/*
	 * Expresar la complejidad temporal del servicio 2.
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
	 * Expresar la complejidad temporal del servicio 3.
	 */
	
	// O(P) Explora los paquetes de la lista
	public List<Paquete> servicio3(int urgenciaMinima, int urgenciaMaxima) {
		LinkedList<Paquete> res = new LinkedList<Paquete>();
		for(Paquete p : this.paquetes) {
			if((p.getNivel_urgencia() >=  urgenciaMinima) && (p.getNivel_urgencia() <= urgenciaMaxima)) {
				res.add(p);
			}
		}
		return res;
	}

}