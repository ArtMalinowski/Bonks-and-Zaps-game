import java.util.ArrayList;
import java.util.Random;

/**
 * @author Artur
 *
 */
public class Gridworld {

	private Room[][] world = new Room[21][21];
	private ArrayList<Bonk> bonks = new ArrayList<>();
	private ArrayList<Zap> zaps = new ArrayList<>();
	private int numberOfbonk = 21;

	public Gridworld() {

	}

	/**
	 * Create World (2D array of rooms)
	 */
	public void world() {
		for (int x = 1; x < 21; x++) {
			for (int y = 1; y < 21; y++) {
				Position roomposition = new Position(x, y);
				Room newRoom = new Room(roomposition);
				world[x][y] = newRoom;
			}
		}
	}

	/**
	 * Create Bonks
	 */
	public void createbonks() {
		Random generator = new Random();
		for (int i = 1; i < 21; i++) {
			int x;
			int y;
			int s;
			boolean isAlive = true;
			sex gender = null;
			Boolean adult = true;
			String name = "B" + i;
			x = generator.nextInt(19) + 1;
			y = generator.nextInt(19) + 1;
			Position newPosition = new Position(x, y);
			s = generator.nextInt(19);
			if (s < 10) {
				gender = sex.female;
			} else if (s >=10) {
				gender = sex.male;
			}
			Bonk newBonk = new Bonk(name, newPosition, gender, isAlive, adult);
			bonks.add(newBonk);
			world[x][y].addBonkstoArray(newBonk);
		}

	}

	/**
	 * Create zap
	 */
	public void createZap() {
		Random generator = new Random();
		int x;
		int y;
		for (int i = 1; i < 6; i++) {
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
	 * function which move all Bonks and Zaps
	 */
	public void movingBeings() {
		for (Bonk bonkMove : bonks) {
			if ((bonkMove.isAlive == Boolean.valueOf(true)) && (bonkMove.adult == Boolean.TRUE)) {
				world[bonkMove.getPosition().getX()][bonkMove.getPosition().getY()].removeBonkoldRoom(bonkMove);
				bonkMove.actMove(bonkMove, true);
				world[bonkMove.getPosition().getX()][bonkMove.getPosition().getY()].addBonkstoArray(bonkMove);
			}
		}
		for (Zap zapMove : zaps) {
			world[zapMove.getPosition().getX()][zapMove.getPosition().getY()].removeZapoldRoom(zapMove);
			zapMove.actMove(zapMove, false);
			world[zapMove.getPosition().getX()][zapMove.getPosition().getY()].addZapstoArray(zapMove);
		}
	}

	/**
	 * Function which reprodct all adult bonks if there is female and male in
	 * one room
	 */
	public void actReproduction() {

		for (int x = 1; x < 21; x++) {
			for (int y = 1; y < 21; y++) {

				int number = world[x][y].pairsNumber();
				for (int i = 0; i < number; i++) {
					Random generator = new Random();
					int s;
					boolean isAlive = true;
					sex gender = null;
					Boolean adult = false;
					String name = "B" + numberOfbonk;
					Position newPosition = new Position(x, y);
					s = generator.nextInt(19);
					if (s < 10) {
						gender = sex.female;
					} else if (s >= 10) {
						gender = sex.male;
					}
					Bonk newBonk = new Bonk(name, newPosition, gender, isAlive, adult);
					bonks.add(newBonk);
					world[x][y].addBonkstoArray(newBonk);
					numberOfbonk++;
				}
			}
		}
	}

	/**
	 * at the begin of all rounds make all bonks adult
	 */
	public void timeTobeAdult() {
		for (Bonk bonk : bonks) {
			if (bonk.adult == Boolean.FALSE && bonk.isAlive == Boolean.TRUE) {
				bonk.adult = Boolean.TRUE;
			}

			for (int x = 1; x < 21; x++) {
				for (int y = 1; y < 21; y++) {
					world[x][y].timeTobeAdult();
				}
			}
		}
	}

	/**
	 * if there is a Zap and adult bonks in room make the statement isAlive of
	 * all adult bonks to false (expect all child bonks , they are immortal in
	 * first round)
	 */
	public void actkillEvryBonk() {
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
	 * extra function to upgrade Zaps it gave another 10 zaps also gave them
	 * extra move
	 */
	public void upgradeZaps() {
		Bonksarmagedon Upgrade = new Bonksarmagedon();

		Upgrade.upgradeBonks(world, zaps, bonks);
	}

	/**
	 * Print all wrolds which were create every turn 
	 * @throws InterruptedException
	 */
	public void PrintallWorlds() throws InterruptedException {
		Printevrything print = new Printevrything();
		print.printWorld(world);
		Thread.sleep(1000);
	}

	/**
	 * Print results of whole simulation 
	 */
	public void Printevrything() {
		Printevrything print = new Printevrything();
		System.out.println("****Last world****");
		System.out.println("y-row \nx-column");
		print.printWorld(world);
		System.out.println("\n\n"+print.bonksZaps(bonks, zaps));
		System.out.println(print.Calculation(bonks));
	}

	/**
	 * Return string which is needed to our GUI with bonks and zaps
	 * @return
	 * @throws InterruptedException
	 */
	public String GUIbonkszaps() throws InterruptedException {
		
		Printevrything print = new Printevrything();
		System.out.println("****Last world****");
		System.out.println("y-row \nx-column");
		print.printWorld(world);
		String placki = print.bonksZaps(bonks, zaps);
		return placki;
	}

	/**
	 * Return string with is needed to our GUI representation 
	 * with last calculations 
	 * @return
	 * @throws InterruptedException
	 */
	public String GUIcalculation() throws InterruptedException {
		Printevrything print = new Printevrything();
		String placki = print.Calculation(bonks);
		return placki;
	}
}
