package Java2.JavaThirdQuarter.Final;

public class ListNode
{
    private Integer value;
    private ListNode next;

    // ListNode constructor  links an Integer to this node and sets a pointer to tne
    //next node in the chain
    public ListNode (Integer initValue, ListNode initNext)
    {
	value = initValue;
	next = initNext;
    } 


    // getValue method returns a pointer to the Integer linked to this node.
    public Integer getValue ()
    {
	return value;
    } 


    // getNext method  returns a pointer to the next list node in the chain
    public ListNode getNext ()
    {
	return next;
    } 


    // setValue method links an Integer to this node
    public void setValue (Integer theNewValue)
    {
	value = theNewValue;
    } 


    // setNext method sets a pointer to tne
    //next node in the chain
    public void setNext (ListNode theNewNext)
    {
	next = theNewNext;
    } 
} // ListNode class

