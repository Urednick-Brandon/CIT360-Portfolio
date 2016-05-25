import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;


public class view extends JFrame {
    
	private model model;
	
        private paintpanel mousePanel;
	
	private JList colorList;
	private JList sizeList;
	private JPanel listPanel;
        private JPanel sizePanel;

	private static final String[] colorNames = {"Black", "Blue", "Cyan",
		"Dark Gray", "Gray", "Green", "Light Gray", "Magenta",
		"Orange", "Pink", "Red", "White", "Yellow"};
        
        private static final String[] sizeNames = {"2", "3", "4", "5", "6", "7"};
	
	private static final Color[] colors = {Color.BLACK, Color.BLUE,
		Color.CYAN, Color.DARK_GRAY, Color.GRAY, Color.GREEN, 
		Color.LIGHT_GRAY, Color.MAGENTA, Color.ORANGE, Color.PINK, 
		Color.RED, Color.WHITE, Color.YELLOW};
        
       // private static final FontSize[] sizes = {FontSize.1, FontSize.2 
       // FontSize.3, FontSize.4, FontSize.5, FontSize.6, FontSize.7};
        

	public view(model model) {
		super("Illustrate Model-View-Controller");
		this.model = model;

		/* CENTER: Add a panel that the user can draw on. */
		mousePanel = new paintpanel(model);
		mousePanel.setBackground(Color.WHITE);
		add(mousePanel, BorderLayout.CENTER);

		/* WEST: Add a list so the user can select a color. */
		listPanel = new JPanel();
		add(listPanel, BorderLayout.WEST);
		colorList = new JList(colorNames);
		colorList.setVisibleRowCount(5);
		colorList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listPanel.add(new JScrollPane(colorList), BorderLayout.CENTER);
                
                sizePanel = new JPanel();
		add(sizePanel, BorderLayout.EAST);
		sizeList = new JList(sizeNames);
		sizeList.setVisibleRowCount(4);
		sizeList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		sizePanel.add(new JScrollPane(sizeList), BorderLayout.CENTER);
	} // end constructor

	
	public void registerListener(controller listener) {
		colorList.addListSelectionListener(listener);
		mousePanel.addMouseMotionListener(listener);
	}

	public Color getSelectedColor() {
		return colors[colorList.getSelectedIndex()];
	}

       // public FontSize getSelectedSize(){
         //      return sizes[sizeList.getSelectedIndex()];
        //}
	
	public void paint(Graphics g) {
		listPanel.setBackground(model.getSelectedColor());
		super.paint(g); // This will paint the components.
	} // end method paint
}
