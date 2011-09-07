import java.awt.Point;

import processing.core.PApplet;


abstract class Button implements Updateable, Displayable {
	
	private PApplet parent;
	private Point location;
	private boolean mouseOver;
	private boolean pressed;
	
	public Button(PApplet parent){
		this.parent = parent;
		mouseOver = false;
		pressed = false;
		
	}
	protected PApplet getParent(){
		return parent;
	}
	
	public void display(){};
	public void update(){};
	
	public Point getLocation(){
		return location;
	}
	
	public void setLocation(Point p){
		location = p;
	}
	
	public void pressed(){
		pressed = (mouseOver && (parent.mousePressed));
	}
	
	protected boolean overRect(int x, int y, int width, int height){
		return (parent.mouseX >= x && parent.mouseX <= x+width && 
			      parent.mouseY >= y && parent.mouseY <= y+height);
	}
	
}
