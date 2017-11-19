package objects;

import java.math.BigDecimal;

@CheckAge
public class Piwo implements Goods {
	private final String NAME = "Piwo";
	private Integer count = 0;
	private BigDecimal price;

	public Piwo(Integer count, BigDecimal price) {
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
		return true;
	}

	@Override
	public BigDecimal getPrice() {
		return price;
	}

	@Override
	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return String.format("Piwo [NAME=%s, count=%s, price=%s]", NAME, count, price);
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
		Piwo other = (Piwo) obj;
		if (NAME == null) {
			if (other.NAME != null)
				return false;
		} else if (!NAME.equals(other.NAME))
			return false;
		return true;
	}

}
