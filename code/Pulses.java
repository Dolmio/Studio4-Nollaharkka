
public class Pulses implements ToggleBehaviour {
	
	private Canvas parent;
	private int color;
	private float angle;
	
	public Pulses(Canvas parent){
		this.parent = parent;
		color = parent.getSelectedColor();
		this.angle = 0;
	}
	
	@Override
	public void onToggle() {
		
		if(parent.mousePressed){
			angle += 10;
		    float val = (float) (parent.cos(parent.radians(angle)) * 6.0);
		    for (int a = 0; a < 360; a += 75) {
		      float xoff = parent.cos(parent.radians(a)) * val;
		      float yoff = parent.sin(parent.radians(a)) * val;
		      parent.fill(color);
		      parent.ellipse(parent.mouseX + xoff, parent.mouseY + yoff, val, val);
		    }
		    parent.fill(2);
		    parent.ellipse(parent.mouseX, parent.mouseY, 2, 2);
		}
	}

	@Override
	public void update() {
		color = parent.getSelectedColor();

	}

}
