package robot;

import kareltherobot.*;

public class Roomba implements Directions {

	// Main method to make this self-contained
	public static void main(String[] args) {
		// LEAVE THIS ALONE!!!!!!
		String worldName = "robot/finalTestWorld2024.wld";

		Roomba cleaner = new Roomba();
		int totalBeepers = cleaner.cleanRoom(worldName, 7, 6);
		System.out.println("Roomba cleaned up a total of " + totalBeepers + " beepers.");

	}

	// declared here so it is visible in all the methods!
	private Robot roomba = new Robot(26, 101, North, 100);

	// You will need to add many variables!!

	public int cleanRoom(String worldName, int startX, int startY) {

		// A new Robot should be constructed and assigned to the global (instance)
		// variable named roomba that is declared above.
		// Make sure it starts at startX and startY location.

		World.readWorld(worldName);
		World.setVisible(true);
		World.setDelay(0);
		/**
		 * This section will have all the logic that takes the Robot to every location
		 * and cleans up all piles of beepers. Think about ways you can break this
		 * large, complex task into smaller, easier to solve problems.
		 */

		// the line below causes a null pointer exception
		// what is that and why are we getting it?
		int totalBeepersPicked = 0, totalSquareMoved = 1;//this is the initial grid we are on
		int pilesize = 0;
		int pilenumbers=0;
		int biggestPile = 0;
		int biggesty = 0;
		int smallestx = 99999999;
		int biggestPileX = 0;
		int biggestPileY= 0;
		boolean areWeDone = false;
		pilesize=0;
				while (roomba.nextToABeeper()) {
					roomba.pickBeeper();
					totalBeepersPicked++;
					pilesize++;
					

				}
				
				if (pilesize>biggestPile)
					{
						biggestPile=pilesize;
						biggestPileX=roomba.avenue();
						biggestPileY=roomba.street();
					}
				if (pilesize==0)
					{

					}
					else
					{
						pilenumbers++;
					}
		while (areWeDone == false) {
			while (roomba.frontIsClear()) {
				roomba.move();
				if (roomba.street()>biggesty) {
				//street is y
						biggesty=roomba.street();
				}
				if (roomba.avenue()< smallestx)
				{
					smallestx=roomba.avenue();
				}
				totalSquareMoved++;
				pilesize=0;
				while (roomba.nextToABeeper()) {
					roomba.pickBeeper();
					totalBeepersPicked++;
					pilesize++;
					

				}
				
				if (pilesize>biggestPile)
					{
						biggestPile=pilesize;
						biggestPileX=roomba.avenue();
						biggestPileY=roomba.street();
					}
				if (pilesize==0)
					{

					}
					else
					{
						pilenumbers++;
					}
			}
			if (roomba.facingNorth()) {
				roomba.turnLeft();
				roomba.turnLeft();
				roomba.turnLeft();
				if (roomba.frontIsClear()) {

					roomba.move();
					totalSquareMoved++;
					//move
					
					
					pilesize=0;
					while (roomba.nextToABeeper()) {
						roomba.pickBeeper();
						totalBeepersPicked++;
						pilesize++;
					}
					if (pilesize>biggestPile)
					{
						biggestPile=pilesize;

						biggestPileX=roomba.avenue();
						biggestPileY=roomba.street();
					}
					if (pilesize==0)
					{

					}
					else
					{
						pilenumbers++;
					}
					//pick up all beepers in a pile


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
					pilesize=0;
					while (roomba.nextToABeeper()) {
						roomba.pickBeeper();
						totalBeepersPicked++;
						pilesize++;

					}
					if (pilesize>biggestPile)
					{
						biggestPile=pilesize;

						biggestPileX=roomba.avenue();
						biggestPileY=roomba.street();
					}
					if (pilesize==0)
					{

					}
					else
					{
						pilenumbers++;
					}
				} else {
					areWeDone = true;
				}
			}
          
		}
		
		double averagePileSize =  (double)totalBeepersPicked / pilenumbers;
		System.out.println( "the area is " + totalSquareMoved);
		System.out.println("number of piles are " + pilenumbers);
		System.out.println("The total number of beepers is " + totalBeepersPicked);
		System.out.println("The largest pile of beepers is " + biggestPile);
		System.out.println("The location of the largest pile of beepers is " + (biggesty - biggestPileY) + " down and " + (biggestPileX-smallestx));
		System.out.println("The average pile size is " + averagePileSize);
		System.out.println("The percent dirty is " + ((double)pilenumbers/totalSquareMoved));
		// This method should return the total number of beepers cleaned up.
		return totalBeepersPicked;
	}
}
