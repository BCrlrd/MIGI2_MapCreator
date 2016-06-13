package nl.tudelft.coccreator;

import nl.tudelft.coccreator.model.PointLight;
import nl.tudelft.coccreator.model.Tile;
import nl.tudelft.coccreator.model.entities.Bomb;

public final class Main  {

	private Main() { }

	public static void main(String[] args) {
		Room room = new Room(10, 10);
		room.setTile(0, 0, Tile.FLOOR);
		room.setTile(9, 0, Tile.WALL);
		room.addEntity(new Bomb(2, 3, 1));
		room.addLight(new PointLight(2, 3, 1, new Colour(10, 2, 4, 1), 5));
		System.out.println(room.toString());
	}
}
