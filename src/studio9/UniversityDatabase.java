package studio9;

import assignment7.Student;
import java.util.Map;
import java.util.HashMap;

public class UniversityDatabase {
	
	private final Map<String, Student> universityDatabase;
	
	public UniversityDatabase() {
		universityDatabase = new HashMap<>();
	}

	public void addStudent(String accountName, Student student) {
		universityDatabase.put(accountName, student);
	}

	public int getStudentCount() {
		return universityDatabase.size();
	}

	public String lookupFullName(String accountName) {
		if (universityDatabase.get(accountName) != null) {
			return universityDatabase.get(accountName).getFullName();
		}
		else {
			return null;
		}
	}

	public double getTotalBearBucks() {
		double totalBearBucks = 0;
		
		for (Student student : universityDatabase.values()) {
			totalBearBucks = totalBearBucks + student.getBearBucksBalance();
		}
		
		return totalBearBucks;
	}
}
