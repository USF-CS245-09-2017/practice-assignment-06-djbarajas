

public class ArrayQueue<T> implements Queue<T> {
    int tail;
    int head;
    T[] arr;
    int SIZE = 10;
    int totalItems = 0;

    /*
    *arrayqueue()
    * creates a new array of generic type
    * the head and tail are both set to 0
     */
    public ArrayQueue(){
        arr = (T[]) new Object[SIZE];
        tail = 0;
        head = 0;
    }

    /*
    * dequeue()
    * gets the value at the head
    * then since the queue is a circular
    * queue I make the head equal to head
    * +1 around the array length and return
    * the value at head
    * decrement the total items
     */
    @Override
    public T dequeue() {

        T temp = arr[head];
        head = (head+1)%arr.length;
        totalItems--;
        return temp;
    }

    /*
    * enqueue()
    * if the new head equals the tail, the array
    * is full and needs to be bigger.
    * then make the next item equal to the tail
    * again get the remainder if the tail is
    * bigger than array length
    * then increment the total items
     */
    @Override
    public void enqueue(T item) {

        if((head+1)%arr.length==tail)
            grow_array();

        arr[tail++] = item;
        tail = tail % arr.length;
        totalItems++;
    }

    /*
    * empty()
    * checks if the queue is empty by looking
    * at total items
     */
    @Override
    public boolean empty() {
        return (totalItems == 0);
    }

    /*
    * grow array()
    * creates a temp array double the size of the first
    * then copies it starting from 0 for the target array
    * and the head of the old array.  the head is then set
    * to 0 and tail to the total items.
     */

    protected void grow_array() { //O(1) = O(n)/n
        T[] temp =(T[]) new Object[arr.length*2];

        for(int i = head, j = 0; i < totalItems;i++,j++){
            temp[j] = arr[head%arr.length];
        }
        temp[0] = arr[head];
        arr = temp;
        head = 0;
        tail = totalItems;

    }
}
