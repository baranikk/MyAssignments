package week3.day3;

public class Student extends Department {
	public String studentName() {
		return "Kantha";

	}

	public String studentGrade() {
		return "S";

	}

	public String studentId() {
		return "123";

	}

	public static void main(String[] args) {
		Student stud = new Student();
		System.out.println("**Student Details");
		System.out.println(" Id: " + stud.studentId());
		System.out.println("Name: " + stud.studentName());
		System.out.println("Grade: " + stud.studentGrade());
		System.out.println(" Department: " + stud.deptName());
		System.out.println("College Name: " + stud.collegeName());
		System.out.println("College Code: " + stud.collegeCode());
		System.out.println("College Rank: " + stud.collegeRank());

	}

}