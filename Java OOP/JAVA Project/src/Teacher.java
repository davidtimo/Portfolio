
public class Teacher extends Person {
	private int salary;

	public Teacher(String id, String name, int salary) {
		super(id, name);
		this.salary = salary;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
}
