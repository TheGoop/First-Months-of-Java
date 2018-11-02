package Java2.JavaSecondQuarter;

import java.awt.*;
import java.applet.*;
import java.util.*;

public abstract class Polygon
{
	 int x,y,ystep,xstep,diameter,cX,cY,radius;
Graphics g;
Random D = new Random();

public Polygon(int c, int r, int d, int xs, int ys)
{
x = c;
y = r;
ystep = xs;
xstep = ys;
diameter = d;
radius=diameter/2;
cX = c + radius;
cY = r + radius;
}

public abstract void drawPoly();


public abstract void movePoly();




public void paint(Graphics gr)
{
g = gr;
drawPoly();
}
}

