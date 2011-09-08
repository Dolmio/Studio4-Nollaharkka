import processing.core.PApplet;
import processing.core.PImage;


public class ColorPicker 
{
  private int x, y, w, h, c;
  PImage cpImage;
  PApplet parent;
	
  public ColorPicker ( int x, int y, int w, int h, int c, PApplet parent)
  {
    this.x = x;
    this.y = y;
    this.w = w;
    this.h = h;
    this.c = c;
    this.parent = parent;
		
    cpImage = new PImage( w, h );
		
    init();
  }
	
  private void init ()
  {
    // draw color.
    int cw = w - 60;
    for( int i=0; i<cw; i++ ) 
    {
      float nColorPercent = i / (float)cw;
      float rad = (-360 * nColorPercent) * (parent.PI / 180);
      int nR = (int)(parent.cos(rad) * 127 + 128) << 16;
      int nG = (int)(parent.cos(rad + 2 * parent.PI / 3) * 127 + 128) << 8;
      int nB = (int)(Math.cos(rad + 4 * parent.PI / 3) * 127 + 128);
      int nColor = nR | nG | nB;
			
      setGradient( i, 0, 1, h/2, 0xFFFFFF, nColor );
      setGradient( i, (h/2), 1, h/2, nColor, 0x000000 );
    }
		
    // draw black/white.
    drawRect( cw, 0,   30, h/2, 0xFFFFFF );
    drawRect( cw, h/2, 30, h/2, 0 );
		
    // draw grey scale.
    for( int j=0; j<h; j++ )
    {
      int g = 255 - (int)(j/(float)(h-1) * 255 );
      drawRect( w-30, j, 30, 1, parent.color( g, g, g ) );
    }
  }

  private void setGradient(int x, int y, float w, float h, int c1, int c2 )
  {
    float deltaR = parent.red(c2) - parent.red(c1);
    float deltaG = parent.green(c2) - parent.green(c1);
    float deltaB = parent.blue(c2) - parent.blue(c1);

    for (int j = y; j<(y+h); j++)
    {
      int c = parent.color( parent.red(c1)+(j-y)*(deltaR/h), parent.green(c1)+(j-y)*(deltaG/h), parent.blue(c1)+(j-y)*(deltaB/h) );
      cpImage.set( x, j, c );
    }
  }
	
  private void drawRect( int rx, int ry, int rw, int rh, int rc )
  {
    for(int i=rx; i<rx+rw; i++) 
    {
      for(int j=ry; j<ry+rh; j++) 
      {
        cpImage.set( i, j, rc );
      }
    }
  }
	
  public void display ()
  {
    parent.image( cpImage, x, y );
    if( parent.mousePressed &&
	parent.mouseX >= x && 
	parent.mouseX < x + w &&
	parent.mouseY >= y &&
	parent.mouseY < y + h )
    {
      c = parent.get( parent.mouseX, parent.mouseY );
      
    }
    parent.fill( c );
    parent.rect( x, y+h+10, 20, 20 );
  }
  
  public int getSelectedColor(){
	  return c;
  }
}
