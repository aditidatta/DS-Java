/**
 * ListNode class
 */
public class ListNode implements ListNodeInterface{

    private int info;
    private ListNode next;

    /**
     * Default constructor
     */
    public ListNode() {
        info = 0;
        next = null;
    }

    /**
     * Creates a new instance of ListNode class
     * @param o int
     */
    public ListNode (int o) {
        info = o;
        next = null;
    }

    /**
     * Creates a new instance of ListNode class, takes
     * an input int and reference to the next ListNode
     * int
     * @param o int
     * @param p ListNode
     */
    public ListNode (int o, ListNode p) {
        info = o;
        next = p;
    }

    /**
     * Sets info field
     * @param o int
     */
    public void setInfo(int o) {
        info = o;
    }

    /**
     * Returns int in info field
     * @return int
     */
    public int getInfo() {
        return info;
    }

    @Override
    public void setNext(ListNodeInterface p) {
        next = (ListNode) p;
    }

    /**
     * Sets next field
     * @param p ListNode
     */
    public void setNext(ListNode p) {
        next = p;
    }

    /**
     * Returns next node of the current node, returns null if
     * there's no next node
     * @return ListNode
     */
    public ListNode getNext() {
        return next;
    }

}