import java.util.ArrayList;

/**
 * @author Artur
 *
 */
public class Printevrything {

	/**
	 * Function to print all rooms
	 */
	public void printWorld(Room[][] world) {
		System.out.println("\n\n\n B-living bonks \n D-Dead bonks" + "\n Z - Zaps\n");

		for (int y = 1; y < 21; y++) {
			System.out.println("\n**** Row " + y + " ****\n");
			for (int x = 1; x < 21; x++) {
				int dead = 0;
				System.out.print("{");
				int b = world[x][y].getBonksInroom().size();
				int z = world[x][y].getZapsInroom().size();
				if (b != 0) {

					for (Bonk bonk : world[x][y].getBonksInroom()) {
						if (bonk.isAlive.equals(Boolean.valueOf(false))) {
							dead++;
						}

					}
					if (dead != 0) {
						System.out.print("D" + dead + "||");
					}
					System.out.print("B" + (b - dead));
				} else if (z != 0) {
					System.out.print("||Z" + z);
				}

				System.out.print("}");

			}
		}
	}

	/**
	 * this function return string with our end calculation which we will use at the end of 
	 * our simulation 
	 * @param bonks
	 * @return
	 */
	public String Calculation(ArrayList<Bonk> bonks) {
		int childrenNumber = 0;
		int adultNumber = 0;
		for (Bonk bonk : bonks) {
			if (bonk.adult.equals(Boolean.valueOf(false))) {
				childrenNumber++;
			} else if (bonk.adult.equals(Boolean.valueOf(true))) {
				adultNumber++;
			}
		}
		String GUIc1 = "\n Number of all bonks= "+bonks.size() +"\n Number of children=  " + childrenNumber + "\n Number of adult= " + adultNumber;

		int deadBonks = 0;
		int leavingBonks = 0;

		for (Bonk bonk : bonks) {
			if (bonk.isAlive.equals(Boolean.valueOf(false))) {
				deadBonks++;
			} else if (bonk.isAlive.equals(Boolean.valueOf(true))) {
				leavingBonks++;
			}
		}
		String GUIc2 = "\n Number of dead bonks= " + deadBonks + "\n Number of leving Bonks =" + leavingBonks;
		return GUIc1 + GUIc2;
	}

	/**
	 * return string with our zaps and bonks 
	 * @param bonks
	 * @param zaps
	 * @return
	 */
	public String bonksZaps(ArrayList<Bonk> bonks, ArrayList<Zap> zaps) {
		int a = 0,b=0;
		String BZ = "Begining of Bonks \n",BZ6 = null;
	
		String BZ4 = "\n****\n" + zaps.toString() + "\n\n";
			for (Bonk bonk : bonks) {
				a++;
				if (a <= 100) {
					b++;
					if(b==25&&a!=100){
					BZ = BZ + bonk.toString()+"\nnext 25 bonks\n";
					b=0;
					}
					else 
						BZ = BZ + bonk.toString();
				} else {
					BZ6 = "\nThere is only limit to first 100 bonks ";
				}

			}
		if(BZ6==null)
			BZ6="\nend of bonks";
		return BZ + BZ6 + BZ4;
	}
}
