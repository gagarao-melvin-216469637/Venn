package Venn;
import java.util.ArrayList;
import java.awt.Color;
import processing.core.PApplet;


public class SketchTester extends PApplet{
	
	// Define some containers and temporary variables
	ArrayList<Shape> shapes = new ArrayList<Shape>();
	ArrayList<TextBox> textBoxes = new ArrayList<TextBox>();
	Color ellipseTemp = Color.decode("#52de97");
	Color red = Color.decode("#da2d2d");
	Color green = Color.decode("#21bf73");

	// This is run once at the start of the program
	public void settings() {
		size(900, 500);
		shapes.add(new Ellipse(this, ellipseTemp, width/2, height/2, 50, 50));
	}
	
	// This is continuous loop that runs until terminated
	public void draw() {
		
		background(255);
		//noStroke();
		boolean mouseIn = false;
		
		for(Shape s : shapes) {
			s.display();
			if(s.contains(mouseX, mouseY))
				mouseIn = true;
		}
		
		if(mouseIn)
			fill(green.getRGB(), 200);
		else
			fill(red.getRGB(), 200);
		ellipse(mouseX, mouseY, 20, 20);
		mouseIn = false;
		
	}
	
	// Mouse and Keyboard Listeners
	public void mousePressed() {
	}
	
	public void keyPressed() {
		exit();
	}
	
	// The main method is unimportant for Processing
	public static void main(String[] args) {
		String[] processingArgs = {"SketchTester"};
		SketchTester sketchTester = new SketchTester();
		PApplet.runSketch(processingArgs, sketchTester);
	}

}
