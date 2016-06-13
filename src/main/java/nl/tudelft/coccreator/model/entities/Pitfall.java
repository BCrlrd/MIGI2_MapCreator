package nl.tudelft.coccreator.model.entities;

import lombok.Getter;
import lombok.Setter;

public class Pitfall extends Entity {
	@Getter @Setter private float radius;

	public Pitfall(int xCoord, int yCoord, int zCoord, float radius) {
		super(xCoord, yCoord, zCoord, "Pitfall");
		this.radius = radius;
	}

	@Override
	public String toString() {
		return super.toString() + " " + radius;
	}
}
