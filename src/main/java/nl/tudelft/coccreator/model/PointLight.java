package nl.tudelft.coccreator.model;

import lombok.Getter;
import lombok.Setter;
import nl.tudelft.coccreator.util.Colour;

public class PointLight {
	@Getter @Setter private Colour colour;
	@Getter @Setter private float radius;
	@Getter @Setter private int xCoord;
	@Getter @Setter private int yCoord;
	@Getter @Setter private int zCoord;

	public PointLight(int xCoord, int yCoord, int zCoord, Colour colour, float radius) {
		this.xCoord = xCoord;
		this.yCoord = yCoord;
		this.zCoord = zCoord;
		this.colour = colour;
		this.radius = radius;
	}

	public String toString() {
		return xCoord + " " + yCoord + " " + zCoord + " PointLight " + colour.toString() + " " + radius;
	}
}
