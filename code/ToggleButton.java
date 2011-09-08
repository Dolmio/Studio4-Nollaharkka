import java.awt.Point;

import processing.core.PApplet;


public class ToggleButton extends Button implements Togglable {

	private MouseOverAlgorithm mouseOverAlgorithm;
	
	
	public ToggleButton(Shape shape, Point location, int width, int height, PApplet parent) {
		super(shape, parent);
		this.mouseOverAlgorithm = new MouseOverRectangle(location, width, height, parent);
	}
	
	
	
	@Override
	public boolean isToggled() {
		// TODO Auto-generated method stub
		return false;
	}

}
