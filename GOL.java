package Java2.JavaThirdQuarter;

import java.awt.*;
import java.applet.*;
import java.util.*;
public class GOL extends Applet implements Runnable
{
  
        Thread runner;
        Image Buffer;
        Graphics gBuffer;
        LifeBall [][] Board;
 
   
   public void init()
    
    { 
     
        // create a two D array of LifeBall references, called Board.  Load it with  LifeBalls all alive. 
        //  later initialize some as dead to test your grid 
            Board = new LifeBall [100][100];
            for(int r=0; r<Board.length;r++)
            {
                for(int c=0; c<Board[r].length;c++)
                {
                    Board[r][c]=new LifeBall(false,r*5,c*5);
               }
            }
            placeOcilater(10,10);
            placeOcilater(70,70);
            placePentadecathlon(20,20);
            placePentadecathlon(60,60);
            placePentadecathlon(20,60);
            placePentadecathlon(80,20);
            gliderGun(10,10);
            
            Buffer=createImage(size().width,size().height);// change to his to avoid compilation errormessage 
                  //  Buffer=createImage(this.getWidth(),this.getHeight() );
                                    gBuffer=Buffer.getGraphics();
                                       //  write two methods that would allow these calls:
                       //  placeGlider(Board, 40, 35 );
       
      }
   
   public void start()
    { if (runner == null)
        {
            runner = new Thread (this);
            runner.start();
        }
    }
   public void run()
    { int count=0;
        while(true)
       {   
           try {runner.sleep(150);}
            catch (Exception e) { }
            count++;

            if(count%30==0)
            {
                placeGlider(40,40);
                placeGlider(60,20);
            }
                       
            gBuffer.setColor(Color.cyan);
           gBuffer.fillRect(0,0,this.getWidth(),this.getHeight() );
           

          
          
           GOL(); 
           displayBoard();
          cleanUp();
          
            repaint();  
        }
        }
        
     public void displayBoard()
        {
                // displays all LifeBalls to screen in a grid form
                // mark individual ball as dead to test your grid - don’t assume it works.
                for(int r=0; r<Board.length; r++)
                {
                    for(int c=0; c<Board[r].length; c++)
                    {
                        Board[r][c].paint(gBuffer);
            }
        }
        }

            public void GOL()
            {
                /* loop through Board applying GOL rules and marking all LifeBalls as markedForDeath or markedForResection or nothing
                 * GOL rules:
              For a space that is 'populated':
              Each cell with one or no neighbors dies, as if by solitude.
              Each cell with four or more neighbors dies, as if by overpopulation.
              Each cell with two or three neighbors survives.
              For a space that is 'empty' or 'unpopulated'
              Each cell with exactly three neighbors becomes populated.
              */
             // write and call:  public   ArrayList   getNeighbors( LifeBall[][] Z, int r, int c   )
             int counter=0;
             ArrayList C;
             for(int r=0; r<Board.length; r++)
                {
                    for(int c=0; c<Board[r].length; c++)
                    {
                       C= getNeighbors( r, c );
                        counter = countLive(C);
                        if(Board[r][c].getAlive()==true)
                        {
                            if((counter<=1)||(counter>=4))
                            {
                                Board[r][c].markForDeath();
                            }
                            if((counter==2)||(counter==3))
                            {
                                Board[r][c].markForResurection();
                            }
                        }
                        if(Board[r][c].getAlive()==false)
                        {
                            if(counter==3)
                            {
                                Board[r][c].markForResurection();
                            }
                        }
            }
        }



 }

   public ArrayList getNeighbors( int r, int c )
      { 
          // returns an ArrayList with references to all valid LifeBalls around B[r][c]
          // more code needs to be added for getNeighbors()  to work as intended.
          ArrayList N= new ArrayList();
          for(int i=r-1; i<=r+1; i++)
                {
                    for(int j=c-1; j<=c+1; j++)
                    {
                        if(!((i==r)&&(j==c)))
                        {
                            if((j>=0)&&(j<=99))
                            {
                                if((i>=0)&&(i<=99))
                                {
                                N.add(Board[i][j]);
                            }
                            }
                        }
                    }
                }
                return N;
   }

  public int countDead( ArrayList Z )
  {
                // count and return the number of dead neighbors
                int count =0;
                return count;
   }

  public int countLive( ArrayList Z )
  {
                // count and return the number of live neighbors
                int count =0;
                LifeBall temp;
                for(int i=0;i<Z.size();i++)
                {
                    temp=(LifeBall)Z.get(i);
                    if(temp.getAlive()==true)
                    {
                        count++;
                    }
                }
                return count;
  }
            public void cleanUp()
            {
                // Loop through Board and kill or resurrect each ball any LifeBalls marked for action
                // Don’t forget to reset them to “unmarked”
                for(int r=0; r<Board.length; r++)
                {
                    for(int c=0; c<Board[r].length; c++)
                    {
                        if(Board[r][c].getMarkedForDeath()==true)
                        {
                            Board[r][c].kill();
                        }
                        if(Board[r][c].getMarkedForResurrection()==true)
                        { 
                            Board[r][c].resurrect();
                        }
                        Board[r][c].unmark();
            }
        }
    }
    
    public void placePentadecathlon(int r, int c)
    {
        if((r>=0)&&(r<=99))
          {
           if((c>=0)&&(c<=99))
            {
              Board[r][c].resurrect();
              Board[r][c+1].resurrect();
              Board[r+1][c+2].resurrect();
              Board[r-1][c+2].resurrect();
              Board[r][c+3].resurrect();
              Board[r][c+4].resurrect();
              Board[r][c+5].resurrect();
              Board[r][c+6].resurrect();
              Board[r+1][c+7].resurrect();
              Board[r-1][c+7].resurrect();
              Board[r][c+8].resurrect();
              Board[r][c+9].resurrect();
           }
         }
    }
    public void placeGlider(int r, int c)
    {
        if((r>=0)&&(r<=99))
          {
           if((c>=0)&&(c<=99))
            {
              Board[r][c].resurrect();
              Board[r][c+1].resurrect();
              Board[r+2][c+1].resurrect();
              Board[r+1][c+2].resurrect();
              Board[r][c+2].resurrect();
           }
         }
    }
    public void placeOcilater(int r,int c)
    {
        if((r>=0)&&(r<=99))
          {
           if((c>=0)&&(c<=99))
            {
              Board[r][c].resurrect();
              Board[r][c+1].resurrect();
              Board[r][c+2].resurrect();
           }
         }
    }
    public void gliderGun(int r, int c)
    {
        if((r>=0)&&(r<=99))
          {
           if((c>=0)&&(c<=99))
            {
              Board[r][c].resurrect();
              Board[r][c+1].resurrect();
              Board[r+1][c].resurrect();
              Board[r+1][c+1].resurrect();
              
              Board[r][c+10].resurrect();
              Board[r+1][c+10].resurrect();
              Board[r-1][c+10].resurrect();
              Board[r-2][c+11].resurrect();
              Board[r-3][c+12].resurrect();
              Board[r-3][c+13].resurrect();
              Board[r+2][c+11].resurrect();
              Board[r+3][c+12].resurrect();
              Board[r+3][c+13].resurrect();
              
              Board[r][c+14].resurrect();
              Board[r+2][c+15].resurrect();
              Board[r-2][c+15].resurrect();
              Board[r][c+17].resurrect();
              Board[r-1][c+17].resurrect();
              Board[r][c+18].resurrect();
           }
         }
    }
    public void update(Graphics g)
    {
        paint(g);
    }
  
    public void paint(Graphics g)
    {
        g.drawImage (Buffer,0,0, this);
    }

}
