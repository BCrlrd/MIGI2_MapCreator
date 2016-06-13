package nl.tudelft.coccreator.model.entities;

import lombok.Getter;
import lombok.Setter;
import nl.tudelft.coccreator.util.Direction;

public class Gate extends Entity {
	@Getter @Setter private Direction direction;

	public Gate(int xCoord, int yCoord, int zCoord, Direction direction) {
		super(xCoord, yCoord, zCoord, "Gate");
		this.direction = direction;
	}

	@Override
	public String toString() {
		return super.toString() + " " + direction.getRepresentation();
	}
}
