package Venn;
import processing.core.PApplet;

public class TextBox {
	PApplet sketch;
	float x, y;
	String letters;
	int fontSize;

	public TextBox(PApplet sketch, float x, float y, String letters, int fontSize) {
		super();
		this.sketch = sketch;
		this.x = x;
		this.y = y;
		this.letters = letters;
		this.fontSize = fontSize;
	}

}
