import processing.core.*; 
import processing.xml.*; 

import java.applet.*; 
import java.awt.Dimension; 
import java.awt.Frame; 
import java.awt.Point;
import java.awt.event.MouseEvent; 
import java.awt.event.KeyEvent; 
import java.awt.event.FocusEvent; 
import java.awt.Image; 
import java.io.*; 
import java.net.*; 
import java.text.*; 
import java.util.*; 
import java.util.zip.*; 
import java.util.regex.*; 

public class Canvas extends PApplet {

	private static final int MENU_WIDTH = 120;
	private static final int[] FRAME_DIMS = {800,600};	
	
	private int canvasColor;
	private ImageButton button;
	private ToggleButton tbutton;
	private ColorPicker cp;
	private int strokeColor;
	private int fillColor;

	
	public void setup(){ 
		size(FRAME_DIMS[0],FRAME_DIMS[1]);
		background(102, 102, 102);
		smooth();
		PImage b = loadImage("Pen-icon-base.png");
		PImage r = loadImage("Pen-icon-roll.png");
		PImage p = loadImage("Pen-icon-pressed.png");
		Point location = new Point(width/2 - b.width/2, height/2 - b.height/2); 
		int w = b.width;
		int h = b.height;
		this.strokeColor = 255;
		ToggleBehaviour behaviour = new BasicPen(this);
		ToggleBehaviour varEllipse = new VariableEllipse(this);
		Rectangle rec = new Rectangle(location, w, h, this);
		button = new TogglableImageButton(rec, b, r, p, behaviour, this);
		
		
		
		tbutton = new ToggleButton(new Circle(new Point(0,300), this, 100),  varEllipse, KeyEvent.VK_V, this);
		canvasColor = 0;
		initColorPicker();
		drawCanvas();
		drawMenu();
		
	} 
 
	public void drawCanvas(){
		fill(canvasColor);
		rect(0, 0, FRAME_DIMS[0] - MENU_WIDTH, FRAME_DIMS[1]);
	}
	
	public void drawMenu(){
		fill(120);
		rect(FRAME_DIMS[0] - MENU_WIDTH, 0, MENU_WIDTH, FRAME_DIMS[1]);
	}
	
	public void initColorPicker(){
		
		int cp_width = 100;
		int cp_height = 100;
		int cp_x =  FRAME_DIMS[0] - MENU_WIDTH + (MENU_WIDTH - cp_width) / 2;
		PFont font = loadFont("STHeitiTC-Light-48.vlw");
		textFont(font);
		fill(150);
		text("ColorPicker", cp_x, 10);
		
		cp = new ColorPicker(cp_x, 40, 100, 100, 0, this);
	}
	public void draw(){ 
		button.update();
		button.display();
		strokeColor = cp.getSelectedColor();
		cp.display();
		
		tbutton.update();
		tbutton.display();
		
	} 
	
	public void keyPressed(){
		System.out.println();
		if(keyCode == tbutton.getShortcut()){
			tbutton.toggle();
		}
	}
	
	
	public int getStrokeColor(){
		return strokeColor;
	}
	
	static public void main(String args[]) {
	        PApplet.main(new String[] { "--bgcolor=#ECE9D8", "Canvas" });
	}
}
