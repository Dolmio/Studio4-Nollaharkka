import java.awt.Point;

import processing.core.PApplet;


public class Rectangle extends Shape {

	private int width, height;
	private Point location;
	private PApplet parent;
	
	public Rectangle(Point location, int width, int height, PApplet parent) {
		super(location, parent);
		this.width = width;
		this.height = height;
		this.location = location;
		this.parent = parent;
	}
	
	
	public void draw(){
		parent.stroke(0);
		parent.fill(100);
		parent.rect(location.x, location.y, width, height);
	}

}
