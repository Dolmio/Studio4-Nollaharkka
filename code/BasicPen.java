import processing.core.PApplet;


public class BasicPen implements ToggleBehaviour {
	
	private Canvas parent;
	private int color;
	public BasicPen(Canvas parent){
		this.parent = parent;
		color = parent.getStrokeColor();
	}
	
	
	@Override
	public void onToggle() {
		parent.stroke(color);
		if(parent.mousePressed){
			parent.line(parent.mouseX, parent.mouseY, parent.pmouseX, parent.pmouseY);
		}
		
	}
	public void updateColor(){
		color = this.parent.getStrokeColor();
	}
	public void setColor(int color){
		this.color = color;
	}
	
	public void update(){
		updateColor();
		System.out.println(color);
	}
}
