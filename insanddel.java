import java.util.*;

class Node
{
Node next;
int data;
Node pre;

 Node(int data)
   { 
	this.data=data;
   }

}
class CircularList
{
	Node head;
	Node tail;

public void traverseClock()
{
   if(head==null)
   {
   	System.out.println("List Is Empty");
   }
   else
   {
      Node current=head;
      System.out.println("Elements are:");
      while(current.next!=head)
      {   
      	System.out.println(current.data);
         current=current.next;
      }
      System.out.println(current.data);
    }
}




 public void InsertEnd(int data)
  {
    Node Node=new Node(data);
    if(head==null)
    {
    	Node.next=Node;
    	Node.pre=Node;
    	head=Node;
    	tail=Node;
    }
    else
    {
    	tail.next=Node;
    	Node.pre=tail;
    	Node.next=head;
    	head.pre=Node;
    	tail=Node;
    }

  }

  public void InsertBeg(int data)
  {
    Node Node=new Node(data);
    if(head==null)
    {
    	Node.next=Node;
    	Node.pre=Node;
    	head=Node;
    	tail=Node;
    }
    else
    {  
       Node.next=head;
       Node.pre=tail;
       head.pre=Node;
       head=Node;
       tail.next=Node;
    }
  }
  public void deleteAtBeg()
  {
  	if(head==null)
  	{
  		System.out.println("List is Empty");
  	}
  	else if(head==tail)//for a singlr Node
  	{
  		head=null;
  		tail=null;
  	}
  	else
  	{
  		head=head.next;
  		head.pre=tail;
  		tail.next=head;
  	}
  }

  public void deleteAtEnd()
  {
  	if(head==null)
  	{
  		System.out.println("List is Empty");
  	}
  	else if(head==tail)//for a singlr Node
  	{
  		head=null;
  		tail=null;
  	}
  	else
  	{
  		tail=tail.pre;
  		tail.next=head;
  		head.pre=tail;
  	}
  }

 void deleteAtPos(int pos)
  {
    boolean f=false;
    int c=1;
    if(head==null)
    {
      System.out.println("List is empty");
    }
    else
    {
      if(pos==1)
      {
        deleteAtBeg();
        f=true;
      }
      else
      {
        Node pre = head;
        Node t=head.next;
        c++;
        while(t.next!=head)
        {
          if(pos==c)
          {
            pre.next=t.next;
            t.next.pre=t.pre;
            f=true;
            break;
          }
          pre=t;
          t=t.next;
          c++;
        }
        if(pos==c && f==false)
        {
            deleteAtEnd();
        }
      }
    }
  }


  void insertAtPos(int pos,int data)
  {
    Node new1=new Node(data);
    boolean f=false;
    int c=1;
    if(head==null)
    {
      System.out.println("List is empty");
    }
    else{
      if(pos==1)
      {
        new1.next=head;
        head.pre=new1;
        new1.pre=tail;
        head=new1;
        tail.next=head;
        f=true;
      }
      else{
        
        Node t=head;
       
        while(t.next!=head)
        {
          if(pos==c)
          {
            t.pre.next=new1;
            new1.next=t;
            f=true;
          }
          t=t.next; 
          c++;

        }
       
        if(pos==c && f==false)
        {
            t.pre.next=new1;
            new1.next=t;
            f=true;
            c++;
        }
        c++;
        if(pos==c&& f==false)
        {
            InsertEnd(data);
            f=true;
            c++;
        }
      }
    }
  }

}

class insanddel



{
	public static void main(String[] args) 
	{
	  CircularList list=new CircularList();
    Scanner s=new Scanner(System.in);
    System.out.println("How many Nodes You Want?");
    int n=s.nextInt();
    System.out.println("Enter Elements:");
    for(int i=0;i<n;i++)
    {
      list.InsertEnd(s.nextInt());
    }	
	  list.traverseClock();
	  System.out.println("Enter Position at which You want to Insert new Node");
    int p=s.nextInt();
    System.out.println("Enter data value for New Node");
    int d=s.nextInt();
    list.insertAtPos(p,d);
	  list.traverseClock();
	  System.out.println("Enter position at which You want delete Node?");
    int p1=s.nextInt();
    list.deleteAtPos(p1);
	  list.traverseClock();
	}
}