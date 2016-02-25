import java.awt.*;

public class model {
    
	private int pointCount;

	
	private Point[] points;
	
	private Color selectedColor;
	//private FontSize selectedSize;
        
	public model() {
		pointCount = 0;
		points = new Point[10000];
		selectedColor = Color.CYAN;
	}
	
	
	public void addPoint(Point point) {
		points[pointCount] = point;
		pointCount++;
	}
	
	public Point getPoint(int i) {
		if (i >= 0 && i < pointCount) {
			
			return points[i];
		}
		return null;
	}
	
	
	public void setSelectedColor(Color color) {
		selectedColor = color;
	}
	
        //public void setSelectedSize(Fontsize size){
          //  selectedSize = size;
        //}
	
	public Color getSelectedColor() {
		return selectedColor;
	}
        
       // public FontSize getSelectedSize(){
        //        return selectedSize;
       // }
}
