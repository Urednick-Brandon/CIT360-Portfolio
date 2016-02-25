import java.awt.Graphics;
import java.awt.Point;
import javax.swing.JPanel;

public class paintpanel extends JPanel {
    
	private model model;

	public paintpanel(model model) {
		this.model = model;
	} 


	public void paintComponent(Graphics g) {
		super.paintComponent(g); // clears drawing area
		int i = 0;
		Point point = model.getPoint(0);
		while (point != null) {
			g.fillOval(point.x, point.y, 3, 3);//change font size?
			i++;
			point = model.getPoint(i);
		}
	} 
}
