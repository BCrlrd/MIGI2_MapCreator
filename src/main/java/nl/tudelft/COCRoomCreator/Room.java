package nl.tudelft.COCRoomCreator;

import lombok.Getter;
import lombok.Setter;
import nl.tudelft.COCRoomCreator.entities.Entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Class containing the entire room.
 */
public class Room {
	@Getter private int height;
	@Getter private int width;
	@Getter private List<Entity> entities;
	@Getter private Tile[][] tiles;
	@Getter @Setter private String message;

	/**
	 * Constructor for a room.
     *
     * @param height
     *      the height of the room
     * @param width
     *      the width of the room
     */
    public Room(int height, int width) {
        this.height = height;
        this.width = width;
        this.entities = new ArrayList<>();
        this.tiles = new Tile[width][height];
		this.message = "# Default placeholder message";
    }
}
