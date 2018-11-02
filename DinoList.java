package Java2.JavaThirdQuarter.Final;

public class DinoList
{
    
    private Integer x;
    ListNode head,tail,searchNode, temp;
    int listSize;
   
    public DinoList()
    {
        head = null;
        tail = null;
        listSize = 0;
        searchNode = null;
        temp = null;
    }

       
    // return the list size.
    public int size()
    {     
        return listSize;
    }  
   
    
    // traverse the list and print the int values
    public void printAll()
    {
        searchNode = head;
        for(int i = 0; i < listSize; i++){
            System.out.println(searchNode.getValue());
            searchNode = searchNode.getNext();
        }
    }  

    // traverse the list, return the value in the nth node, 
    // if n is greater than size, sop an error message. 
    public Integer get(int n)
    {        
        searchNode = head;
        if(n > listSize)
        {
            System.out.println("ERROR");
        }
        for(int i = 0;i < n; i++)
        {
            searchNode = searchNode.getNext();
        }
        return searchNode.getValue();
    }   

     // add a list node with int value k to the end of Dinolist, 
     // if listSize = 0 call addFirstNode
   
     public void add(Integer K)
    {   
        if(listSize == 0){
            ListNode T = new ListNode(K, null);
            head = T;
            tail = head;
        }else{
            ListNode T = new ListNode(K, null);
            tail.setNext(T);
            tail = T;
        }
        listSize++;
    }   
    
    // insert a list node with int value k into the nth position 
    //of Dinolist, if n is greater than size, sop an error message. 
    public void add(Integer k, int n)
    {   
        ListNode X = new ListNode(k, null);
        searchNode = head;
        if(n > listSize)
        {
            System.out.println("ERROR");
            return;
        }else if(n == 0){
            X.setNext(head);
            head = X;
        }else if(n == listSize){
            add(X.getValue().intValue());
        }else{
            for(int i = 0; i < n - 1; i++)
            {
                searchNode = searchNode.getNext();
            }
            X.setNext(searchNode.getNext());
            searchNode.setNext(X);
        }
        listSize++;
    }   


    // remove the nth node of DinoList.  if n is greater than size, 
    //sop an error message. 
    public void delete(int n)
    {
        searchNode = head;
        if(n > listSize){
            System.out.println("ERROR");
            return;
        }else if(n == 0){
            head = head.getNext();
        }else{
            for(int i = 0; i < n - 1; i++){
                searchNode = searchNode.getNext();
            }
            searchNode.setNext(searchNode.getNext().getNext());
        }
        listSize--;
    }

    // set the nth node of DinoList to the value of k.  
    //if n is greater than size, sop an error message. 

    public void set(Integer k, int n )
    {
        if(n > listSize){
            System.out.println("ERROR");
        }else{
            searchNode = head;
            temp = head;
            ListNode Z = new ListNode(k, null);
            for(int i = 0; i < n + 1; i++){
                searchNode.getNext();
            }
            Z.setNext(searchNode);
            for(int j = 0; j < n - 1; j++){
                temp.getNext();
            }
            temp.setNext(Z);
        }
    }


    // make up a new method to make your DinoList special!
    
    public double sum(){
        double add = 0;
        searchNode = head;
        for(int i = 0; i < listSize; i++){
            add += searchNode.getValue().intValue();
            searchNode = searchNode.getNext();
        }
        
        return add;
    }
}
