import java.awt.Point;

import processing.core.PApplet;


public class ToggleButton extends Button implements Togglable {

	private MouseOverAlgorithm mouseOverAlgorithm;
	private boolean isToggled;
	private ToggleBehaviour toggleBehaviour;
	private int shortcut;
	private int lastPressedKey;
	
	public ToggleButton(Shape shape, ToggleBehaviour behaviour, int shortcut,  Canvas parent) {
		super(shape, parent);
		isToggled = false;
		this.toggleBehaviour = behaviour;
		this.shortcut = shortcut;
		lastPressedKey = 0;
	
	}
	
	
	@Override
	public boolean isToggled() {
		return isToggled;
	}
	
	public void onClick(){
		if(!locked) toggle();
	}
	
	private void updateLastPressedKey(){
		if(parent.keyCode != 0) lastPressedKey = parent.keyCode;
	}
	
	public void toggle(){
		isToggled = !isToggled;
		
	}
	
	
	public int getShortcut(){
		return this.shortcut;
	}
	public void update(){
		super.update();
		toggleBehaviour.update();
		if(isToggled && !locked)toggleBehaviour.onToggle();
	}
	
	
	
}
