package sppkg;

public class Students {
	private Student[] students;
	
	public Students(int numOfStudents) {
		students = new Student[numOfStudents];
	}
	
	public boolean setStudent(int index, Student s) {
		if (index < students.length)
		{
			students[index] = s;
			return true;
		}
		else
			return false;
	}
	
	//descending sort
	public void sortByAvg(boolean asc) {
		if (asc == true) {
			for (int j = 0; j < students.length - 1; j++) {
				int minIndex = j;
				for (int k = j + 1; k < students.length; k++) 
					if (students[k].getAvg() < students[minIndex].getAvg())
						minIndex = k;
				swap(j, minIndex);
		}}
		
		else
			for (int j = 0; j < students.length - 1; j++) {
				int maxIndex = j;
				for (int k = j + 1; k < students.length; k++) 
					if (students[k].getAvg() > students[maxIndex].getAvg())
						maxIndex = k;
				swap(j, maxIndex);
			}
	}
	
	public void sortByName(boolean asc) {
		if (asc == true) {
			for (int j = 0; j < students.length - 1; j++) {
				int minIndex = j;
				for (int k = j + 1; k < students.length; k++) 
					if (students[k].compareByName(students[minIndex]) == -1)
						minIndex = k;
				swap(j, minIndex);
		}}
		else
			for (int j = 0; j < students.length - 1; j++) {
				int maxIndex = j;
				for (int k = j + 1; k < students.length; k++) 
					if (students[k].compareByName(students[maxIndex]) == 1)
						maxIndex = k;
				swap(j, maxIndex);
			}
	}
	
	//descending sort
	public void sortByAvgWithoutLowestGrade(boolean asc) {
		if (asc == true) {
			for (int j = 0; j < students.length - 1; j++) {
				int minIndex = j;
				for (int k = j + 1; k < students.length; k++) 
					if (students[k].getAvgWithoutLowestGrade() < students[minIndex].getAvgWithoutLowestGrade())
						minIndex = k;
				swap(j, minIndex);
		}}
		else
			for (int j = 0; j < students.length - 1; j++) {
				int maxIndex = j;
				for (int k = j + 1; k < students.length; k++) 
					if (students[k].getAvgWithoutLowestGrade() < students[maxIndex].getAvgWithoutLowestGrade())
						maxIndex = k;
				swap(j, maxIndex);
			}
	}
	
	public void swap(int j, int k) {
		Student temp = students[j];
		students[j] = students[k];
		students[k] = temp;
	}
	
	public String toString() {
		String output = "";
		for (Student s : students)
			output += s.toString() + "\n";
		output += "\n";
		return output;
	}
}