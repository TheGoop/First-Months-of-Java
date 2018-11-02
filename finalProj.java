package Java2.JavaThirdQuarter.Final;

public class finalProj extends DinoList
{
    DinoList J = new DinoList();
    public  void main()
    {
       
        J.add(new Integer(3));
        J.add(new Integer(5));
        J.add(new Integer(7));
        J.add(new Integer(3));
        J.add(new Integer(30));
   
        J.printAll();  
        System.out.println("END");
        
       
        //write the code to test your Dino list
        //Add  5 more nodes to J valued 2,4,6,8,10
        J.add(new Integer(2));
        J.add(new Integer(4));
        J.add(new Integer(6));
        J.add(new Integer(8));
        J.add(new Integer(10));
        
        // Print the list
        J.printAll();
        System.out.println("END");
        
        // add a 12 node to the end
        J.add(new Integer(12));
        
        // Print the list
        J.printAll();
        System.out.println("END");
        
        // insert a 7 node to index 3
        J.add(new Integer(7), 3);
        
        // Print the list
        J.printAll();
        System.out.println("END");
        
        // delete the 2nd node 
        J.delete(2);
        
        // Print the list
        J.printAll();
        System.out.println("END");
        
        // try to exceed the bounds of the list to test your error handling.
        J.add(new Integer(40),40);
        
        
        System.out.println("The sum is " + J.sum());
        
        //System.out.println("BLAH " + J.speciala());
           
         
     }  
}
