package Java2.inheritance;

import java.awt.*;
import java.applet.*;
import java.util.*;

public abstract class PBall

{ private int diameter,cX,cY,radius;
  public int x,y, startX, startY;
  public double counter;
  private Random D = new Random();
  
  Graphics g;
  

public PBall(int d,int sX, int sY )
{  diameter = d;
   radius=diameter/2;
   cX = x + radius;
   cY = y + radius;
  counter = 0;
   startX = sX;
   startY = sY;
   x= sX;
   y = sY;
  }

public abstract void moveBall(); 
  
  
public void drawBall()
{  g.setColor(Color.red);
   g.fillOval(x,y,diameter,diameter);}   


public void paint(Graphics gr)
{   g = gr;
    drawBall();}

public int getRadius()
{  return radius;}

public double getCounter()
{   return counter;}

public int getcX()
{ 
cX = x + radius;
return cX;
}

public int getcY()
{  
cY = y + radius;
return cY;
}

public void flipXstep()
{  counter *= -1;}


public void changeX(int X)
{
x = X;
}

public void changeY(int Y)
{
y = Y;
}

}
