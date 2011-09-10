import java.awt.Point;

import processing.core.PApplet;


public class Circle extends Shape{
	
	
	private int diameter;
	
	public Circle(Point location, PApplet parent, int diameter) {
		super(location, new MouseOverCircle(location, diameter, parent), parent);
		this.diameter = diameter;
	}
	
	
	public void draw(){
		super.getParent().stroke(0);
		super.getParent().fill(0);
		super.getParent().ellipse(super.getLocation().x, super.getLocation().y, diameter, diameter);
	}
	
	
	
}
