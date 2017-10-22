package objects;

public class Milk implements Goods {
	private final String NAME = "Milk";
	private Integer count = 0;
	private Integer price;

	public Milk(Integer count, Integer price) {
		super();
		this.count = count;
		this.price = price;
	}

	@Override
	public String name() {
		return NAME;
	}

	@Override
	public Integer getCount() {
		return this.count;
	}

	@Override
	public void setCount(Integer count) {
		this.count = count;
	}

	@Override
	public Boolean checkAge() {
		return false;
	}

	@Override
	public Integer getPrice() {
		return price;
	}

	@Override
	public void setPrice(Integer price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return String.format("Milk [NAME=%s, count=%s, price=%s]", NAME, count, price);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((NAME == null) ? 0 : NAME.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Milk other = (Milk) obj;
		if (NAME == null) {
			if (other.NAME != null)
				return false;
		} else if (!NAME.equals(other.NAME))
			return false;
		return true;
	}
}