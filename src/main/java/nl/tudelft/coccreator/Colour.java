package nl.tudelft.coccreator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class Colour {
	@Getter @Setter private int red;
	@Getter @Setter private int green;
	@Getter @Setter private int blue;
	@Getter @Setter private int alpha;

	public String toString() {
		return red + "/" + green + "/" + blue + "/" + alpha;
	}
}
