package nl.tudelft.coccreator;

import nl.tudelft.coccreator.model.PointLight;
import nl.tudelft.coccreator.model.Tile;
import nl.tudelft.coccreator.model.entities.Bomb;
import nl.tudelft.coccreator.model.entities.PlayerTrigger;

public final class Main  {

	private Main() { }

	public static void main(String[] args) {
		Room room = new Room(10, 11, "TestRoom");
		room.setTile(0, 0, Tile.FLOOR);
		room.setTile(9, 0, Tile.WALL);
		room.addEntity(new Bomb(2, 3, 1));
		room.addLight(new PointLight(2, 3, 1, new Colour(10, 2, 4, 1), 5));
		room.setComment("This is a test room.");
		room.addComment("It would be extremely boring to play.");
		room.addComment("However, it is a good test\nfor this program.");
		room.addEntity(new PlayerTrigger(1, 5, 3, 3, 2, "Healer"));
		room.addEntity(new PlayerTrigger(2, 6, 4, 4, 3, "Healer.class"));
		room.write();
		System.out.println(room.getName());
		System.out.println(room.toString());
	}
}
