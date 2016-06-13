package nl.tudelft.COCRoomCreator.entities;

/**
 * Class representing a LandMine.
 */
public class LandMine extends Entity {

	/**
	 * Constructor for a LandMine.
	 *
	 * @param xCoord
	 * 		the x coordinate to use
	 * @param yCoord
	 * 		the y coordinate to use
	 * @param zCoord
	 * 		the z coordinate to use
	 */
	public LandMine(int xCoord, int yCoord, int zCoord) {
		super(xCoord, yCoord, zCoord, "LandMine");
	}
}
