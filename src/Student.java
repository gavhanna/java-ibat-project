public class Student {
	private static int studentNumberStart = 2160000;
	private int studentNumber;
	private String studentName;
	private float overallMark = 0f;
	private String overallGrade;
	
	public int getNewStudentNumber() {
		studentNumberStart++;
		this.setStudentNumber(studentNumberStart);
		return getStudentNumber();
	}
	
	public float getOverallMark() {
		return overallMark;
	}
	public void setOverallMark(float overallMark) {
		this.overallMark = overallMark;
	}
	public String getOverallGrade() {
		return overallGrade;
	}
	public void setOverallGrade(String overallGrade) {
		this.overallGrade = overallGrade;
	}
	public int getStudentNumber() {
		return studentNumber;
	}
	public void setStudentNumber(int studentNumber) {
		this.studentNumber = studentNumber;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	
}
