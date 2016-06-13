package nl.tudelft.COCRoomCreator.entities;

/**
 * Class representing a bomb.
 */
public class Bomb extends Entity {

	/**
	 * Constructor for a bomb.
	 *
	 * @param xCoord
	 * 		the x coordinate to use
	 * @param yCoord
	 * 		the y coordinate to use
	 * @param zCoord
	 * 		the z coordinate to use
	 */
	public Bomb(int xCoord, int yCoord, int zCoord) {
		super(xCoord, yCoord, zCoord, "Bomb");
	}
}
