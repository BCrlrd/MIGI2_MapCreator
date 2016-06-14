package nl.tudelft.coccreator.util;

import javafx.scene.paint.Color;
import nl.tudelft.coccreator.EditScreen;
import nl.tudelft.coccreator.model.PointLight;
import nl.tudelft.coccreator.model.Room;
import nl.tudelft.coccreator.model.Tile;
import nl.tudelft.coccreator.model.entities.*;

public final class Applier {

	public static void apply(Color colour, String selectedAction, Tile selectedTile, String selectedEntity,
							 Direction direction, int height, String argument1, String argument2,
							 String argument3, int x, int y) {
		switch(selectedAction) {
			case "Set tile":
				EditScreen.room.setTile(x, y, selectedTile);
				break;
			case "Set entity":
				addEntity(colour, selectedEntity, direction, height, argument1, argument2, argument3, x, y);
				break;
			case "Remove entity":
				EditScreen.room.removeEntity(EditScreen.room.getEntity(x, y));
				break;
			case "Add light":
				addLight(colour, x, height, y, Integer.valueOf(argument1));
				break;
			case "Remove light":
				EditScreen.room.removeLight(EditScreen.room.getLight(x, y));
				break;
			default:
				return;
		}
	}

	private static void addLight(Color c, int x, int y, int z, int radius) {
		Colour colour = new Colour((float) c.getRed(), (float) c.getGreen(), (float) c.getBlue(), (float) c.getOpacity());
		PointLight light = new PointLight(x, y, z, colour, radius);
		EditScreen.room.addLight(light);
	}

	private static void addEntity(Color c, String selectedEntity,
								  Direction direction, int height,
								  String argument1, String argument2, String argument3,
								  int x, int y) {
		Room r = EditScreen.room;
		Colour colour = new Colour((float) c.getRed(), (float) c.getGreen(), (float) c.getBlue(), (float) c.getOpacity());
		switch (selectedEntity) {
			case "Bomb":
				Bomb bomb = new Bomb(x, height, y);
				r.addEntity(bomb);
				break;
			case "Carrot":
				Carrot carrot = new Carrot(x, height, y);
				r.addEntity(carrot);
				break;
			case "Crate":
				float health;
				try {
					health = Float.valueOf(argument1);
				} catch (Exception e) {
					health = 3;
				}
				Crate crate = new Crate(x, height, y, health);
				r.addEntity(crate);
				break;
			case "DamagedWall":
				DamagedWall dWall = new DamagedWall(x, height, y);
				r.addEntity(dWall);
				break;
			case "Door":
				Door door = new Door(x, height, y, colour, direction);
				r.addEntity(door);
				break;
			case "Gate":
				Gate gate = new Gate(x, height, y, direction);
				r.addEntity(gate);
				break;
			case "InvisibleWall":
				InvisibleWall invisibleWall = new InvisibleWall(x, height, y);
				r.addEntity(invisibleWall);
				break;
			case "Key":
				Key key = new Key(x, height, y, colour);
				r.addEntity(key);
				break;
			case "KillerBunny":
				KillerBunny killerBunny = new KillerBunny(x, height, y);
				r.addEntity(killerBunny);
				break;
			case "LandMine":
				LandMine landMine = new LandMine(x, height, y);
				r.addEntity(landMine);
				break;
			case "Pitfall":
				float radius;
				try {
					radius = Float.valueOf(argument1);
				} catch (Exception e) {
					radius = 1;
				}
				Pitfall pitfall = new Pitfall(x, height, y, radius);
				r.addEntity(pitfall);
				break;
			case "Player":
				Player player = new Player(x, height, y);
				r.addEntity(player);
				break;
			case "PlayerTrigger":
				float distance;
				try {
					distance = Float.valueOf(argument1);
				} catch (Exception e) {
					distance = 1;
				}
				float cooldown;
				try {
					cooldown = Float.valueOf(argument2);
				} catch (Exception e) {
					cooldown = 1;
				}
				PlayerTrigger trigger = new PlayerTrigger(x, height, y, distance, cooldown, argument3);
				r.addEntity(trigger);
				break;
			case "Treasure":
				Treasure treasure = new Treasure(x, height, y);
				r.addEntity(treasure);
				break;
			case "VoidPlatform":
				VoidPlatform voidPlatform = new VoidPlatform(x, height, y);
				r.addEntity(voidPlatform);
				break;
			case "WallFrame":
				float w;
				try {
					w = Float.valueOf(argument2);
				} catch (Exception e) {
					w = 1;
				}
				float h;
				try {
					h = Float.valueOf(argument3);
				} catch (Exception e) {
					h = 1;
				}
				WallFrame wallFrame = new WallFrame(x, height, y, direction, argument1, w, h);
				r.addEntity(wallFrame);
				break;
			default:
				return;
		}
	}
}
