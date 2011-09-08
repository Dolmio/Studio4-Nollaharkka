import java.awt.Point;

import processing.core.PApplet;


abstract class Button implements Updateable{
	
	protected PApplet parent;
	private Point location;
	protected int baseColor, higlightColor, currentColor;
	protected boolean locked;
	
	public Button(PApplet parent){
		this.parent = parent;
		baseColor = 255;
		higlightColor = 100;
		currentColor = baseColor;
		locked = false;
		
		
	}
	
	public void update(){
		if(mouseOver()) currentColor = higlightColor;
		else currentColor = baseColor;
		if(pressed()) locked = true;
		else locked = false;
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
	
	protected void onMouseOver(){};
	
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
