package assignment7;

//TODO: Copy a working Student class from Assignment 7 over this file.
public class Student {

	private String firstName;
	private String lastName;
	private int studentId;
	private int attemptedCredits;
	private int passingCredits;
	private double totalGradeQualityPoints;
	private double bearBucks;
	
	public Student(String firstName, String lastName, int studentId) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.studentId = studentId;
		this.attemptedCredits = 0;
		this.passingCredits = 0;
		this.totalGradeQualityPoints = 0;
		this.bearBucks = 0;
	}
	
	/**
	 * getFullName returns student's full name
	 * 
	 * @return Student's full name
	 */
	public String getFullName() {
		return firstName + " " + lastName;
	}
	
	/**
	 * getId returns student's ID
	 * 
	 * @return Student's ID
	 */
	public int getId() {
		return studentId;
	}
	
	/**
	 * submitGrade adds a grade to student's total grade and updates credits
	 * 
	 * @param grade the 0.0 to 4.0 grade value
	 * @param credits the number of credits the class is
	 */
	public void submitGrade(double grade, int credits) {

		this.attemptedCredits += credits;
		
		if (grade >= 1.7) {
			this.passingCredits +=  credits;
		}
		
		totalGradeQualityPoints += (grade * credits);
	}
	
	/**
	 * getTotalAttemptedCredits returns total attempted credits
	 * 
	 * @return the number of attempted credits
	 */
	public int getTotalAttemptedCredits() {
		return attemptedCredits;
	}
	
	/**
	 * getTotalPassingCredits returns total passing credits
	 * 
	 * @return the number of passing credits
	 */
	public int getTotalPassingCredits() {
		return passingCredits;
	}
	
	/**
	 * calculateGradePointAverage calculates and returns student's GPA
	 * 
	 * @return student's GPA
	 */
	public double calculateGradePointAverage() {
		return totalGradeQualityPoints / attemptedCredits;
	}
	
	/**
	 * getClassStanding returns student's class standing
	 * 
	 * @return the student's class standing
	 */
	public String getClassStanding() {
		if (passingCredits < 30) {
			return "First Year";
		}
		else if (passingCredits >= 30 && passingCredits < 60) {
			return "Sophomore";
		}
		else if (passingCredits >= 60 && passingCredits < 90) {
			return "Junior";
		}
		else {
			return "Senior";
		}
	}
	
	/**
	 * isEligibleForPhiBetaKappa returns whether or not the student is eligible for Phi Beta Cappa
	 * 
	 * @return whether or not the student is eligible for Phi Beta Cappa
	 */
	public boolean isEligibleForPhiBetaKappa() {
		if (attemptedCredits >= 98 && this.calculateGradePointAverage() >= 3.60) {
			return true;
		}
		else if (attemptedCredits >= 75 && this.calculateGradePointAverage() >= 3.80) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * depositBearBucks adds bear bucks to student's account
	 * 
	 * @param amount the amount of bear bucks added to student's account
	 */
	public void depositBearBucks(double amount) {
		bearBucks = bearBucks + amount;
	}
	
	/**
	 * deductBearBucks removes bear bucks from student's account
	 * 
	 * @param amount the amount of bear bucks removed from student's account
	 */
	public void deductBearBucks(double amount) {
		bearBucks = bearBucks - amount;
	}
	
	/**
	 * geBearBucksBalance returns amount of bear bucks
	 * 
	 * @return the amount of bear bucks in student's account
	 */
	public double getBearBucksBalance() {
		return bearBucks;
	}
	
	/**
	 * cashOutBearBucks zeros out number of bear bucks
	 * 
	 * @return the dollar amount refunded to the student
	 */
	public double cashOutBearBucks() {
		
		double bucks = bearBucks;
		bearBucks = 0;
		
		if (bucks > 10) {
			return (bucks - 10);
		}
		
		else {
			return 0;
		}
	}
	
	/**
	 * createLegacy creates a new student that is the child of two washu students
	 * 
	 * @param firstName the legacy student's first name
	 * @param other the other parent of the legacy student
	 * @param isHyphenated indicates whether the legacy student has a hyphenated last name
	 * @param id the legacy student's id
	 * @return new student object
	 */
	public Student createLegacy(String firstName, Student other, boolean isHyphenated, int id) {
		String last;
		if (isHyphenated == true) {
			last = this.lastName + "-" + other.lastName;
		}
		else {
			last = this.lastName; 
		}
		
		Student legacy = new Student(firstName, last, id);
		legacy.depositBearBucks(this.cashOutBearBucks() + other.cashOutBearBucks());
		
		return legacy;
	}
	
	/**
	 * toString returns the full name and student id of student
	 * 
	 * @return full name and student id of student
	 */
	public String toString() {
		return firstName + " " + lastName + " " + studentId;
	}
	
}
