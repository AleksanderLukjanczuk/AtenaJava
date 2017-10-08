package objects;

public class Person {

	private String name;
	private String lastName;
	private Integer age;
	private Integer beerBought = 0;

	public Person(String name, String lastName, Integer age) {
		super();
		this.name = name;
		this.lastName = lastName;
		this.age = age;
	}

	public void addBeer(Integer count) {
		beerBought += count;
	}

	@Override
	public String toString() {
		return String.format("Person [name=%s, lastName=%s, age=%s, beerBy=%s]", name, lastName, age, beerBought);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getBeerBought() {
		return beerBought;
	}

	public void setBeerBought(Integer beerBy) {
		this.beerBought = beerBy;
	}

}
