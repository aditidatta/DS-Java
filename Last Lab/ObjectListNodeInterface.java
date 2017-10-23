/**
 * An interface for ObjectListNode class.
 * @author Aditi Datta
 */
public interface ObjectListNodeInterface {
    void setInfo(Object o);

    // Returns object in info field
    Object getInfo();

    // Sets next field
    void setNext(ObjectListNode p);

    // Returns object in info field
    ObjectListNodeInterface getNext() ;
}
