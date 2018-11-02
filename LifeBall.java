package Java2.JavaThirdQuarter;

import java.awt.*;
import java.applet.*;
import java.util.*;
public class LifeBall
{


 private int x,y,diameter;
 private Graphics g;
 private  Random D = new Random();

 // new instance variables
 private  boolean alive; 
 private boolean markedForDeath; 
 private boolean  markedForResurrection;


 
public LifeBall( boolean a, int X, int Y  )
{


x =  X;
y =  Y;
diameter = 5;
alive = a;
markedForDeath = false;
markedForResurrection = false;


}


          
public void drawBall(Graphics g)
{
    if( alive )
    g.setColor(Color.white);
   
    if(!alive)
    g.setColor(Color.blue); 
           
    g.fillOval(x,y,diameter,diameter);  // if you want squares  g.fillRect(x,y,diameter,diameter);
}









// new accessors


public boolean getAlive()
{
return alive;
}


public boolean getMarkedForDeath()
{
return markedForDeath;
}


public boolean getMarkedForResurrection()
{
return markedForResurrection;
}










// modifiers


public  void markForDeath()
{
markedForDeath = true;
}


public  void markForResurection()
{
markedForResurrection = true;
}


public void unmark()
{
markedForDeath = false;
markedForResurrection = false;
}



public void paint(Graphics gr)
{
    g = gr;
    drawBall(g);
}



public void kill()
{
alive = false;
}




public void resurrect()
{
alive = true;
}

}// class Ball

