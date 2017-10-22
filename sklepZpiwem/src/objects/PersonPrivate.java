package objects;

import java.util.ArrayList;
import java.util.List;

public class PersonPrivate implements Person {

	private String name;
	private String lastName;
	private Integer age;
	private List<Goods> goods = new ArrayList<>();

	public PersonPrivate(String name, String lastName, Integer age) {
		super();
		this.name = name;
		this.lastName = lastName;
		this.age = age;
	}

	public void buyedGoods(List<Goods> shopGoods) {
		shopGoods.forEach(obj -> {
			if (goods.contains(obj)) {
				Goods towar = goods.get(goods.indexOf(obj));
				towar.setCount(towar.getCount() + obj.getCount());
			} else {
				goods.add(obj);
			}
			System.out.printf("Do sklepu dodano %d %s\n", obj.getCount(), obj.name());
		});
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

	@Override
	public String nazwa() {
		return this.getName() + " " + this.getLastName();
	}

	public List<Goods> getGoods() {
		return goods;
	}

	public void setGoods(List<Goods> goods) {
		this.goods = goods;
	}

	@Override
	public String toString() {
		return String.format("PersonPrivate [name=%s, lastName=%s, age=%s, goods=%s]", name, lastName, age, goods);
	}

}
