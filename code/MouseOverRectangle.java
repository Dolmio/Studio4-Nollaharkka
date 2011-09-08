import java.awt.Point;

import processing.core.PApplet;


public class MouseOverRectangle implements MouseOverAlgorithm {
	
	
	private Point location;
	private int width, height;
	private PApplet parent;
	
	public MouseOverRectangle(Point location, int width, int height, PApplet parent){
		this.location = location;
		this.width = width;
		this.height = height;
		this.parent = parent;
	}
	
	@Override
	public boolean MouseOver() {
		return (parent.mouseX >= location.x && parent.mouseX <= location.x+width && 
			      parent.mouseY >= location.y && parent.mouseY <= location.y+height);
	}

}
