import java.awt.Point;

import processing.core.PApplet;


public class ToggleButton extends Button implements Togglable {

	private MouseOverAlgorithm mouseOverAlgorithm;
	private boolean isToggled;
	private ToggleBehaviour toggleBehaviour;
	private int shortcut;
	private Canvas parent;
	
	public ToggleButton(Shape shape, ToggleBehaviour behaviour, int shortcut,  Canvas parent) {
		super(shape, parent);
		isToggled = false;
		this.toggleBehaviour = behaviour;
		this.shortcut = shortcut;
		this.parent = parent;
		
	
	}
	
	
	@Override
	public boolean isToggled() {
		return isToggled;
	}
	
	public void onClick(){
		if(!locked) toggle();
	}
	
	
	
	public void toggle(){
		isToggled = !isToggled;
		if(isToggled)shape.setStrokeColor(255);
		else shape.setStrokeColor(0);
		
	}
	
	
	public int getShortcut(){
		return this.shortcut;
	}
	public void update(){
		super.update();
		toggleBehaviour.update();
		if(isToggled && !locked && parent.mouseX < parent.getMenuStartX()){
			toggleBehaviour.onToggle();
		}
	}
	
	
	
	
	
}
