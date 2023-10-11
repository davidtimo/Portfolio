import java.util.Vector;

public class Main {

	public Main() {
		Student student1 = new Student("25Budi", "Budi", 3.5, 20020);// 
		Student student2 = new Student("25Andi", "Andi", 3.9, 20021);
		
		Teacher teacher1 = new Teacher("D1313", "Pak Adi", 6000000);
		Teacher teacher2 = new Teacher("D1515", "Pak Badi", 33333555);
		System.out.println(student1.getId());
		// UPCASTING : Cast dari CHILD jadi PARENT
		
		Person person1 = new Student("151515", "Nama studen", 35, 3636);// child ditampung di parent nya, ini upcasting
		// atau boleh Person person1 = student1;
		Person peNrson2 = new Teacher("D1515", "Pak Hulu", 5000000);
		Vector<Person> persons = new Vector<>();
		persons.add(person1);
		persons.add(person2);
			
		persons.set(0, new Student("151515", "updated name", 3.5, 2020));//ngeganti
		for(Person person : persons) {
			if(person1 instanceof Student) {
				//downcasting, sooalnya si parent gabisa akses yang punya anaknya
				Student student = (Student)person1;//typecasting
				student.setName("Student name:" + student.getName());
			} else if (person1 instanceof Teacher) {
				Teacher teacher = (Teacher)person1;//typecasting
				teacher.setName("Teacher name:" + teacher.getName());
			}
		}
		
//		Vector <Student> std;
//		Vector <Teacher> tch;
//		//lebih bagus
//		Vector <Person> persons; // dynamic array 
		
	
	}
	
	public static void main(String[] args) {
		new Main();
	}

}
/*
Inheritance (turunan)
superclass / parentclass -> untuk 
Contoh person punya ID, Name, Age
		Student punya id, name, graduation year
		Teacher punya id, name, salary
		jadi nanti pnya class id dan name yang sama
		keyword extends*/


//Final 
// final variable -> ketika sudah di define gabisa diubah lagi
// static variable -> global