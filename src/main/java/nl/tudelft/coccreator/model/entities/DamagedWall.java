package nl.tudelft.coccreator.model.entities;

public class DamagedWall extends Entity {
	public DamagedWall(int xCoord, int yCoord, int zCoord) {
		super(xCoord, yCoord, zCoord, "DamagedWall");
	}

	@Override
	public String getColour() {
		return "666666";
	}
}
