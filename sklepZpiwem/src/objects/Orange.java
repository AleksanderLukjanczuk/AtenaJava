package objects;

import java.math.BigDecimal;

public class Orange implements Goods {
	private final String NAME = "Orange";
	private Integer count = 0;
	private BigDecimal price;

	public Orange(Integer count, BigDecimal price) {
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
	public BigDecimal getPrice() {
		return price.setScale(2, BigDecimal.ROUND_HALF_UP);
	}

	@Override
	public void setPrice(BigDecimal price) {
		this.price = price.setScale(2, BigDecimal.ROUND_HALF_UP);
	}

	@Override
	public String toString() {
		return String.format("Orange [NAME=%s, count=%s, price=%s]", NAME, count, price);
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
		Orange other = (Orange) obj;
		if (NAME == null) {
			if (other.NAME != null)
				return false;
		} else if (!NAME.equals(other.NAME))
			return false;
		return true;
	}
}
