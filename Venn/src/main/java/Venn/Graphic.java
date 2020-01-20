package Venn;
import java.awt.*;  
import javax.swing.JFrame;
import javax.swing.JTextField;  
public class Graphic extends Canvas{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public void paint(Graphics g) {  
        g.drawString("Hello",40,40);  
        setBackground(Color.WHITE);  
        g.fillRect(130, 30,100, 80);  
        g.drawOval(30,130,50, 60);  
        setForeground(Color.RED);  
        g.fillOval(130,130,50, 60);  
        g.drawArc(30, 200, 40,50,90,60);  
        g.fillArc(30, 130, 40,50,180,40);  
          
    } //f

        public static void main(String[] args) {  
        Graphic m=new Graphic();  
        JFrame f=new JFrame();  
		JTextField field1 = new JTextField();
		field1.setText("Java Code Geeks");
		f.add(field1);
        f.add(m);  
        f.setSize(800,800);  
        //f.setLayout(null);  
        f.setVisible(true);  

		// Display the window.
        

		
    }  

}
