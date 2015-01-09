package sppkg;
import java.util.*;

public class Student implements Comparable<Student> {
	private String lastName;
	private String firstName;
	private int[] grades;
	
	public Student(String lName, String fName, int[] grades) {
		lastName = lName;
		firstName = fName;
		this.grades = grades;
	}
	
	public String getLastName() {return lastName;}
	public String getFirstName() {return firstName;}
	public String getFullName() {return firstName + " " + lastName;}
	
	public double getAvg() {
		int total = 0;
		for (int grade : grades)
			total += grade;
		
		return total / grades.length;
	}
	
	public double getAvgWithoutLowestGrade() {
		Arrays.sort(grades);
		int total = 0;
		for (int i = 1; i < grades.length; i++)
			total += grades[i];
		
		return total / (grades.length - 1);
	}
	
	//compare based on getAvg()
	public int compareTo(Student other) {
		if (this.getAvg() == other.getAvg())
			return 0;
		else if (this.getAvg() < other.getAvg())
			return -1;
		
		return 1;
	}
	
	//lastName with firstName as tie breaker
	//and then by getAvg() if two students have the same name
	public int compareByName(Student other) {
		if (this.getLastName().compareTo(other.getLastName()) < 0)
			return -1;
		else if (this.getLastName().compareTo(other.getLastName()) == 0) {
			if (this.getFirstName().compareTo(other.getFirstName()) < 0)
				return -1;
			else if (this.getFirstName().compareTo(other.getFirstName()) == 0)
				return compareTo(other);
			else
				return 1;
		}
		
		return 1;
	}
	
	public int compareByAvgWithoutLowestGrade(Student other) {
		if (this.getAvgWithoutLowestGrade() == other.getAvgWithoutLowestGrade())
			return 0;
		else if (this.getAvgWithoutLowestGrade() < other.getAvgWithoutLowestGrade())
			return -1;
		
		return 1;
	}
	
	public static int roundUp(double value) {
		int intVal = (int)value;
		if (intVal == value)
			return intVal;
		else
			return intVal + 1;
	}
	
	public String toString() {
		return "" + roundUp(getAvg()) + ",   "+
			roundUp(getAvgWithoutLowestGrade()) +
			",  " + getFullName();
	} 
}	