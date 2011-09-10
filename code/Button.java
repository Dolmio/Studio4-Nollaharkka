import java.awt.Point;

import processing.core.PApplet;


abstract class Button implements Updateable{
	
	protected PApplet parent;
	private Shape shape;
	private Point location;
	protected int baseColor, higlightColor, currentColor;
	protected boolean locked;

	public Button(Shape shape, PApplet parent){
		this.shape = shape;
		this.parent = parent;
		this.location = shape.getLocation();
		baseColor = 255;
		higlightColor = 100;
		currentColor = baseColor;
		locked = false;
		
		
	}
	
	public void update(){
		if(pressed()){
			onClick();
			locked = true;
		}
		else {
			locked = false;
		
			if(mouseOver()){
				onMouseOver();
				
			}
			else onMouseNotAround();
		}
		
		//if(parent.keyPressed) locked = true;		
		
	};
	
	public Point getLocation(){
		return location;
	}
	
	public void setLocation(Point p){
		location = p;
	}
	
	public boolean pressed(){
		return (mouseOver() && (parent.mousePressed));
	}
	
	protected void onClick(){
		
	};
	
	protected void onMouseOver(){
		currentColor = higlightColor;
	}
	
	protected void onMouseNotAround(){
		currentColor = baseColor;
	}
	
	
	public boolean mouseOver(){
		return shape.mouseOver();
	}
	
	public void display(){
		shape.draw();
	}
	
}
