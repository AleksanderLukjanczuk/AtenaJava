package objects;

import java.math.BigDecimal;

public class Zabka extends Shop {

	public Zabka() {
		super("Żabka");
	}

	@Override
	BigDecimal promocja(Goods good) {
		if (getPromcja().contains(good)) {
			BigDecimal prom = getPromcja().get(getPromcja().indexOf(good)).getPrice();
			return (prom.multiply(good.getPrice()));
		}
		return good.getPrice();
	}

}
