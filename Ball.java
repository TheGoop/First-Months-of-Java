package Java2.inheritance;

import java.awt.*;
import java.applet.*;
import java.util.*;

public class Ball extends PBall
{ 

public Ball(int d,int sX, int sY )
{ 
super(d,sX,sY);
}


public void moveBall()
{  
   // parametric functions express x and y in terms 
   // of a third variable. In this case the third variable is counter.
   // the code for a parametrically defined circle with 
   // radius r and center 
   // (h,k) is is x = r cos(t) + h,  y = r sin(t) + k 
   
      
    x = (int)(100*Math.cos(counter)+startX);
    
    y = (int)(100*Math.sin(counter)+startY);
   
    counter+=.05;
    
}

}


