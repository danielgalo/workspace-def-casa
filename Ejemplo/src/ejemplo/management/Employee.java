/**
 * 
 */
package ejemplo.management;

/**
 * 
 */
public class Employee extends Person {

	private int empId;
	
	private String charge;
	
	public Employee(String name, int age, int empId, String charge) {
		super(name, age);
		setEmpId(empId);
		setCharge(charge);
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getCharge() {
		return charge;
	}

	public void setCharge(String charge) {
		this.charge = charge;
	}

}
