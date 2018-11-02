package Java2.JavaThirdQuarter;
import java.util.*;

public class bank
{
    Scanner scan = new Scanner(System.in);
    ArrayList a = new ArrayList();
    Random gen = new Random();
    public void main()
    { 
        // create an arraylist populate it with 50 customers
        // write a menu driven program that will sort the array list 
        // and SOP it by:        Menu
        //                    1) Sort by Balance
        //                    2) Sort by ID Number
        //                    3) Sort by Last Name
        //         4) Search by ID number (use a binary search)
        
        String[] s = new String[8];
        int j = 0;
        boolean check = true;
        
        
        for (int i = 0; i < 10; i++)
        {
            a.add(new Customer(10.5*gen.nextInt(10), "Gupta", i));
        }
        
        for (int i = 10; i < 15; i++)
        {
            a.add(new Customer(10.5*gen.nextInt(10), "Ha", i));
        }
        
        for (int i = 15; i < 20; i++)
        {
            a.add(new Customer(10.5*gen.nextInt(10), "McCarthy", i));
        }
        /**
        for (int i = 30; i < 40; i++)
        {
            a.add(new customer(10.5*gen.nextInt(10), "Whitney", i));
        }
        
        for (int i = 40; i < 50; i++)
        {
            a.add(new customer(10.5*gen.nextInt(10), "Hamblin", i));
        }
       */
        while (check = true)
        {
            System.out.println("Pick a choice");
            int choice = scan.nextInt();
            if (choice == 1)
            {
                sortBal();
                print();
            }
            else if (choice == 2)
            {
                sortID();
                print();
            }
            else if (choice == 3)
            {
                sortLast();
                print();
            }
            
            else if (choice == 4)
            {
                System.out.println("What number are you looking for");
                int id = scan.nextInt();
                searchID(id);
            }
            
            else
            {
                break;
            }
        }
    }
    
    public void sortBal()
    {
        Customer temp, temp1, temp2;
        double bal, bal1, bal2;
        int index = 0;
        for (int i = 0; i < a.size()-1; i++)
        {
            temp = (Customer)a.get(i); //gets object of instance
            bal = temp.getBalance();   //bal of object
            temp1 = (Customer)a.get(i+1); //gets object ahead of instance
            bal1 = temp1.getBalance(); //bal of object ahead
            if (bal > bal1)  //if bal ahead is smaller than at instance
            {
                for (int j = i; j >= 0; j--) //works backward from current spot till 0
                {
                    temp2 = (Customer)a.get(j); //gets object behind ahead object
                    bal2 = temp2.getBalance();  //gets bal of object behind ahead object
                    if (bal1 < bal2)
                    {
                        index = j;
                    }
                }
                a.add(index, a.remove(i+1));
            }
        }
    }
    
    
    public void sortID()
    {
        Customer temp, temp1, temp2;
        int id, id1, id2;
        int index = 0;
        for (int i = 0; i < a.size()-1; i++)
        {
            temp = (Customer)a.get(i); //gets object of instance
            id = temp.getNumber();   //id of object
            temp1 = (Customer)a.get(i+1); //gets object ahead of instance
            id1 = temp1.getNumber(); //id of object ahead
            if (id > id1)  //if id ahead is smaller than at instance
            {
                for (int j = i; j >= 0; j--) //works backward from current spot till 0
                {
                    temp2 = (Customer)a.get(j); //gets object behind ahead object
                    id2 = temp2.getNumber();  //gets id of object behind ahead object
                    if (id1 < id2)
                    {
                        index = j;
                    }
                }
                a.add(index, a.remove(i+1));
            }
        }
    }
    
    public void sortLast()
    {
        Customer temp, temp1, temp2;
        String name, name1, name2;
        int index = 0;
        for (int i = 0; i < a.size()-1; i++)
        {
            temp = (Customer)a.get(i); //gets object of instance
            name = temp.getName();   //name of object
            temp1 = (Customer)a.get(i+1); //gets object ahead of instance
            name1 = temp1.getName(); //name of object ahead
            if (name.compareTo(name1) > 0)  //if name ahead is before than at instance
            {
                for (int j = i; j >= 0; j--) //works backward from current spot till 0
                {
                    temp2 = (Customer)a.get(j); //gets object behind ahead object
                    name2 = temp2.getName();  //gets name of object behind ahead object
                    if (name1.compareTo(name2) < 0)
                    {
                        index = j;
                    }
                }
                a.add(index, a.remove(i+1));
            }
        }
        
    }
    
    public void searchID(int ID)
    {
        //System.out.println("BottomTest");
        boolean found = false;
        int g = a.size()/2; //middle range index
        int b = 0; //bottom range index
        int t = a.size()-1; //top range index
        int check = 0; //checks if found
        while (found = true) //until found = true
        {
            Customer bottom = (Customer)a.get(b); //gets bottom index object
            Customer top = (Customer)a.get(t); //gets top index object
            Customer guess = (Customer)a.get(g); //gets the middle index objects, which is what it guesses
            
            if (bottom.getNumber() == ID) //if top index object has the id we are looking for
            {
                System.out.println(bottom.toString());
                check++; //updates check variable
                //System.out.println("Bottom");
                if (check == 1) //checks to see if the check variable has been changed
                {
                    found = true; //breaks out of while loop
                    break;
                }
            }
            
            else if (top.getNumber() == ID) //if bottom index object has the id we are looking for
            {
                System.out.println(top.toString());
                //System.out.println("Top");
                check++; 
                if (check == 1)
                {
                    found = true;
                    break;
                }
            }
            
            else //if neither the top/bottom index objects have the id
            {
                if (guess.getNumber() > ID) //if the guess was higher than the id
                {
                    top = guess; //makes the guess the high end of the range
                    t = g; //makes the top index the guess' index
                    g = (t + b)/2; //redoes the guess index to be between the new top and bottom
                }
                
                else if (guess.getNumber() < ID) //if the guess was lower than the id
                {
                    bottom = guess; //makes the guess the bottom end of the range
                    b = g; //makes the bottom index the guess' index
                    g = (t+b)/2; //redoes the guess index to be between new bottom and top
                }
            }
        }
    }
    
    public void print()
    {
        for (int i = 0; i < a.size(); i++)
        {
            Customer temp = ((Customer)a.get(i));
            System.out.println(temp.toString());
        }
    }
}


