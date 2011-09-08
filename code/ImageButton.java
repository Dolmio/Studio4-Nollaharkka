import java.awt.Point;

import processing.core.PApplet;
import processing.core.PImage;


public class ImageButton extends Button implements Displayable {

	private PImage base, roll, down, currentImage;
	private int width, height;
	private MouseOverAlgorithm mouseOverAlgorithm;
	
	public ImageButton(Shape shape, Point location, int width, int height, PImage base, PImage roll, PImage down, PApplet parent) {
		super(shape, parent);
		super.setLocation(location);
		this.width = width;
		this.height = height;
		this.base = base;
		this.roll = roll;
		this.down = down;
		this.currentImage = base;
		this.mouseOverAlgorithm = new MouseOverRectangle(location, width, height, parent);
	}
	
	public boolean mouseOver(){
		return mouseOverAlgorithm.MouseOver();
	}
	
	protected void onClick(){
		currentImage = down;
	}
	
	protected void onMouseOver(){
		currentImage = roll;
	}
	
	public void update(){
		if(pressed()){
			onClick();
		}
		else if(mouseOver()) onMouseOver();
		else currentImage = base;
		super.update();
	}
	
	private void drawBackground(){
		parent.stroke(0);
		parent.fill(currentColor);
		parent.rect(getLocation().x, getLocation().y, width, height);
	}
	public void display(){
		super.display();
		//drawBackground();
		parent.image(currentImage, getLocation().x, getLocation().y, width, height);
		
	}
	
	
}
