import java.awt.Point;

import processing.core.PApplet;
import processing.core.PFont;


abstract class Button implements Updateable, Displayable{
	
	protected PApplet parent;
	protected Shape shape;
	private Point location;
	protected int baseColor, higlightColor, currentColor;
	protected boolean locked;
	protected String text;
	private PFont font;
	public Button(Shape shape, PApplet parent){
		this.shape = shape;
		this.parent = parent;
		this.location = shape.getLocation();
		baseColor = 255;
		higlightColor = 100;
		currentColor = baseColor;
		locked = false;
		this.font = parent.loadFont("STHeitiTC-Light-20.vlw");
		
		
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
	
	private void drawText(){
		parent.fill(255);
		parent.textFont(font);
		parent.textSize(20);
		parent.textAlign(parent.CENTER, parent.CENTER);
		parent.text(text, shape.getCenterPoint().x, shape.getCenterPoint().y);
	}
	public void display(){
		shape.draw();
		if(text != null && font != null){
			drawText();
		}
		
	}
	
	public void setText(String text){
		this.text = text;
		
	}
	
}
