public class ListQueue implements Queue{
  int size;
  Node front;
  Node rear;
  
  
  public ListQueue(){
    size = 0;
    front = null;
    rear = null;
  }
//TODO
  // The number of items in the queue
  public int size(){
      return size;
  }
    
// Returns true if the queue is empty
  public boolean isEmpty(){
       if(size==0){
          return true;
      }
      return false;
  } 
    
// Adds the new item on the back of the queue, throwing the
// QueueOverflowException if the queue is at maximum capacity. It
// does not throw an exception for an "unbounded" queue, which 
// dynamically adjusts capacity as needed.
  public void enqueue(Object o) throws QueueOverflowException{
      if(size==0){
          front= new Node(o,front);
          rear=front;
          size++;
      }
      else{
          rear.next= new Node(o,null);
          rear=rear.next;
          size++;
      }
  } 
    
// Removes the item in the front of the queue, throwing the 
// QueueUnderflowException if the queue is empty.
  public Object dequeue() throws QueueUnderflowException{
      if(size==0){
          throw new QueueUnderflowException(); 
      }
      Object temp= front.val;
      front=front.next;
      size--;
      return temp;
  }

// Peeks at the item in the front of the queue, throwing
// QueueUnderflowException if the queue is empty.
  public Object peek() throws QueueUnderflowException{
      if(size==0){
          throw new QueueUnderflowException(); 
      }
      return front.val;
  }

// Returns a textual representation of items in the queue, in the
// format "[ x y z ]", where x and z are items in the front and
// back of the queue respectively.
  public String toString(){
       if(size==0){
          return " Empty Queue ";
      }
       else{
           String d="[ ";
           for(Node i=front;i!=null;i=i.next){
               if(i.next!=null){
                   d+=i.val+" ";
               }
               else{
                   d+=i.val+" ]";
               }
           }
           return d;
       }
  }

// Returns an array with items in the queue, with the item in the
// front of the queue in the first slot, and back in the last slot.
  public Object[] toArray(){
      Object a[]= new Object[size];
      Node j=front;
      for(int i=0;i<size;i++){
          a[i]=j.val;
          j=j.next;
      }
      return a;
  }

// Searches for the given item in the queue, returning the
// offset from the front of the queue if item is found, or -1
// otherwise.
  public int search(Object o){
      int j=0;
      for(Node i=front;i!=null;i=i.next){
          if(i.val==o){
              return j;
          }
          j++;
      }
      return -1;
  }
}