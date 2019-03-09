

public class ArrayQueue<T> implements Queue<T> {
    int tail;
    int head;
    T[] arr;
    int SIZE = 10;
    int totalItems = 0;

    public ArrayQueue(){
        arr = (T[]) new Object[SIZE];
        tail = 0;
        head = 0;
    }

    @Override
    public T dequeue() {

        T temp = arr[head];
        head = (head+1)%arr.length;
        totalItems--;
        return temp;
    }

    @Override
    public void enqueue(T item) {

        if((head+1)%arr.length==tail)
            grow_array();

        arr[tail++] = item;
        tail = tail % arr.length;
        totalItems++;
    }

    @Override
    public boolean empty() {
        return (totalItems == 0);
    }

    protected void grow_array() { //O(1) = O(n)/n
        T[] temp =(T[]) new Object[arr.length*2];

        for(int i = head, j = 0; i < totalItems;i++,j++){
            temp[j] = arr[i%arr.length];
        }
        temp[0] = arr[head];
        arr = temp;
        head = 0;
        tail = totalItems;

    }
}
