import processing.core.*; 
import processing.xml.*; 

import java.applet.*; 
import java.awt.Color;
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
	private ColorPicker cp;
	private int selectedColor;
	private int fillColor;
	private PFont font;
	
	
	private List<Button>buttons;
	
	public void setup(){ 
		size(FRAME_DIMS[0],FRAME_DIMS[1]);
		background(102, 102, 102);
		smooth();
		this.buttons = new ArrayList<Button>();
		
		this.font = loadFont("STHeitiTC-Light-12.vlw");
		PImage b = loadImage("Pen-icon-base.png");
		PImage r = loadImage("Pen-icon-roll.png");
		PImage p = loadImage("Pen-icon-pressed.png");
		Point location = new Point(width/2 - b.width/2, height/2 - b.height/2); 
		int w = b.width;
		int h = b.height;
		//button = new TogglableImageButton(rec, b, r, p, behaviour, this);
		this.selectedColor = 0;
		
		canvasColor = 0;
	
		drawCanvas();
		drawMenu();
		initColorPicker();
		initClearButtons();
		initToolButtons();
		drawMenuTexts();
	} 
 
	public void drawCanvas(){
		fill(canvasColor);
		rect(0, 0, FRAME_DIMS[0] - MENU_WIDTH, FRAME_DIMS[1]);
	}
	
	public void drawMenu(){
		fill(120);
		stroke(0);
		rect(FRAME_DIMS[0] - MENU_WIDTH, 0, MENU_WIDTH, FRAME_DIMS[1]);
		drawMenuTexts();
	}
	
	private void initColorPicker(){
		
		int cp_width = 100;
		int cp_height = 100;
		int cp_x =  FRAME_DIMS[0] - MENU_WIDTH + (MENU_WIDTH - cp_width) / 2;
		fill(0);
		
		
		cp = new ColorPicker(cp_x, 40, 100, 100, 0, this);
	}
	
	private void initToolButtons(){
		
		
		ToggleBehaviour behaviour = new VariableShape(SHAPES.TRIANGLE,this);
		Rectangle rec = new Rectangle(new Point(getMenuStartX() + 5,245), 30, 30, 0 ,60, this);
		ToggleButton button1 = new ToggleButton(rec, behaviour, KeyEvent.VK_T, this);
		button1.setText("T");
		buttons.add(button1);
		
		ToggleBehaviour behaviour2 = new VariableShape(SHAPES.CIRCLE,this);
		Rectangle rec2 = new Rectangle(new Point(getMenuStartX() + 40 ,245), 30, 30, 0 ,60, this);
		ToggleButton button2 = new ToggleButton(rec2, behaviour2, KeyEvent.VK_C, this);
		button2.setText("C");
		buttons.add(button2);
		
		ToggleBehaviour behaviour3 = new VariableShape(SHAPES.RECTANGLE,this);
		Rectangle rec3 = new Rectangle(new Point(getMenuStartX() + 75 ,245), 30, 30, 0 ,60, this);
		ToggleButton button3 = new ToggleButton(rec3, behaviour3, KeyEvent.VK_R, this);
		button3.setText("R");
		buttons.add(button3);
		
		ToggleBehaviour behaviour4 = new Pulses(this);
		Rectangle rec4 = new Rectangle(new Point(getMenuStartX() + 5 ,280), 30, 30, 0 ,60, this);
		ToggleButton button4 = new ToggleButton(rec4, behaviour4, KeyEvent.VK_P, this);
		button4.setText("P");
		buttons.add(button4);
		
		
	}
	
	private void drawMenuTexts(){
		fill(20);
		textFont(font);
		textAlign(CENTER);
		text("Colorpicker", getMenuStartX() + MENU_WIDTH / 2, 20);
		text("Clear", getMenuStartX() + MENU_WIDTH / 2 , 165);
		text("Tools" ,getMenuStartX() + MENU_WIDTH / 2 , 230);
	}
	
	
	public int getMenuStartX(){
		return FRAME_DIMS[0] - MENU_WIDTH;
	}
	
	private void initClearButtons(){
		
		
		ClearButton button1 = new ClearButton(new Rectangle(
		new Point( getMenuStartX() + MENU_WIDTH / 2 - 15, 170), 
												30,30, 0, fillColor, this), this);
		
		buttons.add(button1);
		
	}
	
	
	public void draw(){ 
		drawMenu();
		
		selectedColor = cp.getSelectedColor();
		cp.display();
		
		for(Button b: buttons){
			b.update();
			b.display();
			
		}
		
		
	} 
	
	public void keyPressed(){
		for(Button b: buttons){
			if(b instanceof ToggleButton){
				ToggleButton button = (ToggleButton)b;
				if(keyCode == button.getShortcut()){
					button.toggle();
				}
			}
		}
		
	}
	
	
	public int getSelectedColor(){
		return selectedColor;
	}
	
	public int getMenuWidth(){
		return Canvas.MENU_WIDTH;
	}
	
	public int getFrameWidth(){
		return FRAME_DIMS[0];
	}
	
	public int getFrameHeight(){
		return FRAME_DIMS[1];
	}
	
	static public void main(String args[]) {
	        PApplet.main(new String[] { "--bgcolor=#ECE9D8", "Canvas" });
	}
}
