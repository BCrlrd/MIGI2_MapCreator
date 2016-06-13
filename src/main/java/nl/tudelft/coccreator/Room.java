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
}
