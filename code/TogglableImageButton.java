import java.awt.Point;

import processing.core.PApplet;
import processing.core.PImage;


public class TogglableImageButton extends ImageButton implements Togglable {

	private ToggleBehaviour toggleBehaviour;
	private boolean isToggled;
	
	public TogglableImageButton(Rectangle rec, 
			PImage base, PImage roll, PImage down, ToggleBehaviour behaviour, PApplet parent) {
		super(rec, base, roll, down, parent);
		isToggled = false;
		this.toggleBehaviour = behaviour;
	}

	@Override
	public boolean isToggled() {
		return isToggled;
	}

	public void toggle(){
		isToggled = !isToggled;
		locked = false;
	}
	
	public void onClick(){
		super.onClick();
		//System.out.println("onClick: " + isToggled);
		if(!locked)isToggled = !isToggled;
	}
	
	
	public void update(){
		super.update();
		toggleBehaviour.update();
		if(isToggled && !locked)toggleBehaviour.onToggle();
	}
}
