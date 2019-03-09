public class ArrayStack<T> implements Stack<T> {
    int SIZE = 10;
    T[] arr;
    int top;


    public ArrayStack(){
        arr = (T[]) new Object[SIZE];
        top = -1;
    }

    @Override
    public void push(T item) {
        if(top== arr.length-1){
            grow_array();
        }
        arr[++top] = item;

    }

    @Override
    public T pop(){
        return arr[top--];
    }

    @Override
    public T peek() {
        return arr[top];
    }

    @Override
    public boolean empty() {
        if(top == -1)
            return true;
        else
            return false;
    }

    protected void grow_array() { //O(1) = O(n)/n
        T[] temp =(T[]) new Object[arr.length*2];
        for(int i = 0; i < arr.length;i++){
            temp[i] = arr[i];
        }
        arr = temp;
    }
}
