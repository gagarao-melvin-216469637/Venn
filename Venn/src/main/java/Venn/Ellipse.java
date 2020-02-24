package Venn;
import java.awt.Color;
import processing.core.PApplet;

public class Ellipse extends Shape{
	float xRad, yRad;

	public Ellipse(PApplet sketch, Color fill, float x, float y, int xRad, int yRad) {
		super(sketch, fill, x, y);
		this.xRad = xRad;
		this.yRad = yRad;
	}
	
	@Override
	void display() {
		sketch.fill(fill.getRGB(), 200);
		sketch.ellipse(x, y, xRad*2, yRad*2);
	}
	
	@Override
	boolean contains(float x, float y) {
		if(xRad != 0 && yRad != 0)
			if(Math.hypot(x-this.x, (y-this.y)*xRad/yRad) <= xRad)
				return true;
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
