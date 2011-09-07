import java.awt.Point;

import processing.core.PApplet;


abstract class Button implements Updateable{
	
	protected PApplet parent;
	private Point location;
	protected int baseColor, higlightColor, currentColor;
	
	public Button(PApplet parent){
		this.parent = parent;
		baseColor = 255;
		higlightColor = 100;
		currentColor = baseColor;
		
		
	}
	
	public void update(){
		if(mouseOver()) currentColor = higlightColor;
		else currentColor = baseColor;
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
	
	protected boolean overRect(int x, int y, int width, int height){
		return (parent.mouseX >= x && parent.mouseX <= x+width && 
			      parent.mouseY >= y && parent.mouseY <= y+height);
	}
	
	//overridaa alaluokassa
	public boolean mouseOver(){
		return false;
	}
	
	public boolean testMethod(){
		return false;
	}
	
}
