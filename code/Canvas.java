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

private ImageButton button;
private ColorPicker cp;
private int strokeColor;
private int fillColor;
	
public void setup(){ 
	size(500,500);
	background(102, 102, 102);
	PImage b = loadImage("Pen-icon-base.png");
	PImage r = loadImage("Pen-icon-roll.png");
	PImage p = loadImage("Pen-icon-pressed.png");
	Point location = new Point(width/2 - b.width/2, height/2 - b.height/2); 
	int w = b.width;
	int h = b.height;
	this.strokeColor = 255;
	ToggleBehaviour behaviour = new BasicPen(this);
	button = new TogglableImageButton(location, w, h, b, r, p, behaviour, this);
	
	cp = new ColorPicker(20,20, 100, 100, 0, this);
} 
 
public void draw(){ 
	button.update();
	button.display();
	strokeColor = cp.getSelectedColor();
	cp.display();
	
} 

public int getStrokeColor(){
	return strokeColor;
}
    static public void main(String args[]) {
        PApplet.main(new String[] { "--bgcolor=#ECE9D8", "Canvas" });
    }
}
