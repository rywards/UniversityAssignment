package edward74;
import java.util.HashMap;
import java.util.Scanner;
import java.util.logging.Level;
/**
 * Driver for the person class
 * @author Ryan Edwardss
 *
 */
public class PersonApp {
	
	public static void main(String[] args) {
		
		
		int age , id;
		String firstName, middleName, lastName, email, ssn; 
		
		/*
		 * Creating instances of all the classes I'll need in the driver.
		 */
		Scanner input = new Scanner(System.in);
		Person human = new Person();
		Instructor professorJohnathan = new Instructor(71942, 35, "Johnathan", "James", "Jebediahst", "JoJaJe@hotmail.org", 
												"111-22-3456", "Human Resources");
		Student studentRyan = new Student(13345, 22, "Ryan", "Scott", "Edwards", "edward74@students.rowan.edu",
										"222-33-4455", "Computer Science");

		
		// Setting human's id.
		human.setId(16261);
		
		// Beginning entrance of human's data from user.
		System.out.println("Enter the person's first name \n");
		firstName = input.nextLine();
		human.setFirstName(firstName);
		
		System.out.println("Enter the person's middle name \n");
		middleName = input.nextLine();
		human.setMiddleName(middleName);
		
		System.out.println("Enter the person's last name \n");
		lastName = input.nextLine();
		human.setLastName(lastName);
		
		// Created loops to ensure invalid input is corrected.
		do {
			System.out.println("Enter the person's SSN in ###-##-#### format \n");
			ssn = input.nextLine();
			human.setSsn(ssn);
		}while (human.validSSN(human.getSsn()) == false);
		
		do {
			System.out.println("Enter the person's email address \n");
			email = input.nextLine();
			human.setEmail(email);
		}while (human.validEmail(human.getEmail()) == false);
		
		do {
		System.out.println("Enter the person's age \n");
		age = input.nextInt();
		human.setAge(age);
		}while (human.validAge(Integer.toString(human.getAge())) == false);
		
		HashMap<String, Person> personMap = new HashMap<String, Person>();
		
		input.close();
		System.exit(0);
	}

}
