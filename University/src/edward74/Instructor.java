package edward74;

import java.util.logging.Level;

public class Instructor extends Person {
	
	String department;
	
	public Instructor() {
		
		id = 0;
		age = 0;
		firstName = "";
		middleName = "";
		lastName = "";
		email = "";
		ssn = "";
		department = "";
	}
	
	public Instructor(int i, int a, String fN, 
				String mN, String lN, String em, String ss, String d) {
		
		// Setting logger levels
		id = i;
		age = a;
		firstName = fN;
		middleName = mN;
		lastName = lN;
		email = em;
		ssn = ss;
		department = d;
	}
	
	public void setDepartment(String department) {
		this.department = department;
	}
	
	public String getDepartment() {
		return this.department;
	}
	
}
