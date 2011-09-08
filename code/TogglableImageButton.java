import java.awt.Point;

import processing.core.PApplet;
import processing.core.PImage;


public class TogglableImageButton extends ImageButton implements Togglable {

	private ToggleBehaviour toggleBehaviour;
	private boolean isToggled;
	
	public TogglableImageButton(Point location, int width, int height,
			PImage base, PImage roll, PImage down, ToggleBehaviour behaviour, PApplet parent) {
		super(location, width, height, base, roll, down, parent);
		isToggled = false;
		this.toggleBehaviour = behaviour;
	}

	@Override
	public boolean isToggled() {
		return isToggled;
	}

	
	
	public void onClick(){
		super.onClick();
		//System.out.println("onClick: " + isToggled);
		if(isToggled) isToggled = false;
		else(isToggled) = true;
	}
	
	
	public void update(){
		super.update();
		toggleBehaviour.update();
		if(isToggled && !locked)toggleBehaviour.onToggle();
	}
}
