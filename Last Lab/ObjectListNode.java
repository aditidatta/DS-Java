/**
 * ObjectListNode class
 * @author Aditi Datta
 */
public class ObjectListNode implements ObjectListNodeInterface{

    private Object info;
    private ObjectListNode next;

    /**
     * Default constructor
     */
    public ObjectListNode() {
        info = null;
        next = null;
    }

    /**
     * Creates a new instance of ObjectListNode class
     * @param o Object
     */
    public ObjectListNode (Object o) {
        info = o;
        next = null;
    }

    /**
     * Creates a new instance of ObjectListNode class, takes
     * an input object and reference to the next ObjectListNode
     * object
     * @param o Object
     * @param p ObjectListNode
     */
    public ObjectListNode (Object o, ObjectListNode p) {
        info = o;
        next = p;
    }

    /**
     * Sets info field
     * @param o Object
     */
    public void setInfo(Object o) {
        info = o;
    }

    /**
     * Returns object in info field
     * @return Object
     */
    public Object getInfo() {
        return info;
    }

    /**
     * Sets next field
     * @param p ObjectListNode
     */
    public void setNext(ObjectListNode p) {
        next = p;
    }

    /**
     * Returns next node of the current node, returns null if
     * there's no next node
     * @return ObjectListNode
     */
    public ObjectListNode getNext() {
        return next;
    }

}
