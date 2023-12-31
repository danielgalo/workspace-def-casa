package dto;

/**
 * Clase que representa a un empleado
 */
public class Empleado {

	/** Id del empleado */
	private int id;

	/** Nombre del empleado */
	private String nombre;

	/** Apellidos del empleado */
	private String apellidos;

	/** Cargo del empleado */
	private String cargo;

	/** Salario del empleado */
	private double salario;

	/** Contratacion del empleado */
	private String fechaContratacion;

	/** Id de la empresa del empleado */
	private int empresaId;

	/**
	 * Constructor
	 * 
	 * @param id
	 * @param nombre
	 * @param apellidos
	 * @param cargo
	 * @param salario
	 * @param fechaContratacion
	 * @param empresaId
	 */
	public Empleado(int id, String nombre, String apellidos, String cargo, double salario, String fechaContratacion,
			int empresaId) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.cargo = cargo;
		this.salario = salario;
		this.fechaContratacion = fechaContratacion;
		this.empresaId = empresaId;
	}

	public String getDatosEmpleado() {
		return "Id: " + getId() + "| Nombre: " + getNombre() + " | Apellidos: " + getApellidos() + " | Cargo: "
				+ getCargo() + " | Salario: " + getSalario() + " | Fecha de contratación: " + getFechaContratacion()
				+ " | Id empresa: " + getEmpresaId();
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the apellidos
	 */
	public String getApellidos() {
		return apellidos;
	}

	/**
	 * @param apellidos the apellidos to set
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	/**
	 * @return the cargo
	 */
	public String getCargo() {
		return cargo;
	}

	/**
	 * @param cargo the cargo to set
	 */
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	/**
	 * @return the salario
	 */
	public double getSalario() {
		return salario;
	}

	/**
	 * @param salario the salario to set
	 */
	public void setSalario(double salario) {
		this.salario = salario;
	}

	/**
	 * @return the fechaContratacion
	 */
	public String getFechaContratacion() {
		return fechaContratacion;
	}

	/**
	 * @param fechaContratacion the fechaContratacion to set
	 */
	public void setFechaContratacion(String fechaContratacion) {
		this.fechaContratacion = fechaContratacion;
	}

	/**
	 * @return the empresaId
	 */
	public int getEmpresaId() {
		return empresaId;
	}

	/**
	 * @param empresaId the empresaId to set
	 */
	public void setEmpresaId(int empresaId) {
		this.empresaId = empresaId;
	}

}
