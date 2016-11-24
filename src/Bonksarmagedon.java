import java.util.ArrayList;
import java.util.Random;

public class Bonksarmagedon {
	
	/**
	 * I used this function to create another 15 zaps to make 
	 * rise chance of zaps to kill some bonks 
	 * @param world
	 * @param zaps
	 */
	public void createZap(Room[][] world, ArrayList<Zap> zaps) {
		Random generator = new Random();
		int x;
		int y;
		for (int i = 6; i < 21; i++) {
			x = generator.nextInt(19) + 1;
			y = generator.nextInt(19) + 1;
			Position newPosition = new Position(x, y);
			String name = "Z" + i;
			Zap zap = new Zap(name, newPosition);
			zaps.add(zap);
			world[x][y].addZapstoArray(zap);

		}
	}

	/**
	 * this function gave zaps another movement in one turn 
	 * so the can move twice per turn
	 * @param world
	 * @param zaps
	 */
	public void extraMove(Room[][] world, ArrayList<Zap> zaps) {
		for (Zap zapMove : zaps) {
			world[zapMove.getPosition().getX()][zapMove.getPosition().getY()].removeZapoldRoom(zapMove);
			zapMove.actMove(zapMove, false);
			world[zapMove.getPosition().getX()][zapMove.getPosition().getY()].addZapstoArray(zapMove);
		}
	}

	/**
	 * this function gave zaps possible to kill some bonks after 
	 * their extra movement 
	 * @param world
	 * @param zaps
	 * @param bonks
	 */
	public void extrakillingact(Room[][] world, ArrayList<Zap> zaps, ArrayList<Bonk> bonks) {
		for (int x = 1; x < 21; x++) {
			for (int y = 1; y < 21; y++) {
				Position bonkPossition = new Position(x, y);
				if (world[x][y].getBonksInroom().size() != 0 && world[x][y].getZapsInroom().size() != 0) {
					world[x][y].killRoomBonk();
					for (Bonk bonk : bonks) {
						if (bonk.getPosition().equals(bonkPossition)) {
							bonk.isAlive = Boolean.FALSE;
						}
					}
				}
			}
		}
	}

	/**
	 * this function summon all previous function form BonksArmagedon class 
	 * and use it only in special conditons
	 * @param world
	 * @param zaps
	 * @param bonks
	 */
	public void upgradeBonks(Room[][] world, ArrayList<Zap> zaps, ArrayList<Bonk> bonks) {
		if (bonks.size() > 100) {
			if (zaps.size() < 20) {
				createZap(world, zaps);
			}
			extraMove(world, zaps);
			extrakillingact(world, zaps, bonks);
		}
	}
}
