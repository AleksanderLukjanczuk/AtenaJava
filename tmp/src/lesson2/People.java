package lesson2;

public class People {

	private String s;

	public People() {
		System.out.println("People constructor!");
	}

	public People(String s) {
		this.setS(s);
		System.out.println("s=" + s);
	}

	public String getS() {
		return s;
	}

	public void setS(String s) {
		this.s = s;
	}

}
