package dto;

public class Reserva {

	private User usuario;
	private Clase clase;
	private String turno;

	/**
	 * @param usuario
	 * @param clase
	 * @param turno
	 */
	public Reserva(User usuario, Clase clase, String turno) {
		this.usuario = usuario;
		this.clase = clase;
		this.turno = turno;
	}

	/**
	 * @return the usuario
	 */
	public User getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(User usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return the clase
	 */
	public Clase getClase() {
		return clase;
	}

	/**
	 * @param clase the clase to set
	 */
	public void setClase(Clase clase) {
		this.clase = clase;
	}

	/**
	 * @return the turno
	 */
	public String getTurno() {
		return turno;
	}

	/**
	 * @param turno the turno to set
	 */
	public void setTurno(String turno) {
		this.turno = turno;
	}

}
