package edward74;

public class Student extends Person{
	
	String major;
	
public Student() {
		
		id = 0;
		age = 0;
		firstName = "";
		middleName = "";
		lastName = "";
		email = "";
		ssn = "";
		major = "";
	}
	
	public Student(int i, int a, String fN, 
				String mN, String lN, String em, String ss, String m) {
		
		// Setting logger levels
		id = i;
		age = a;
		firstName = fN;
		middleName = mN;
		lastName = lN;
		email = em;
		ssn = ss;
		major = m;
	}
	
	public void setMajor(String major) {
		this.major = major;
	}
	
	public String getMajor() {
		return this.major;
	}
}
