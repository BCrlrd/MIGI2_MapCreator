package nl.tudelft.coccreator.model.entities;

import lombok.Getter;
import lombok.Setter;
import nl.tudelft.coccreator.Colour;
import nl.tudelft.coccreator.Direction;

public class Door extends Entity {
	@Getter @Setter private Colour colour;
	@Getter @Setter private Direction direction;

	public Door(int xCoord, int yCoord, int zCoord, Colour colour, Direction direction) {
		super(xCoord, yCoord, zCoord, "Door");
		this.colour = colour;
		this.direction = direction;
	}

	@Override
	public String toString() {
		return super.toString() + " " + colour.toString() + " " + direction.getRepresentation();
	}
}
