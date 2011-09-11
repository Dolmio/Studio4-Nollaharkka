import java.awt.Point;

import processing.core.PApplet;


public abstract class Shape {
	
	
	private Point location;
	private PApplet parent;
	private MouseOverAlgorithm mouseOverAlgorithm;
	protected int strokeColor;
	protected int fillColor;
	public Shape(Point location, MouseOverAlgorithm mouseOverAlgorithm, int strokeColor, int fillColor, PApplet parent){
		this.location = location;
		this.parent = parent;
		this.mouseOverAlgorithm = mouseOverAlgorithm;
		this.strokeColor = strokeColor;
		this.fillColor = fillColor;
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
	
	public int getFillColor(){
		return fillColor;
	}
	
	public void setStrokeColor(int color){
		this.strokeColor = color;
	}
	
	public Point getCenterPoint(){
		return new Point(0,0);
	}
}
