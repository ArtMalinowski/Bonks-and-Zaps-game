
/**
 * @author Artur
 *
 */
public class Zap extends Beings {

	/**
	 * Simple contructor to our Zap
	 * 
	 * @param name
	 * @param position
	 */
	public Zap(String name, Position position) {
		super(name, position);

	}
	/*
	 * our string which say us what is the name of zap and what is the postion
	 * of him
	 * 
	 * @see java.lang.Object#toString()
	 */

	public String toString() {
		return "Zap [name=" + name + ", position=" + position + "]";
	}

	/**
	 * this function I used to check if my Being is bonk or Zap
	 * 
	 * @return
	 */
	public boolean ifBonk() {
		return false;
	}

}
