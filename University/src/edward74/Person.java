package edward74;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.HashMap;
/**
 * This is the Person class containing everything required to make a person 
 * at the 'University'.
 * @author Ryan Edwards
 * @version 2.7.2020
 */
public class Person {
	
	// Used PersonExample to implement this logger
	private final static Logger personLogger = Logger.getLogger(Person.class.getName());
	private final Logger  instanceLogger = Logger.getLogger(Person.class.getName() + this.hashCode());
	private final Logger ageLogger = Logger.getLogger(Person.class.getName() + this.hashCode());
	private final Logger emailLogger = Logger.getLogger(Person.class.getName() + this.hashCode());
	private final Logger ssnLogger = Logger.getLogger(Person.class.getName() + this.hashCode());
	
	// Created static length of SSN because it doesn't change.
	static final int SSN_LENGTH = 11;
			
	int id;
	String ssn;
	int age;
	String firstName, middleName, lastName, email; 

	
	/**
	 * No arg constructor for Person setting all instance variables to a default empty and setting
	 * log levels.
	 */
	public Person() {
		
		// Setting logger levels
		instanceLogger.setLevel(Level.WARNING);
		ageLogger.setLevel(Level.INFO);
		emailLogger.setLevel(Level.INFO);
		ssnLogger.setLevel(Level.INFO);
		
		id = 0;
		age = 0;
		firstName = "";
		middleName = "";
		lastName = "";
		email = "";
		ssn = "";
	}
	
	public Person(int i, int a, String fN, 
				String mN, String lN, String em, String ss) {
		
		// Setting logger levels
		instanceLogger.setLevel(Level.WARNING);
		ageLogger.setLevel(Level.INFO);
		emailLogger.setLevel(Level.INFO);
		ssnLogger.setLevel(Level.INFO);
		
		id = i;
		age = a;
		firstName = fN;
		middleName = mN;
		lastName = lN;
		email = em;
		ssn = ss;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	
	public String toString() {
		String fullName = firstName + " " + middleName + " " + lastName + "\n";
		return fullName;
	}
	
	/**
	 * Returns the email domain. Used after validation.
	 * @return domain
	 */
	String getEmailDomain() {
		
		// Creating an array of String type to grab the @ from the email.
		String[] domain = email.split("@");
		
		// Looping through 
		for (String str : domain) {
			System.out.println(str);
		}
		return null;
	}
	
	/**
	 * Returns the last four of the Person's ssn.
	 * Assumes valid SSN has been entered.
	 * @param social
	 * @return lastFour
	 */
	String getLast4SSN(String social) {
		int i = 0;
		char ch;
		String lastFour = "";
		
		while (i < social.length()) {
			ch = social.charAt(i);
			if (Character.isDigit(ch)) {
				i++;
			}
			if (ch == '-') {
				social.substring(social.indexOf(ch));
				i = 0;
			}
			if (i == 4 && ch != '-') {
				lastFour = social.substring(ch);
				break;
			}
			
		}
		return lastFour;
	}
	
	/**
	 * Checks if age is greater than, less than, or equal to 16
	 * @param testAge
	 * @return boolean
	 */
	 boolean validAge(String testAge) {
		
		int age = Integer.parseInt(testAge);
		
		// If the age is less than 16, they are too young and returns false.
		if (age <= 16) {
			
			ageLogger.log(Level.INFO, "AgeLogger: You are under 16!");
			instanceLogger.log(Level.INFO, "InstanceLogger: Age under 16 entered.");
			personLogger.log(Level.INFO, "ClassLogger: Age under 16 entered.");
			
			return false;
		}
		if (age > 100) {
			ageLogger.log(Level.INFO, "AgeLogger: You are 100!!");
			instanceLogger.log(Level.INFO, "InstanceLogger: User is over 100!");
			personLogger.log(Level.INFO, "ClassLogger: User is over 100!");
			return true;
		}
		else {
			return true;
		}

	}
	
	/**
	 * Checks if the user enters a correct email address.
	 * @param testEmail
	 * @return boolean
	 */
	boolean validEmail(String testEmail) {
			
		int atCounter = 0;
		
		// Looping through email string.
		for (int i = 0; i < testEmail.length(); i++) {
			
			// Checking the amount of @'s in the email.
			char check = testEmail.charAt(i);
			if (check == '@') {
				atCounter++;
				
				// If the counter is greater than one, the email will be invalid.
				if (atCounter > 1) {
					emailLogger.log(Level.INFO, "EmailLogger: Invalid email entered!");
					instanceLogger.log(Level.INFO, "InstanceLogger: User entered invalid email address.");
					personLogger.log(Level.INFO, "ClassLogger: User entered invalid email address. ");
					return false;
				}
			}
		}
		// If the @ index is greater than the '.' index, the email will be invalid.
		if (testEmail.indexOf('@') > testEmail.indexOf('.')) {
			System.out.println("Invalid email address.\nPlease place the '.' after the '@' symbol.");
			return false;
		}
		
		// Using the java String regex matches method to look for email matches.
		if (testEmail.matches("(.+)@([^.].+).(.+)") == false) {
			System.out.println("Invalid email.\nEnter character between the '@' and '.' characters.");
			return false;
		}
		return true;
	}
		
	/**
	 * Checks if the user inputs a valid ssn.
	 * @param testSSN
	 * @return boolean
	 */
	boolean validSSN(String testSSN) {
		
		/*
		 * Professor, I know we discussed using substring during office hours, but I found
		 * .matches was a lot easier to use. I don't know if it processes quicker though.
		 */
		if (testSSN.length() != SSN_LENGTH) {
			ssnLogger.log(Level.INFO, "SSNLogger: SSN length not correct.");
			instanceLogger.log(Level.INFO, "InstanceLogger: SSN length not correct.");
			personLogger.log(Level.INFO, "ClassLogger: SSN length not correct.");
			return false;
		}
		
		if (testSSN.matches("(\\d{3})-(\\d{2})-(\\d{4})") == false){
			System.out.println("Enter a SSN in format 123-45-6789");
			
			ssnLogger.log(Level.INFO, "SSNLogger: SSN not correct format.");
			instanceLogger.log(Level.INFO, "InstanceLogger: SSN not correct format.");
			personLogger.log(Level.INFO, "ClassLogger: SSN not correct format.");
			
			return false;
		}
		
		return true;
	}
}
