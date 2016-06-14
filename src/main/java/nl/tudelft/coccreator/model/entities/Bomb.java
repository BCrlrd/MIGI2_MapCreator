package nl.tudelft.coccreator.model.entities;

public class Bomb extends Entity {

	public Bomb(int xCoord, int yCoord, int zCoord) {
		super(xCoord, yCoord, zCoord, "Bomb");
	}

	@Override
	public String getColour() {
		return "000";
	}
}
