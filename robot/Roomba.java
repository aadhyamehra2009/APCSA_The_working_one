package robot;

import kareltherobot.*;

public class Roomba implements Directions {

	// Main method to make this self-contained
	public static void main(String[] args) {
		// LEAVE THIS ALONE!!!!!!
		String worldName = "robot/TestWorld-1.wld";

		Roomba cleaner = new Roomba();
		int totalBeepers = cleaner.cleanRoom(worldName, 7, 6);
		System.out.println("Roomba cleaned up a total of " + totalBeepers + " beepers.");

	}

	// declared here so it is visible in all the methods!
	private Robot roomba = new Robot(25, 11, North, 100);

	// You will need to add many variables!!

	public int cleanRoom(String worldName, int startX, int startY) {

		// A new Robot should be constructed and assigned to the global (instance)
		// variable named roomba that is declared above.
		// Make sure it starts at startX and startY location.

		World.readWorld(worldName);
		World.setVisible(true);
		World.setDelay(1);
		/**
		 * This section will have all the logic that takes the Robot to every location
		 * and cleans up all piles of beepers. Think about ways you can break this
		 * large, complex task into smaller, easier to solve problems.
		 */

		// the line below causes a null pointer exception
		// what is that and why are we getting it?
		int totalBeepersPicked = 0, totalSquareMoved = 1;//this is the initial grid we are on
		int totalBeepers = 0; // Need to move this somewhere else.
		boolean areWeDone = false;
		while (areWeDone == false) {
			while (roomba.frontIsClear()) {
				roomba.move();
				totalSquareMoved++;
				while (roomba.nextToABeeper()) {
					roomba.pickBeeper();
					totalBeepersPicked++;
				}
			}
			if (roomba.facingNorth()) {
				roomba.turnLeft();
				roomba.turnLeft();
				roomba.turnLeft();
				if (roomba.frontIsClear()) {

					roomba.move();
					totalSquareMoved++;
					while (roomba.nextToABeeper()) {
						roomba.pickBeeper();
						totalBeepersPicked++;
					}

					roomba.turnLeft();
					roomba.turnLeft();
					roomba.turnLeft();

				} else {
					areWeDone = true;
				}

			} else {
				roomba.turnLeft();
				if (roomba.frontIsClear()) {
					roomba.move();
					totalSquareMoved++;
					roomba.turnLeft();
					while (roomba.nextToABeeper()) {
						roomba.pickBeeper();
						totalBeepersPicked++;
					}
				} else {
					areWeDone = true;
				}
			}
          
		}

		System.out.println( "the area is " + totalSquareMoved);
		// This method should return the total number of beepers cleaned up.
		return totalBeepersPicked;
	}
}
