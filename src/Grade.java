public class Grade extends Student {
	protected static final String subjectTitle1 = "Java";
	private float subjectMark1 = 0f;
	private String subjectGrade1;
	protected static final String subjectTitle2 = "C++";
	private float subjectMark2 = 0f;
	private String subjectGrade2;
	protected static final String subjectTitle3 = "PHP";
	private float subjectMark3 = 0f;
	private String subjectGrade3; 
	protected static final String subjectTitle4 = "C#";
	private float subjectMark4 = 0f;
	private String subjectGrade4; 
	protected static final String subjectTitle5 = "Python";
	private float subjectMark5 = 0f;
	private String subjectGrade5;
	
	
	public float getSubjectMark1() {
		return subjectMark1;
	}
	public void setSubjectMark1(float subjectMark1) {
		this.subjectMark1 = subjectMark1;
	}
	public String getSubjectGrade1() {
		return subjectGrade1;
	}
	public void setSubjectGrade1(String subjectGrade1) {
		this.subjectGrade1 = subjectGrade1;
	}
	public float getSubjectMark2() {
		return subjectMark2;
	}
	public void setSubjectMark2(float subjectMark2) {
		this.subjectMark2 = subjectMark2;
	}
	public String getSubjectGrade2() {
		return subjectGrade2;
	}
	public void setSubjectGrade2(String subjectGrade2) {
		this.subjectGrade2 = subjectGrade2;
	}
	public float getSubjectMark3() {
		return subjectMark3;
	}
	public void setSubjectMark3(float subjectMark3) {
		this.subjectMark3 = subjectMark3;
	}
	public String getSubjectGrade3() {
		return subjectGrade3;
	}
	public void setSubjectGrade3(String subjectGrade3) {
		this.subjectGrade3 = subjectGrade3;
	}
	public float getSubjectMark4() {
		return subjectMark4;
	}
	public void setSubjectMark4(float subjectMark4) {
		this.subjectMark4 = subjectMark4;
	}
	public String getSubjectGrade4() {
		return subjectGrade4;
	}
	public void setSubjectGrade4(String subjectGrade4) {
		this.subjectGrade4 = subjectGrade4;
	}
	public float getSubjectMark5() {
		return subjectMark5;
	}
	public void setSubjectMark5(float subjectMark5) {
		this.subjectMark5 = subjectMark5;
	}
	public String getSubjectGrade5() {
		return subjectGrade5;
	}
	public void setSubjectGrade5(String subjectGrade5) {
		this.subjectGrade5 = subjectGrade5;
	}
	
	void  calculateGrade() {
		
		float subjectMark1;
		float subjectMark2;
		float subjectMark3;
		float subjectMark4;
		float subjectMark5;
		
		subjectMark1 = this.getSubjectMark1();
		subjectMark2 = this.getSubjectMark2();
		subjectMark3 = this.getSubjectMark3();
		subjectMark4 = this.getSubjectMark4();
		subjectMark5 = this.getSubjectMark5();
		
		this.setSubjectGrade1(this.getGrade(subjectMark1));
		this.setSubjectGrade2(this.getGrade(subjectMark2));
		this.setSubjectGrade3(this.getGrade(subjectMark3));
		this.setSubjectGrade4(this.getGrade(subjectMark4));
		this.setSubjectGrade5(this.getGrade(subjectMark5));
		
		float overallMark;
		String overallGrade = "Fail";
		
		overallMark = (subjectMark1 + subjectMark2 + subjectMark3 + subjectMark4 + subjectMark5) / 5;
		
			if (overallMark >= 80) {
				overallGrade = "Distinction";
			} else if (overallMark >= 60) {
				overallGrade = "Credit";
			} else if (overallMark >= 40) {
				overallGrade = "Pass";
			} else {
				overallGrade = "Fail";
			}
			
			this.setOverallMark(overallMark);
			this.setOverallGrade(overallGrade);
	}
	
	private String getGrade(float subjectMark) {
		String subjectGrade;
		
		if (subjectMark >= 80) {
			subjectGrade = "A";
		} else if (subjectMark >= 60) {
			subjectGrade = "B";
		} else if (subjectMark >= 40) {
			subjectGrade = "C";
		} else {
			subjectGrade = "F";
		}
		
		return subjectGrade;
	}
	
}