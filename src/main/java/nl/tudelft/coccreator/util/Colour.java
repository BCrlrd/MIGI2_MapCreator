package nl.tudelft.coccreator.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class Colour {
	@Getter @Setter private float red;
	@Getter @Setter private float green;
	@Getter @Setter private float blue;
	@Getter @Setter private float alpha;

	public String toString() {
		return red / 255 + "/" + green / 255 + "/" + blue / 255 + "/" + alpha / 255;
	}
}
