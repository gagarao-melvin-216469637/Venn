package Venn;
import processing.core.PApplet;
import java.awt.Color;

public class Shape {
	
	PApplet sketch;
	Color fill;
	float x, y;
	
	public Shape(PApplet sketch, Color fill, float x, float y) {
		this.sketch = sketch;
		this.fill = fill;
		this.x = x;
		this.y = y;
	}
	
	void display() {
		sketch.fill(fill.getRGB(), 200);
		sketch.ellipse(x, y, 5, 5);
	}
	
	boolean contains(float x, float y) {
		return false;
	}

	public Color getFill() {
		return fill;
	}

	public void setFill(Color fill) {
		this.fill = fill;
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
}
