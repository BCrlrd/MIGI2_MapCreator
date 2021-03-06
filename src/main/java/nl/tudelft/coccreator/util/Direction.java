package nl.tudelft.coccreator.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum Direction {
	NORTH("NORTH"),
	EAST("EAST"),
	SOUTH("SOUTH"),
	WEST("WEST");

	@Getter private String representation;
}
