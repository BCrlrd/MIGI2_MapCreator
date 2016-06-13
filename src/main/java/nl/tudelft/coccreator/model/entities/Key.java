package nl.tudelft.coccreator.model.entities;

import lombok.Getter;
import lombok.Setter;
import nl.tudelft.coccreator.Colour;

public class Key extends Entity {
	@Getter @Setter private Colour colour;

	public Key(int xCoord, int yCoord, int zCoord, Colour colour) {
		super(xCoord, yCoord, zCoord, "Key");
		this.colour = colour;
	}

	@Override
	public String toString() {
		return super.toString() + " " + colour.toString();
	}
}
