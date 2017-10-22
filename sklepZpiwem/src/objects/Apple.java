package objects;

public class Apple implements Goods {
	private final String NAME = "Apple";
	private Integer count = 0;
	private Integer price;

	public Apple(Integer count, Integer price) {
		super();
		this.count = count;
		this.price = price;
	}

	@Override
	public String name() {
		return NAME;
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
		return String.format("Apple [NAME=%s, count=%s, price=%s]", NAME, count, price);
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
		Apple other = (Apple) obj;
		if (NAME == null) {
			if (other.NAME != null)
				return false;
		} else if (!NAME.equals(other.NAME))
			return false;
		return true;
	}

	@Override
	public Integer getCount() {
		return this.count;
	}

	@Override
	public void setCount(Integer count) {
		this.count = count;
	}
}