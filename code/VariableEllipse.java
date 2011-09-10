
public class VariableEllipse implements ToggleBehaviour {
	
	
	private Canvas parent;
	
	public VariableEllipse(Canvas parent){
		this.parent = parent;
		
	}
	@Override
	public void onToggle() {
		
		if(parent.mousePressed){
			float speed = Math.abs(parent.mouseX - parent.pmouseX) + 
			Math.abs(parent.mouseY - parent.pmouseY);
			parent.stroke(speed);
			parent.ellipse(parent.mouseX, parent.mouseY, speed, speed);
		}
		


	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

}
