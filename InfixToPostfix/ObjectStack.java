/**
 * Implements a resizable stack.
 * @author Aditi Datta
 */
public class ObjectStack implements ObjectStackInterface {
    /**
     * private instance variables
     */
    private Object[] item;  // store the element of the stack
    private int top;        // store the index of the top element

    /**
     * creates a new object of ObjectStakc type
     */
    public ObjectStack() {
        item = new Object[1];
        top = -1;

    }

    /**
     * checks if the stack is empty or not
     * @return true if the stack is empty; otherwise, false
     */
    public boolean isEmpty()
    {
        return top==-1;
    }

    /**
     * checks if the stack is full or not
     * @return true if the stack is full; otherwise, false
     */
    public boolean isFull(){
        return top == item.length-1;
    }

    /**
     * clears the stack to its initial state (i.e. deletes)
     * all the elements
     */
    public void clear(){
        item = new Object[1];
        top = -1;
    }

    /**
     * pushes an element to the stack
     * @param o - element of object type
     */
    public void push(Object o){
        if (isFull()){
            resize(2 * item.length);
        }
        item[++top] = o;
    }

    // private method resize, that resizes the stacks
    private void resize(int size){
        Object[] temp = new Object[size];
        for(int i = 0; i <= top; i++){
            temp[i] = item[i];
        }
        item = temp;
    }

    /**
     * removes and then returns the element at the top of
     * the stack
     * @return top element
     */
    public Object pop() {
        if (isEmpty()){
            System.out.println("Stack Underflow");
            System.exit(1);
        }
        Object temp = item[top];
        item[top--] = null;
        if (top == item.length / 4) {
            resize(item.length / 2);
        }
        return temp;
    }

    /**
     * returns the element at the top of the stack
     * @return top element without removing it
     */
    public Object top(){
        if (isEmpty()){
            System.out.println("Stack Underflow");
            System.exit(1);
        }
        return item[top];
    }
}
