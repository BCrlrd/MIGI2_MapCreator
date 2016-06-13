package nl.tudelft.COCRoomCreator.entities;

import lombok.Getter;
import lombok.Setter;

/**
 * Class representing a pitfall.
 */
public class Pitfall extends Entity {
	@Getter @Setter private float radius;

	/**
	 * Constructor for a Pitfall.
	 *
	 * @param xCoord
	 * 		the x coordinate to use
	 * @param yCoord
	 * 		the y coordinate to use
	 * @param zCoord
	 * 		the z coordinate to use
	 * @param radius
	 * 		the radius of the Pitfall
	 */
	public Pitfall(int xCoord, int yCoord, int zCoord, float radius) {
		super(xCoord, yCoord, zCoord, "Pitfall");
		this.radius = radius;
	}

	@Override
	public String toString() {
		return super.toString() + " " + radius;
	}
}
