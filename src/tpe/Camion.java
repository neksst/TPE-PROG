package tpe;

import java.util.ArrayList;

public class Camion {

	
	private Integer id;
	private String patente;
	private boolean refrigerado;
	private Integer capacidad;
	private ArrayList<Paquete> productos;
	
	public Camion(Integer id, String patente, boolean refrigerado, Integer capacidad) {
		super();
		this.id = id;
		this.patente = patente;
		this.refrigerado = refrigerado;
		this.capacidad = capacidad;
		this.productos = new ArrayList<Paquete>();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPatente() {
		return patente;
	}

	public void setPatente(String patente) {
		this.patente = patente;
	}

	public boolean isRefrigerado() {
		return refrigerado;
	}

	public void setRefrigerado(boolean refrigerado) {
		this.refrigerado = refrigerado;
	}

	public Integer getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(Integer capacidad) {
		this.capacidad = capacidad;
	}
	
	
	public void asignarProducto(Paquete p) {
		this.productos.add(p);
	}
	
	public void quitarProducto(Paquete p) {
		this.productos.remove(p);
	}
	
	@Override
	public String toString() {
		return "Camion [id=" + id + ", patente=" + patente + ", refrigerado=" + refrigerado + ", capacidad=" + capacidad
				+ "]";
	}

	
	
}
