
public class Student extends Person {// berati parent class nya si student adalah person
	private double GPA;// pengen class lain gabisa akses ini
	private int gradYear;

	public Student(String id, String name, double gPA, int gradYear) {
		super(id, name);
		GPA = gPA;
		this.gradYear = gradYear;
	}

	public double getGPA() {
		return GPA;
	}

	public void setGPA(double gPA) {
		GPA = gPA;
	}

	public int getGradYear() {
		return gradYear;
	}

	public void setGradYear(int gradYear) {
		this.gradYear = gradYear;
	}
	
	public void show() {
		System.out.println("Name :"+getName());
		System.out.println("ID   :"+getId());
		System.out.println("GPA: "+ getGPA());
		System.out.println("Graduation Year: "+getGradYear());
	}
}
