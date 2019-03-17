public class ArrayStack<T> implements Stack<T> {
    int SIZE = 10;
    T[] arr;
    int top;

    /*
    * arraystack()
    * creates a new array of generics with the top = -1
    * since there are no elements in the stack
     */

    public ArrayStack(){
        arr = (T[]) new Object[SIZE];
        top = -1;
    }

    /*
    * push()
    * puts the generic to the to top of the stack
    * and if the stack is full then it grows the array
    * it also increments the top
     */
    @Override
    public void push(T item) {
        if(top== arr.length-1){
            grow_array();
        }
        arr[++top] = item;

    }
    /*
    * pop()
    * returns the end of the array and decrements the top
     */
    @Override
    public T pop(){
        return arr[top--];
    }
    /*
    * peek()
    * looks at the element at the top of the array
     */
    @Override
    public T peek() {
        return arr[top];
    }
    /*
    * empty()
    * checks if top is equal to -1 to
    * see if the array is empty
     */
    @Override
    public boolean empty() {
        if(top == -1)
            return true;
        else
            return false;
    }
    /*
    *grow array()
    * doubles the size of the array once the current one
    * is full
     */
    protected void grow_array() { //O(1) = O(n)/n
        T[] temp =(T[]) new Object[arr.length*2];
        for(int i = 0; i < arr.length;i++){
            temp[i] = arr[i];
        }
        arr = temp;
    }
}
