import java.awt.Point;

import processing.core.PApplet;


public class Circle extends Shape{
	
	
	private int diameter;
	
	public Circle(Point location, PApplet parent, int diameter, int strokeColor, int fillColor) {
		super(location, new MouseOverCircle(location, diameter, parent), strokeColor, fillColor, parent);
		this.diameter = diameter;
	}
	
	
	public void draw(){
		super.getParent().stroke(strokeColor);
		super.getParent().fill(fillColor);
		super.getParent().ellipse(super.getLocation().x, super.getLocation().y, diameter, diameter);
	}
	
	
	
}
