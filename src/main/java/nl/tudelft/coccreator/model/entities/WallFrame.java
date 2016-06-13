package nl.tudelft.coccreator.model.entities;

import lombok.Getter;
import lombok.Setter;
import nl.tudelft.coccreator.Direction;

public class WallFrame extends Entity {
	@Getter @Setter Direction direction;
	@Getter @Setter String texture;
	@Getter @Setter float width;
	@Getter @Setter float height;

	public WallFrame(int xCoord, int yCoord, int zCoord, Direction direction, String texture, float width, float height) {
		super(xCoord, yCoord, zCoord, "WallFrame");
		this.direction = direction;
		this.texture = texture;
		this.width = width;
		this.height = height;
	}

	@Override
	public String toString() {
		return super.toString() + " " + direction.getRepresentation() + " " + texture + " " + width + " " + height;
	}
}
