import java.awt.Point;

import processing.core.PApplet;


public abstract class Shape {
	
	
	private Point location;
	private PApplet parent;
	public Shape(Point location, PApplet parent){
		this.location = location;
		this.parent = parent;
	}
	public void draw(){};
}
