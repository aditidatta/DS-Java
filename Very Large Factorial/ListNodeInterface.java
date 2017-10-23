/**
 * An interface for ObjectListNode class.
 */
public interface ListNodeInterface {
    void setInfo(int o);

    // Returns object in info field
    int getInfo();

    // Sets next field
    void setNext(ListNodeInterface p);

    // Returns object in info field
    ListNodeInterface getNext() ;
}
