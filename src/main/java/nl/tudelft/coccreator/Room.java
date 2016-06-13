package nl.tudelft.coccreator;

import lombok.Getter;
import lombok.Setter;
import nl.tudelft.coccreator.model.PointLight;
import nl.tudelft.coccreator.model.Tile;
import nl.tudelft.coccreator.model.entities.Entity;

import java.util.ArrayList;
import java.util.List;

public class Room {
	@Getter private int height;
	@Getter private int width;
	@Getter private List<Entity> entities;
	@Getter private List<PointLight> lights;
	@Getter private Tile[][] tiles;
	@Getter @Setter private String comment;

    public Room(int height, int width) {
        this.height = height;
        this.width = width;
        this.entities = new ArrayList<>();
		this.lights = new ArrayList<>();
        this.tiles = new Tile[width][height];
		this.comment = "# Default placeholder comment";
    }

	public void setTile(int x, int y, Tile type) {
		if (x < width && y < height && x >= 0 && y >= 0) {
			tiles[x][y] = type;
		}
	}

	public void addEntity(Entity ent) {
		entities.add(ent);
	}

	public void removeEntity(Entity ent) {
		entities.remove(ent);
	}

	public void addLight(PointLight light) {
		lights.add(light);
	}

	public void removeLight(PointLight light) {
		lights.remove(light);
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(comment);
		sb.append("\n");
		sb.append(width);
		sb.append(" ");
		sb.append(height);
		sb.append(" ");
		sb.append(entities.size());
		sb.append(" ");
		sb.append(lights.size());
		sb.append("\n");
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				if (tiles[x][y] != null) {
					sb.append(tiles[x][y].getRepresentation());
				} else {
					sb.append(Tile.EMPTY.getRepresentation());
				}
				if (x < width - 1) {
					sb.append(" ");
				}
			}
			sb.append("\n");
		}
		for (Entity e : entities) {
			sb.append(e.toString());
			sb.append("\n");
		}
		for (PointLight p : lights) {
			sb.append(p.toString());
			sb.append("\n");
		}
		sb.setLength(sb.length() - 1);
		return sb.toString();
	}
}