/**
 * An interface for ObjectStack class
 * @author Aditi Datta
 */
public interface ObjectStackInterface {
    /**
     * checks if the stack is empty or not
     * @return true if the stack is empty; otherwise, false
     */
    boolean	isEmpty();

    /**
     * checks if the stack is full or not
     * @return true if the stack is full; otherwise, false
     */
    boolean isFull();

    /**
     * clears the stack to its initial state (i.e. deletes)
     * all the elements
     */
    void clear();

    /**
     * returns the element at the top of the stack
     * @return top element without removing it
     */
    Object top();

    /**
     * removes and then returns the element at the top of
     * the stack
     * @return top element
     */
    Object pop();

    /**
     * pushes an element to the stack
     * @param o - element of object type
     */
    void push(Object o);

}
