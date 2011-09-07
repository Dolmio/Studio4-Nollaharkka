import java.awt.Point;

import processing.core.PApplet;
import processing.core.PImage;


public class ImageButton extends Button implements Displayable {

	private PImage base, roll, down, currentImage;
	private int width, height;
	
	
	public ImageButton(Point location, int width, int height, PImage base, PImage roll, PImage down, PApplet parent) {
		super(parent);
		super.setLocation(location);
		this.width = width;
		this.height = height;
		this.base = base;
		this.roll = roll;
		this.down = down;
		this.currentImage = base;
		
	}
	
	public boolean mouseOver(){
		return overRect(getLocation().x, getLocation().y, width, height);
	}
	
	public void update(){
		super.update();
		if(pressed()) currentImage = down;
		else if(mouseOver()) currentImage = roll;
		else currentImage = base;
	}
	
	private void drawBackground(){
		parent.stroke(0);
		parent.fill(currentColor);
		parent.rect(getLocation().x, getLocation().y, width, height);
	}
	public void display(){
		drawBackground();
		parent.image(currentImage, getLocation().x, getLocation().y, width, height);
		
	}
	public void testMethod2(){};

}
