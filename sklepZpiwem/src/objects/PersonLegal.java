package objects;

public class PersonLegal implements Person {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String nazwa() {
		return name;
	}

}
