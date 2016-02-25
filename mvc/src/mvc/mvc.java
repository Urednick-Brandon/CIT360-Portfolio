import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;



public class mvc {
	/**
	 * main method starts the application
	 */
	public static void main(String[] args) {
		model model = new model();
		view view = new view(model);
		controller controller = new controller(model, view);
		
		// register controller as the listener
		view.registerListener(controller);
		
		// start it up
		view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		view.setSize(400, 300);
		view.setVisible(true);
	}
}
