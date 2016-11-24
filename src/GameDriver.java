
import java.util.Scanner;

import javax.swing.JFrame;

public class GameDriver {
	int cycle, Mode;
	public static String ZapsGrids;
	public static String Calculation;
	private Scanner in;
	GameDriver app;

	/**
	 * run all function to create my simulation 
	 * with all options etc 
	 * @throws InterruptedException
	 */
	public void run() throws InterruptedException {
		Gridworld app = new Gridworld();
		int x = 0;
		int represent = 0;
		in = new Scanner(System.in);
		System.out.println("****Welcome in my program, please enter number of Rounds****");
		cycle = checkNumber(cycle);

		System.out.println(" press 2 - for survive mode for bonks (in this mode zaps are upgrade)" + "\n !!!! CHECK IF BONKS WILL SURVIVE  !!!!"
				+ "\n or just press 1 for normal mode");
		do {
			Mode = checkNumber(Mode);
		} while (Mode != 1 && Mode != 2);

		app.world();
		app.createZap();
		app.createbonks();
		if (Mode == 2) {
			do {
			app.PrintallWorlds();
				app.timeTobeAdult();
				app.actReproduction();
				app.movingBeings();
				app.actkillEvryBonk();
				app.upgradeZaps();
				x++;
			} while (x < cycle);
		} else if (Mode == 1) {
			do {
				app.PrintallWorlds();
				app.timeTobeAdult();
				app.actReproduction();
				app.movingBeings();
				app.actkillEvryBonk();
				x++;
			} while (x < cycle);
		}
		System.out.println("\n 1 - results of symulation in GUI \n 2 - results of symulation in comand line ");
		do {
			represent = checkNumber(represent);
		} while (represent != 1 && represent != 2);
		if (represent == 1) {
			ZapsGrids = app.GUIbonkszaps();
			Calculation = app.GUIcalculation();
			GUIworld representation = new GUIworld();
			representation.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			representation.setVisible(true);
		} else if (represent == 2) {
			app.Printevrything();
		}

		System.out.println("\n****THE SIMULATION END AT ROUND " + x + " ****");
	}

	public int checkNumber(int number) {
		for (;;) {
			if (!in.hasNextInt()) {
				System.out.println(" enter only positive number!: ");
				in.next(); // discard
				continue;
			}
			number = in.nextInt();
			break;
		}
		return number;
	}

	public static void main(String[] args) throws InterruptedException {
		GameDriver app = new GameDriver();
		app.run();

	}

}
