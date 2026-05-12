package tpe;

public class Camion {

	
	private Integer id;
	private String patente;
	private boolean refrigerado;
	private Integer capacidad;
	
	public Camion(Integer id, String patente, boolean refrigerado, Integer capacidad) {
		super();
		this.id = id;
		this.patente = patente;
		this.refrigerado = refrigerado;
		this.capacidad = capacidad;
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
	
	@Override
	public String toString() {
		return "Camion [id=" + id + ", patente=" + patente + ", refrigerado=" + refrigerado + ", capacidad=" + capacidad
				+ "]";
	}

	
	
}
