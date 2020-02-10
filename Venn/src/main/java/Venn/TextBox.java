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

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public String getLetters() {
		return letters;
	}

	public void setLetters(String letters) {
		this.letters = letters;
	}
	
}
