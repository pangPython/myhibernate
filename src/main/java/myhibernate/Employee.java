package myhibernate;

import org.hibernate.annotations.Entity;
import org.hibernate.annotations.Table;

@Entity
@Table(  appliesTo = "EMPLOYEE" )
public class Employee {
	private String EmpId;

	public String getEmpId() {
		return EmpId;
	}

	public void setEmpId(String empId) {
		EmpId = empId;
	}
	
	
}
