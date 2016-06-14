package nl.tudelft.coccreator.model.entities;

public class Player extends Entity {
	public Player(int xCoord, int yCoord, int zCoord) {
		super(xCoord, yCoord, zCoord, "Player");
	}

	@Override
	public String getColour() {
		return "800080";
	}
}
