import java.awt.Point;

import processing.core.PApplet;


public abstract class Shape {
	
	
	private Point location;
	private PApplet parent;
	private MouseOverAlgorithm mouseOverAlgorithm;
	public Shape(Point location, MouseOverAlgorithm mouseOverAlgorithm, PApplet parent){
		this.location = location;
		this.parent = parent;
		this.mouseOverAlgorithm = mouseOverAlgorithm;
	}
	public void draw(){};
	
	
	public Point getLocation(){
		return location;
	}
	
	protected PApplet getParent(){
		return parent;
	}
	
	public boolean mouseOver(){
		return mouseOverAlgorithm.MouseOver();
	}
}
