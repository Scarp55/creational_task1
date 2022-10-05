package creational_task1;

import java.util.Objects;

public class Person {
	protected final String NAME;
	protected final String SURNAME;
	protected int age;
	protected String address;

	public Person(String name, String surname) {
		NAME = name;
		SURNAME = surname;
	}

	public Person(String name, String surname, int age) {
		NAME = name;
		SURNAME = surname;
		this.age = age;
	}

	public Person(String name, String surname, int age, String address) {
		NAME = name;
		SURNAME = surname;
		this.age = age;
		this.address = address;
	}

	public String getNAME() {
		return NAME;
	}

	public String getSURNAME() {
		return SURNAME;
	}

	public int getAge() {
		return age;
	}

	public String getAddress() {
		return address;
	}

	public boolean hasAge() {
		return this.age >= 0;
	}

	public void happyBirthday() {
		if (this.hasAge()) {
			age++;
		}
	}

	public boolean hasAddress() {
		return this.address != null;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public PersonBuilder newChildBuilder() {
		PersonBuilder personBuilder = new PersonBuilder();
		personBuilder.setSurname(this.SURNAME);
		personBuilder.setAddress(this.address);
		return personBuilder;
	}

	@Override
	public String toString() {
		return NAME + " " + SURNAME + " (" + (hasAge() ? "возраст " + age : "") + (hasAddress() ? " проживает: " + address : "") + ")";
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Person person))
			return false;
		return getAge() == person.getAge() && Objects.equals(getNAME(), person.getNAME())
				&& Objects.equals(getSURNAME(), person.getSURNAME())
				&& Objects.equals(getAddress(), person.getAddress());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getNAME(), getSURNAME(), getAge(), getAddress());
	}
}
