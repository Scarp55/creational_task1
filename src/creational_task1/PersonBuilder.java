package creational_task1;

public class PersonBuilder {
	private String name;
	private String surname;
	private int age = -1;
	private String address;

	public PersonBuilder setName(String name) {
		if (name == null || name.isEmpty()) {
			throw new IllegalStateException("Поле имя не может быть пустым!");
		} else {
			this.name = name;
		}
		return this;
	}

	public PersonBuilder setSurname(String surname) {
		if (surname == null || surname.isEmpty()) {
			throw new IllegalStateException("Поле фамилия не может быть пустым!");
		} else {
			this.surname = surname;
		}
		return this;
	}

	public PersonBuilder setAge(int age) {
		if (age < 0) {
			throw new IllegalStateException("Возраст не может быть отрицательным");
		} else {
			this.age = age;
		}
		return this;
	}

	public PersonBuilder setAddress(String address) {
		this.address = address;
		return this;
	}

	public Person build() throws IllegalStateException {
		Person person;
		if (name == null || surname == null) {
			throw new IllegalStateException("Поле имя или фамилия пустое");
		}

		if (age < 0 && address==null) {
			person = new Person(name, surname);
		} else if (age >= 0 && address==null) {
			person = new Person(name, surname, age);
		} else if (age >= 0 && address!=null){
			person = new Person(name, surname, age, address);
		} else {
			person = new Person(name, surname, age, address);
		}
		return person;
	}
}
