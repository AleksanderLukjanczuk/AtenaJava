package objects;

import java.math.BigDecimal;

public interface Goods {

	public String name();

	public Integer getCount();

	public void setCount(Integer count);

	@Deprecated
	public Boolean checkAge();

	public BigDecimal getPrice();

	public void setPrice(BigDecimal price);
}
