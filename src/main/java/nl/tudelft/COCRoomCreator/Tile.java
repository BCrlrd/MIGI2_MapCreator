package nl.tudelft.COCRoomCreator;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Enum representing possible tile types.
 */
@AllArgsConstructor
public enum Tile {
	FLOOR("O"),
	WALL("#"),
	ENTRANCE("I"),
	EXIT("X"),
	EMPTY("-");

	@Getter private final String representation;
}