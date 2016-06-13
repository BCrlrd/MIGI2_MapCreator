package nl.tudelft.COCRoomCreator.entities;

import lombok.Getter;

/**
 * Abstract class for entities.
 */

public abstract class Entity {
	@Getter private int xCoordinate;
	@Getter private int yCoordinate;
	@Getter private int zCoordinate;
	@Getter private String name;

	/**
	 * Constructor.
	 *
	 * @param xCoord
	 * 		the x coordinate for the entity
	 * @param yCoord
	 * 		the y coordinate for the entity
	 * @param zCoord
	 * 		the z coordinate for the entity
	 * @param name
	 * 		the name of the entity
	 */
	public Entity(int xCoord, int yCoord, int zCoord, String name) {
		this.xCoordinate = xCoord;
		this.yCoordinate = yCoord;
		this.zCoordinate = zCoord;
		this.name = name;
	}

	/**
	 * Create a string representation for an entity
	 * which can be saved to file.
	 *
	 * @return
	 * 		the created string
	 */
	public String toString() {
		return this.getXCoordinate() + " " + this.getYCoordinate() + " " + this.getYCoordinate() + " " + getName();
	}
}
