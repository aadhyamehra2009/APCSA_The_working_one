package robot;

import kareltherobot.*;

public class Roomba implements Directions {

	// Main method to make this self-contained
	public static void main(String[] args) {
		// LEAVE THIS ALONE!!!!!!
		String worldName = "robot/basicRoom.wld";

		Roomba cleaner = new Roomba();
		int totalBeepers = cleaner.cleanRoom(worldName, 7, 6);
		System.out.println("Roomba cleaned up a total of " + totalBeepers + " beepers.");

	}

	// declared here so it is visible in all the methods!
	private Robot roomba = new Robot(7, 7, North, 100);

	// You will need to add many variables!!

	public int cleanRoom(String worldName, int startX, int startY) {

		// A new Robot should be constructed and assigned to the global (instance)
		// variable named roomba that is declared above.
		// Make sure it starts at startX and startY location.

		World.readWorld(worldName);
		World.setVisible(true);
		World.setDelay(10);
		/**
		 * This section will have all the logic that takes the Robot to every location
		 * and cleans up all piles of beepers. Think about ways you can break this
		 * large, complex task into smaller, easier to solve problems.
		 */

		// the line below causes a null pointer exception
		// what is that and why are we getting it?
		int totalBeepers = 0; // Need to move this somewhere else.
		
		int j=1;
		while (j<=8) {
			int i = 1;
			while (i <= 4) {
				roomba.move();
				while (roomba.nextToABeeper()) {
					roomba.pickBeeper();
				}
				i++;
			}
			if(roomba.facingNorth())
		{
			roomba.turnLeft();
			roomba.turnLeft();
			roomba.turnLeft();
			roomba.move();
			while (roomba.nextToABeeper()) {
					roomba.pickBeeper();
			}
			roomba.turnLeft();
			roomba.turnLeft();
			roomba.turnLeft();
				
			
		}
		else
		{
			roomba.turnLeft();
			roomba.move();
			roomba.turnLeft();
			while (roomba.nextToABeeper()) {
			roomba.pickBeeper();
			}
		}
		j++;

		}
			
		
			

		// This method should return the total number of beepers cleaned up.
		return totalBeepers;
	}
}
