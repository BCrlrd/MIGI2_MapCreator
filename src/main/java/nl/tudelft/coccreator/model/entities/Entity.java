package nl.tudelft.coccreator.model.entities;

import lombok.Getter;

public abstract class Entity {
	@Getter private int xCoordinate;
	@Getter private int yCoordinate;
	@Getter private int zCoordinate;
	@Getter private String name;

	public Entity(int xCoord, int yCoord, int zCoord, String name) {
		this.xCoordinate = xCoord;
		this.yCoordinate = yCoord;
		this.zCoordinate = zCoord;
		this.name = name;
	}

	public String toString() {
		return this.getXCoordinate() + " " + this.getYCoordinate() + " " + this.getYCoordinate() + " " + getName();
	}
}
