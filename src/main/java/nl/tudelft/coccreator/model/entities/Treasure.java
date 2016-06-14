package nl.tudelft.coccreator.model.entities;

public class Treasure extends Entity {
	public Treasure(int xCoord, int yCoord, int zCoord) {
		super(xCoord, yCoord, zCoord, "Treasure");
	}

	@Override
	public String getColour() {
		return "FFFFCC";
	}
}
