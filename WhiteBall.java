package Java2.JavaSecondQuarter;

import java.awt.*;
import java.applet.*;
import java.util.*;

/**
 * Write a description of class Reedball1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WhiteBall extends Polygon
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class Reedball1
     */
    public WhiteBall(int c, int r, int d, int xs, int ys)
    {
     super(c,r,d, xs, ys);
    }

    
public void drawPoly()
{ 
g.setColor(Color.white);
g.fillOval(x,y,diameter,diameter);
}

public void movePoly()

{
  x = x + xstep;
 y = y + ystep;
 cX = x + radius;
 cY = y + radius;

if (( cX >(490-diameter/2))||( cX < ( 4 + diameter/2) ))
    {
      if (xstep >= 0)
      {   x -= 5;
          xstep = -1*(D.nextInt(3)+1);
       }
      else
       {    x += 5;
           xstep =  1*(D.nextInt(3)+1);
       }
    }   

if (( cY >(499-diameter/2))||( cY < ( 1 + diameter/2) ))
  {
   ystep *= -1;
 }
}
}