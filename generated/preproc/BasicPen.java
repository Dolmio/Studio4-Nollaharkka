import processing.core.PApplet;


public class BasicPen implements ToggleBehaviour {
	
	private PApplet parent;
	
	public BasicPen(PApplet parent){
		this.parent = parent;
	}
	
	
	@Override
	public void onToggle() {
		parent.stroke(255);
		if(parent.mousePressed){
			parent.line(parent.mouseX, parent.mouseY, parent.pmouseX, parent.pmouseY);
		}
		
	}

}
