package sppkg;
import java.util.*;
import java.io.*;

public class Reader {
	public static void main(String[] args) throws IOException {
		File input = new File("students.csv");
		Scanner scanCount = new Scanner(input);
		
		int count = 0;
		while (scanCount.hasNextLine()) {
			scanCount.nextLine();
			count++;
		}
		
		scanCount.close();
		Students students = new Students(count);
		count = 0;
		Scanner scan = new Scanner(input);
		
		while (scan.hasNextLine()) {
			String[] studentData = scan.nextLine().split(",");
			int[] grades = new int[studentData.length - 2]; 
			for (int i = 0; i < studentData.length - 2; i++)
				grades[i] = Integer.parseInt(studentData[i + 2]);
			Student student = new Student(studentData[0], studentData[1], grades);
			
			students.setStudent(count, student);
			count++;
		}
		
		scan.close();
		System.out.println(students);
		students.sortByAvg(true);
		System.out.println(students);
		students.sortByAvg(false);
		System.out.println(students);
		students.sortByName(true);
		System.out.println(students);
		students.sortByName(false);
		System.out.println(students);
		students.sortByAvgWithoutLowestGrade(true);
		System.out.println(students);
		students.sortByAvgWithoutLowestGrade(true);
		System.out.println(students);
	}	
}