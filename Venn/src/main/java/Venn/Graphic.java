package Venn;

import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Graphic extends Canvas {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void paint(Graphics g) {
		g.setColor(new Color(0,255,0,100));
		g.fillOval(100, 200,300, 300);
		g.setColor(new Color(255,0,0,100));
		g.fillOval(300, 200, 300, 300);
	} // f
	public static void main(String[] args) {
		JFrame f = new JFrame();
		Canvas canvas = new Graphic();
		canvas.setBackground(Color.lightGray);
		canvas.setSize(800, 800);
		f.add(canvas);
		f.pack();
		// f.setLayout(null);
		f.setVisible(true);
	}
}

		// Display the window

