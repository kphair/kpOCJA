// Set up a Person class
public class Person {

	int age;
	String name;
	char gender;
	
	// age getters and setters
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	// name getters and setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	// gender getters and setters
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public String getGenderFull() {
		switch (gender) {
			case 'm': if (age<16) return "boy"; else return "man";
			case 'f': if (age<16) return "girl"; else return "woman";
		}
		return "person";
	}
}
