
public class VariableShape implements ToggleBehaviour {
	
	
	private Canvas parent;
	private SHAPES shape;
	public VariableShape(SHAPES shape, Canvas parent){
		this.parent = parent;
		this.shape = shape;
	}
	@Override
	public void onToggle() {
		
		if(parent.mousePressed){
			float speed = Math.abs(parent.mouseX - parent.pmouseX) + 
			Math.abs(parent.mouseY - parent.pmouseY);
			parent.fill(parent.getSelectedColor());
			parent.stroke(speed);
			
			if(shape == SHAPES.RECTANGLE){
				parent.rect(parent.mouseX, parent.mouseY, speed, speed);
			}
			else if(shape == SHAPES.CIRCLE){
				parent.ellipse(parent.mouseX, parent.mouseY, speed, speed);
			}
			else if(shape == SHAPES.TRIANGLE){
				float multiplier = speed / 2;
				parent.triangle(parent.mouseX - multiplier, parent.mouseY + multiplier, 
						parent.mouseX, parent.mouseY - multiplier,
						parent.mouseX + multiplier, parent.mouseY + multiplier);
			}
		}
		


	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

}
