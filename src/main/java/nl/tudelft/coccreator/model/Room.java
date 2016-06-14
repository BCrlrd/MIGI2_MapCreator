package nl.tudelft.coccreator.model;

import lombok.Getter;
import lombok.Setter;
import nl.tudelft.coccreator.model.PointLight;
import nl.tudelft.coccreator.model.Tile;
import nl.tudelft.coccreator.model.entities.Entity;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Room {
	private static final String PLACEHOLDER = "# Default placeholder comment\n";
	@Getter private int height;
	@Getter private int width;
	@Getter private List<Entity> entities;
	@Getter private List<PointLight> lights;
	@Getter private Tile[][] tiles;
	@Getter private ArrayList<String> comment;
	@Getter private String name;

    public Room(int height, int width, Tile filler, String name) {
        this.height = height;
        this.width = width;
        this.entities = new ArrayList<>();
		this.lights = new ArrayList<>();
        this.tiles = new Tile[width][height];
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				if (x == 0 || y == 0 || x == width - 1 || y == height - 1) {
					tiles[x][y] = Tile.WALL;
				} else {
					if (filler == null) {
						tiles[x][y] = Tile.EMPTY;
					} else {
						tiles[x][y] = filler;
					}
				}
			}
		}
		this.comment = new ArrayList<>();
		this.comment.add(PLACEHOLDER);
		this.name = width + "x" + height + "_" + name;
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

	public void setComment(String comment) {
		this.comment.clear();
		addComment(comment);
	}

	public void addComment(String comment) {
		if (this.comment.size() > 0 && this.comment.get(0).equals(PLACEHOLDER)) {
			this.comment.clear();
		}
		String lines[] = comment.split("\\r?\\n");
		for (String line : lines) {
			this.comment.add("# " + line);
			this.comment.add("\n");
		}
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (String com : comment) {
			sb.append(com);
		}
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

	public void write() {
		try {
			File file = new File("output" + File.separator + this.getName() + ".crf");
			FileWriter fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(this.toString());
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getColour(int x, int z) {
		Entity e = getEntity(x, z);
		if (e != null) return "-fx-control-inner-background: #" + e.getColour();
		return "-fx-control-inner-background: #fff";
	}

	public Entity getEntity(int x, int z) {
		for (Entity e : entities) {
			if (e.getXCoordinate() == x && e.getZCoordinate() == z) {
				return e;
			}
		}
		return null;
	}

	public PointLight getLight(int x, int z) {
		for (PointLight l : lights) {
			if (l.getXCoord() == x && l.getZCoord() == z) {
				return l;
			}
		}
		return null;
	}
}