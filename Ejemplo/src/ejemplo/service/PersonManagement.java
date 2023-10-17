package ejemplo.service;

import ejemplo.management.Employee;
import ejemplo.management.Person;

public class PersonManagement {

	public static void main(String[] args) {

		Person emp = new Employee("Paco el opaco", 10, 320, "Charcutero");
		
		emp.showData();
	}

}
