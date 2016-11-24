import java.util.ArrayList;

/**
 * @author Artur
 *
 */
public class Room {
	Position possiton;
	private ArrayList<Bonk> bonksInroom = new ArrayList<>();
	private ArrayList<Zap> zapsInroom = new ArrayList<>();
	
	
	/**
	 * constructor of room with only position
	 * @param possiton
	 */
	public Room(Position possiton) {
		super();
		this.possiton = possiton;
	}

	/**
	 * @return possition
	 */
	public Position getPossiton() {
		return possiton;
	}

	/**
	 * @param newBonk
	 */
	public void addBonkstoArray(Beings newBonk) {
		bonksInroom.add((Bonk) newBonk);

	}

	/**
	 * @param newZap
	 */
	public void addZapstoArray(Beings newZap) {
		zapsInroom.add((Zap) newZap);

	}

	/**
	 * @param oldBonk
	 */
	public void removeBonkoldRoom(Beings oldBonk) {
		for (Beings beings : bonksInroom) {
			if (oldBonk.equals(beings)) {
				bonksInroom.remove(beings);
				break;
			}
		}
	}

	/**
	 * @param oldZap
	 */
	public void removeZapoldRoom(Beings oldZap) {
		for (Beings beings : zapsInroom) {
			if (oldZap.equals(beings)) {
				zapsInroom.remove(beings);
				break;
			}
		}
	}

	/**
	 * @return
	 */
	public ArrayList<Bonk> getBonksInroom() {
		return bonksInroom;
	}

	/**
	 * @return
	 */
	public ArrayList<Zap> getZapsInroom() {
		return zapsInroom;
	}

	/**
	 * after first turn it change all living child bonks to adult bonks
	 */
	public void timeTobeAdult() {
		for (Bonk bonk : bonksInroom) {
			if (bonk.adult == Boolean.FALSE) {
				bonk.adult = Boolean.TRUE;
			}

		}
	}

	/**
	 * change value of all bonks in room to false
	 */
	public void killRoomBonk() {
		for (Bonk bonk : bonksInroom) {
			bonk.isAlive = Boolean.FALSE;
		}
	}

	/**
	 * Simple function which calculate how many pairs we have
	 * 
	 * @return
	 */
	public int pairsNumber() {
		int woman = 0;
		int man = 0;
		int number = 0;
		for (Bonk bonk : bonksInroom) {

			if ((bonk.sex == (sex.male)) && (bonk.isAlive == (Boolean.TRUE) && (bonk.adult == (Boolean.TRUE)))) {
				man++;
			} else if ((bonk.sex == (sex.female)) && (bonk.isAlive == (Boolean.TRUE))
					&& (bonk.adult == (Boolean.TRUE))) {
				woman++;
			}
			if (man > woman)
				number = woman;

			else
				number = man;

		}
		return number;
	}

	/*
	 * Return us how we should print our room
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "Room [possition " + possiton + ", currentbonks=" + bonksInroom + ", currentzaps=" + zapsInroom + "]";
	}

}
