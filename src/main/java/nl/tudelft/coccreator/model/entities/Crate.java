package nl.tudelft.coccreator.model.entities;

import lombok.Getter;
import lombok.Setter;

public class Crate extends Entity {
	@Getter @Setter private float health;

	public Crate(int xCoord, int yCoord, int zCoord, float health) {
		super(xCoord, yCoord, zCoord, "Crate");
		this.health = health;
	}

	@Override
	public String toString() {
		return super.toString() + " " + health;
	}

	@Override
	public String getColour() {
		return "FFCC00";
	}
}
