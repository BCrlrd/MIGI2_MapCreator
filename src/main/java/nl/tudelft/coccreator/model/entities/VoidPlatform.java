package nl.tudelft.coccreator.model.entities;

public class VoidPlatform extends Entity {
	public VoidPlatform(int xCoord, int yCoord, int zCoord) {
		super(xCoord, yCoord, zCoord, "VoidPlatform");
	}

	@Override
	public String getColour() {
		return "FFFF00";
	}
}
