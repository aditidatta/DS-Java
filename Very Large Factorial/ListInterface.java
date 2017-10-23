/**
 * An interface for List class.
 * @author Aditi Datta
 */
public interface ListInterface {
    // Returns the first node in the list
    ListNodeInterface getFirstNode();

    // Returns the last node in the list
    ListNodeInterface getLastNode();

    // Returns the first int in the list
    int getFirst() ;

    // Returns the last int in the list
    int getLast() ;

    // Adds an int to the front of a list
    void addFirst(int o) ;

    // Adds a node to the front of the list
    void addFirst(ListNodeInterface p) ;

    // Adds an int to the end of the list
    void addLast(int o) ;

    // Adds a node to the end of the list
    void addLast(ListNodeInterface p) ;

    // Removes the first int from the list
    int removeFirst() ;

    // Removes the last int from the list
    int removeLast() ;

    // Inserts an int after the node referenced by p
    void insertAfter(ListNodeInterface p, int o) ;

    // Inserts a node after the node referenced by p
    void insertAfter(ListNodeInterface p, ListNodeInterface q) ;

    // Deletes the node after the node referenced by p
    int deleteAfter(ListNodeInterface p) ;

    // Inserts an item into its correct location within an ordered list
    void  insert(int o) ;

    // Inserts a node into its correct location within an ordered list
    void insert(ListNodeInterface r) ;

    // Removes the first occurrence of an item in a list
    int remove(int o) ;

    // Returns true if the item is found in the list
    boolean contains(int o) ;

    // Determines whether or not a list is empty
    boolean isEmpty();

    // Removes all elements from a list
    void clear() ;

    // Returns the number of elements in the list
    int size() ;

    // Makes a copy of a list
    ListInterface copyList();

    // Reverses a list
    void reverse();
}
