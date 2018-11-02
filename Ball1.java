package Java2.JavaSecondQuarter.parametric;

import java.awt.*;
import java.applet.*;
import java.util.*;

public class Ball1 extends PBall
{ 

public Ball1(int d,int sX, int sY )
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
      
    x = (int)(100*Math.pow(Math.cos(counter), 3)+startX);
    
    y = (int)(100*Math.pow(Math.sin(counter), 3)+startY);
   
    counter+=.05;
    
}

}
