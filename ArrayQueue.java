public class ArrayQueue implements Queue{
  int size;
  int front;
  int rear;
  Object [] data;
  
  public ArrayQueue(){
    size=0;
    front = -1;
    rear = -1;
    data = new Object[5];
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
      if(size==data.length){
          throw new QueueOverflowException();
      }
      if(front==-1){
          data[size]=o;
          front++;
          size++;
      }
      else{
          data[(size+front)%data.length]=o;
          size++;
      }
  } 
    
// Removes the item in the front of the queue, throwing the 
// QueueUnderflowException if the queue is empty.
  public Object dequeue() throws QueueUnderflowException{
      if(size==0){
          throw new QueueUnderflowException(); 
      }
      Object temp= data[front%data.length];
      data[front%data.length]=null;
      size--;
      front++;
      return temp;
  }

// Peeks at the item in the front of the queue, throwing
// QueueUnderflowException if the queue is empty.
  public Object peek() throws QueueUnderflowException{
      if(size==0){
          throw new QueueUnderflowException(); 
      }
      return data[front%data.length];
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
          for(int i=front;i<size+front;i++){
              if(i!=(size+front)-1){
                  d+=data[i%data.length]+" ";
              }
              else{
                  d+=data[i%data.length]+" ]";
              }
          }
          return d;
      }
  }

// Returns an array with items in the queue, with the item in the
// front of the queue in the first slot, and back in the last slot.
  public Object[] toArray(){
      Object a[]=new Object[size];
      for(int i=0;i<size;i++){
          a[i]=data[(i+front)%data.length];
      }
      return a;
  }

// Searches for the given item in the queue, returning the
// offset from the front of the queue if item is found, or -1
// otherwise.
  public int search(Object o){
      int j=0;
      for(int i=front;i<size+front;i++){
          if(data[i%data.length]==o){
              return j;
          }
          j++;
      }
      return -1;
  }
}