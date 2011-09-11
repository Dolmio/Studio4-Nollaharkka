import java.awt.Point;

import processing.core.PApplet;


public class MouseOverCircle implements MouseOverAlgorithm {

	private Point location;
	private int diameter;
	private PApplet parent;
	
	public MouseOverCircle(Point location, int diameter, PApplet parent){
		this.location = location;
		this.diameter = diameter;
		this.parent = parent;
	}
	
	@Override
	public boolean MouseOver() {
		float disX = location.x - parent.mouseX;
	    float disY = location.y - parent.mouseY;
	    if(parent.sqrt(parent.sq(disX) + parent.sq(disY)) < diameter/2 ) {
	      return true;
	    } 
	    else {
	      return false;
	    }
	}

}
