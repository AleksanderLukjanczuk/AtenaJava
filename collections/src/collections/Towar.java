package collections;

public class Towar implements Comparable<Towar> {
	private String name;
	private Integer price;

	public Towar(String name, Integer price) {
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return String.format("Towar [name=%s, price=%s]", name, price);
	}

	@Override
	public int compareTo(Towar towar) {
		int result = 0;
		result = getName().compareTo(towar.getName());
		if (result != 0) {
//			System.out.println(getName() + " : res=" + result);
			return result;
		}
		result = getPrice().compareTo(towar.getPrice());
//		System.out.println(getPrice() + " : res=" + result);
		return result;
	}
}
