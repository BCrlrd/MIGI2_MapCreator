package nl.tudelft.coccreator.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum Tile {
	FLOOR("O"),
	WALL("#"),
	ENTRANCE("I"),
	EXIT("X"),
	EMPTY("-");

	@Getter private final String representation;
}