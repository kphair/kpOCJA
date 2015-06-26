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
			case 'm': return "male";
			case 'f': return "female";
		}
		return "null";
	}
}
