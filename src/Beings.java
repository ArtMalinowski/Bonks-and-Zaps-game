import java.util.Random;

/**
 * @author Artur
 *
 */
public abstract class Beings implements Ibeings {

	protected String name;
	protected Position position;

	/**
	 * Constructor with name and position
	 * 
	 * @param name
	 * @param position
	 */
	public Beings(String name, Position position) {
		super();
		this.name = name;
		this.position = position;
	}

	/*
	 * @see Ibeings#getPosition()
	 */
	public Position getPosition() {
		return position;
	}

	/*
	 * @see Ibeings#setPosition(Position)
	 */
	public void setPosition(Position position) {
		this.position = position;
	}

	/*
	 * @see Ibeings#getName()
	 */
	public String getName() {
		return name;
	}

	/**
	 * function which create random new position of Bonk/Zap
	 * 
	 * @param changePositionBeing
	 * @return integer with random number after all if statement
	 */
	public int chooseposition(Beings changePositionBeing) {
		Random generator = new Random();
		int move;
		/*
		 * get Postion of Being and check all 8 if statement in which our being
		 * have some move blocked
		 */
		if (changePositionBeing.getPosition().getY() == 1 && changePositionBeing.getPosition().getX() != 1
				&& changePositionBeing.getPosition().getX() != 20) {
			move = generator.nextInt(4);
			if (move == 3) {
				move = 7;
			} else if (move == 4) {
				move = 8;
			}
		} else if (changePositionBeing.getPosition().getY() == 20 && changePositionBeing.getPosition().getX() != 1
				&& changePositionBeing.getPosition().getX() != 20) {
			move = generator.nextInt(4) + 3;
		} else if (changePositionBeing.getPosition().getX() == 1 && changePositionBeing.getPosition().getY() != 1
				&& changePositionBeing.getPosition().getY() != 20) {
			move = generator.nextInt(4) + 1;
		} else if (changePositionBeing.getPosition().getX() == 20 && changePositionBeing.getPosition().getY() != 1
				&& changePositionBeing.getPosition().getY() != 20) {
			move = generator.nextInt(4) + 4;
			if (move == 4) {
				move = 1;
			}
		} else if (changePositionBeing.getPosition().getX() == 20 && changePositionBeing.getPosition().getY() == 20) {
			move = generator.nextInt(2) + 5;
		} else if (changePositionBeing.getPosition().getX() == 1 && changePositionBeing.getPosition().getY() == 20) {
			move = generator.nextInt(2) + 3;
		} else if (changePositionBeing.getPosition().getX() == 20 && changePositionBeing.getPosition().getY() == 1) {
			move = generator.nextInt(2) + 6;
			if (move == 6) {
				move = 1;
			}
		} else if (changePositionBeing.getPosition().getX() == 1 && changePositionBeing.getPosition().getY() == 1) {
			move = generator.nextInt(2) + 1;
		} else {
			move = generator.nextInt(8);

		}
		/*
		 * move which I will used in my actMove
		 */
		return move;
	}

	/**
	 * This function move Zap and Beings in random way
	 * by switch function and collecting random number from 
	 * chooseposition
	 * @param changePositionBeing
	 * @param ifBonk
	 */
	public void actMove(Beings changePositionBeing, boolean ifBonk) {

		int y = changePositionBeing.getPosition().getY();
		int x = changePositionBeing.getPosition().getX();
		/*
		 * we used here our move from previous function there is 8 case in which
		 * one our being move to other postion
		 */
		switch (chooseposition(changePositionBeing)) {
		case 0:
			break;
		case 1:
			if (ifBonk) {

				changePositionBeing.getPosition().setX(x + 0);
				changePositionBeing.getPosition().setY(y + 1);
			} else {

				changePositionBeing.getPosition().setX(x + 0);
				changePositionBeing.getPosition().setY(y + 1);
			}
			break;
		case 2:
			if (ifBonk) {

				changePositionBeing.getPosition().setX(x + 1);
				changePositionBeing.getPosition().setY(y + 1);
			} else {
				changePositionBeing.getPosition().setX(x + 1);
				changePositionBeing.getPosition().setY(y + 1);
			}
			break;
		case 3:
			if (ifBonk) {
				changePositionBeing.getPosition().setX(x + 1);
				changePositionBeing.getPosition().setY(y + 0);
			} else {
				changePositionBeing.getPosition().setX(x + 1);
				changePositionBeing.getPosition().setY(y + 0);
			}
			break;
		case 4:
			if (ifBonk) {
				changePositionBeing.getPosition().setX(x + 1);
				changePositionBeing.getPosition().setY(y - 1);
			} else {
				changePositionBeing.getPosition().setX(x + 1);
				changePositionBeing.getPosition().setY(y - 1);
			}
			break;
		case 5:
			if (ifBonk) {
				changePositionBeing.getPosition().setX(x + 0);
				changePositionBeing.getPosition().setY(y - 1);
			} else {
				changePositionBeing.getPosition().setX(x + 0);
				changePositionBeing.getPosition().setY(y - 1);
			}
			break;
		case 6:
			if (ifBonk) {
				changePositionBeing.getPosition().setX(x - 1);
				changePositionBeing.getPosition().setY(y - 1);
			} else {
				changePositionBeing.getPosition().setX(x - 1);
				changePositionBeing.getPosition().setY(y - 1);
			}
			break;
		case 7:
			if (ifBonk) {
				changePositionBeing.getPosition().setX(x - 1);
				changePositionBeing.getPosition().setY(y + 0);
			} else {
				changePositionBeing.getPosition().setX(x - 1);
				changePositionBeing.getPosition().setY(y + 0);
			}
			break;
		case 8:
			if (ifBonk) {
				changePositionBeing.getPosition().setX(x - 1);
				changePositionBeing.getPosition().setY(y + 1);
			} else {
				changePositionBeing.getPosition().setX(x - 1);
				changePositionBeing.getPosition().setY(y + 1);
			}
			break;
		default:
			break;
		}
	}

}
