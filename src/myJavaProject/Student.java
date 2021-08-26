package myJavaProject;

public class Student {
	private String s_num ;
	private String s_name;
	private int s_java ;
	private int s_android;
	private int s_kottle ;
    private int s_total;
    private double s_avg;
    private String s_grade;
	public Student(String s_num, String s_name, int s_java, int s_android, int s_kottle, int s_total, double s_avg,
			String s_grade) {
		super();
		this.s_num = s_num;
		this.s_name = s_name;
		this.s_java = s_java;
		this.s_android = s_android;
		this.s_kottle = s_kottle;
		this.s_total = s_total;
		this.s_avg = s_avg;
		this.s_grade = s_grade;
	}
	public Student(String s_num, String s_name, int s_java, int s_android, int s_kottle) {
		super();
		this.s_num = s_num;
		this.s_name = s_name;
		this.s_java = s_java;
		this.s_android = s_android;
		this.s_kottle = s_kottle;
	}
	public String getS_num() {
		return s_num;
	}
	public void setS_num(String s_num) {
		this.s_num = s_num;
	}
	public String getS_name() {
		return s_name;
	}
	public void setS_name(String s_name) {
		this.s_name = s_name;
	}
	public int getS_java() {
		return s_java;
	}
	public void setS_java(int s_java) {
		this.s_java = s_java;
	}
	public int getS_android() {
		return s_android;
	}
	public void setS_android(int s_c) {
		this.s_android = s_android;
	}
	public int getS_kottle() {
		return s_kottle;
	}
	public void setS_kottle(int s_sql) {
		this.s_kottle = s_kottle;
	}
	public int getS_total() {
		return s_total;
	}
	public void setS_total(int s_total) {
		this.s_total = s_total;
	}
	public double getS_avg() {
		return s_avg;
	}
	public void setS_avg(double s_avg) {
		this.s_avg = s_avg;
	}
	public String getS_grade() {
		return s_grade;
	}
	public void setS_grade(String s_grade) {
		this.s_grade = s_grade;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((s_num == null) ? 0 : s_num.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (s_num == null) {
			if (other.s_num != null)
				return false;
		} else if (!s_num.equals(other.s_num))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return  s_num + "\t" + s_name + "\t" + s_java + "\t" + s_android + "\t"
				+ s_kottle + "\t" + s_total + "\t" + s_avg + "\t"+ s_grade;
	}
    
    
}
