import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;

public class controller implements ListSelectionListener, MouseMotionListener {
    
	private model model;
	
	private view view;

	public controller(model model, view view) {
		this.model = model;
		this.view = view;
	}

	public void mouseDragged(MouseEvent event) {
		Point point = event.getPoint(); // find point
		model.addPoint(point);
		view.repaint();
	} // end method mouseDragged

	public void mouseMoved(MouseEvent event) {
		//actionlistener event
	}


	public void valueChanged(ListSelectionEvent event) {
		Color color = view.getSelectedColor();
          //      FontSize size = view.getSelectedSize();
          //      model.setSelectedSize(size);
		model.setSelectedColor(color);
		view.repaint();
	}
}
