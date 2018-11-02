package Java2.JavaSecondQuarter.Elevens;

public abstract class Vehicle
{   
    private String name; // name of vehicle
    private double rentalRate; // rate by mile
   public Vehicle(String N, double r)
   {
     name = N;
     rentalRate = r;
   }  
 
  public double getRate()
  {
      return rentalRate;
  }
    
 
  public String getName()
    {
     return name;
    }
 
  
 // notice these abstract methods
 // calculates rental cost
    public abstract double calculateRentalCost();
   
    // returns a String containing the name and rental 
    // fee of the vehicle. 
    public abstract String toString();
}   
