package nl.tudelft.coccreator.model.entities;

public class InvisibleWall extends Entity {
	public InvisibleWall(int xCoord, int yCoord, int zCoord) {
		super(xCoord, yCoord, zCoord, "InvisibleWall");
	}

	@Override
	public String getColour() {
		return "D3D3D3";
	}
}
