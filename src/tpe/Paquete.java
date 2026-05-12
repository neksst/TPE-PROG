package tpe;

public class Paquete {

	private Integer id;
	private String codigo_paquete;
	private Integer peso;
	private boolean contiene_alimentos;
	private Integer nivel_urgencia;

	public Paquete(Integer id, String codigo_paquete, Integer peso, boolean contiene_alimentos,
			Integer nivel_urgencia) {
		super();
		this.id = id;
		this.codigo_paquete = codigo_paquete;
		this.peso = peso;
		this.contiene_alimentos = contiene_alimentos;
		this.setNivel_urgencia(nivel_urgencia);
	}

	public String getCodigo_paquete() {
		return codigo_paquete;
	}

	public void setCodigo_paquete(String codigo_paquete) {
		this.codigo_paquete = codigo_paquete;
	}

	public Integer getPeso() {
		return peso;
	}

	public void setPeso(Integer peso) {
		this.peso = peso;
	}

	public boolean isContiene_alimentos() {
		return contiene_alimentos;
	}

	public void setContiene_alimentos(boolean contiene_alimentos) {
		this.contiene_alimentos = contiene_alimentos;
	}

	public Integer getNivel_urgencia() {
		return nivel_urgencia;
	}

	public void setNivel_urgencia(Integer nivel_urgencia) {
		if ((nivel_urgencia < 1) || (nivel_urgencia > 100)) {
			throw new IllegalArgumentException("El nivel de urgencia debe estar entre 1 y 100");
		}
		this.nivel_urgencia = nivel_urgencia;
	}

	public Integer getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Paquete [id=" + id + ", codigo_paquete=" + codigo_paquete + ", peso=" + peso + ", contiene_alimentos="
				+ contiene_alimentos + ", nivel_urgencia=" + nivel_urgencia + "]";
	}
	
	

}
