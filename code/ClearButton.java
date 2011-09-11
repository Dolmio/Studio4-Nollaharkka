import java.awt.Color;

import processing.core.PApplet;


public class ClearButton extends Button {
	
	private int width, height;
	private MouseOverAlgorithm mouseOverAlgorithm;
	private Canvas parent;
	private int fillColor;
	private Rectangle rec;
	
	public ClearButton(Rectangle rec, Canvas parent) {
		super(rec, parent);
		this.parent = parent;
		this.width = rec.getWidth();
		this.height = rec.getHeight();
		this.mouseOverAlgorithm = new MouseOverRectangle(rec.getLocation(), width, height, parent);
		this.fillColor = rec.getFillColor();
		this.rec = rec;
	}
	
	
	public void update(){
		super.update();
		this.fillColor = parent.getSelectedColor();
	}
	
	protected void onClick(){
		System.out.println(String.format("%d %d", parent.screenWidth-parent.getMenuWidth(), parent.screenHeight));
		parent.fill(fillColor);
		parent.rect(0,0, parent.getFrameWidth() - parent.getMenuWidth(), parent.getFrameHeight());
	}
	
	public void display(){
		parent.stroke(shape.strokeColor);
		parent.fill(fillColor);
		parent.rect(rec.getLocation().x, rec.getLocation().y, rec.getWidth(), rec.getHeight());
	}
}
