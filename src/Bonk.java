
/**
 * @author Artur
 *
 */
public class Bonk extends Beings implements Ibeings {
	sex sex;
	Boolean isAlive;
	Boolean adult;

	/**
	 * Simple constructor with parametrs :
	 * 
	 * @param name
	 * @param position
	 */
	public Bonk(String name, Position position) {
		super(name, position);
	}

	/**
	 * Constructor which I used to create bonks
	 * 
	 * @param name
	 * @param position
	 * @param sex
	 * @param isAlive
	 * @param adult
	 */
	public Bonk(String name, Position position, sex sex, Boolean isAlive, Boolean adult) {
		super(name, position);
		this.sex = sex;
		this.isAlive = isAlive;
		this.adult = adult;
	}

	/*
	 * reutrn us how we should print or Bonk
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "Bonk name " + name + " Position " + position + "sex=" + sex + "  ||  ";
	}
}
