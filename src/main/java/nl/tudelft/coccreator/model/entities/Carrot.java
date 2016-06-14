package nl.tudelft.coccreator.model.entities;

public class Carrot extends Entity {
	public Carrot(int xCoord, int yCoord, int zCoord) {
		super(xCoord, yCoord, zCoord, "Carrot");
	}

	@Override
	public String getColour() {
		return "EB8921";
	}
}
