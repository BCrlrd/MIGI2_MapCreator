package nl.tudelft.coccreator.model.entities;

public class KillerBunny extends Entity {
	public KillerBunny(int xCoord, int yCoord, int zCoord) {
		super(xCoord, yCoord, zCoord, "KillerBunny");
	}

	@Override
	public String getColour() {
		return "00FF00";
	}
}
