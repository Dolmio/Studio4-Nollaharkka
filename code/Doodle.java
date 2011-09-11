import processing.core.PApplet;


/*
 * All the credits to   Martin Schneider 
 * Code for this class was copied from
 * http://www.openprocessing.org/visuals/?visualID=6742
 * I have done just minor modifications.

 */


public class Doodle implements ToggleBehaviour {
	
	private Canvas parent;
	private int n, opacity, maxage, rdodge;
	float speed, zoom;
	boolean crayons, soft, dodge;
	float[][] a;
	int[] age;
	float w, h, s;
	int t, c;

	public Doodle(Canvas parent){
		this.parent = parent;
		n = 1000;
		maxage = 20;
		rdodge = 30;
		opacity = 40;
		speed = 0.6f;
		zoom = 0.1f;
		crayons = true;
		soft = true;
		dodge = true;
		a =  new float[n][2]; 
		age = new int[n];
		
	}
	
	@Override
	public void onToggle() {
		
		if(parent.mousePressed){
			parent.colorMode(parent.HSB, parent.TWO_PI, 2, 1);
			int np = n / maxage;
			  for(int i=0; i<np & c<n; i++, c++) newp(c);
			  // draw particle traces
			  for(int i=0; i<c; i++) {
			    age[i]++;
			    float[] p = a[i];
			    if (age[i] > maxage) newp(i);
			    else {
			      float[] f = f(p[0], p[1]);    
			      // opacity based on speed (soft mode) or age (hard mode)
			      int m = maxage/2;
			      float o = soft ? parent.mag(f[0], f[1]) * 2 * opacity : (m - parent.abs(m - age[i])) * opacity/m;
			      // hue based on direction
			      float h =  parent.atan2(f[0], f[1]) + parent.PI;  
			      
			      parent.stroke(h, crayons ? 1 : 0, crayons ? 1 : 0, o);
			      parent.stroke(parent.getSelectedColor());
			      // draw line while updating position
			      parent.line(p[0], p[1], p[0] += s*f[0],  p[1] += s*f[1]);
			      
			    }
			  }
			  parent.colorMode(parent.RGB, 255);
		}

	}
	
	private float[] f(float x, float y) {;
	  return new float[] {
	    parent.noise(t, x * zoom, y * zoom)-.5f,
	    parent.noise(t+1, x * zoom, y * zoom) - .5f
	  };
	}

	
	
	private void newp(int p) {
		  if(dodge) {
		    // particle inside a circle around the mouse position
		    float r = parent.random(rdodge), ang = parent.random(parent.TWO_PI);
		    a[p] = new float[] { parent.mouseX + r * parent.cos(ang), parent.mouseY + r *parent.sin(ang) }; 
		  } else { 
		    // particle anywhere on screen
		    a[p] = new float[] { parent.random(parent.width), parent.random(parent.height) };
		  }
		  age[p] = 0;
		}


	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

}
