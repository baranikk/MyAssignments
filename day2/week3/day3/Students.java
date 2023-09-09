package week3.day3;

public class Students {

	//Create multiple getStudentInfo() method by passing id argument alone, by id & name, by email & phoneNumber
		public void getStudentInfo(String id)
		{
			System.out.println("Calling the method with only id");
			System.out.println("Student id: "+id);
		}
		public void getStudentInfo(String id, String name)
		{
			System.out.println("\n\nCalling the method with id and input arguments");
			System.out.println("Student id: "+id);
			System.out.println("Student name: "+id);
			
		}
		public void getStudentInfo(String id, String email,String mobNo)
		{
			System.out.println("\n\nCalling the method with id, email and mobile number arguments");
			System.out.println("Student id: "+id);
			System.out.println("Student email: "+email);
			System.out.println("Student Mobile no.: "+mobNo);
			
			
		}
		
		public static void main(String[] args) {
			
			Students stud=new Students();
			stud.getStudentInfo("123");
			stud.getStudentInfo("123", "Kantha");
			stud.getStudentInfo("123","kanthakrishnan@gmail.com","9790990450");
			
		}

	}