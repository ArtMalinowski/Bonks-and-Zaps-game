
/**
 * @author Artur
 *
 */
public class Position {

	int x;
	int y;

	/**
	 * @param x
	 * @param y
	 */
	public Position(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "x" + x + "y" + y;
	}

	/**
	 * Function to get X
	 * 
	 * @return
	 */
	public int getX() {
		return x;
	}

	/**
	 * Function to set X
	 * 
	 * @param x
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * Function to get Y
	 * 
	 * @return
	 */
	public int getY() {
		return y;
	}

	/**
	 * Funtction to set Y
	 * 
	 * @param y
	 */
	public void setY(int y) {
		this.y = y;
	}
}
