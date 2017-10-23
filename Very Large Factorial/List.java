/**
 * List class
 */
public class List implements ListInterface{

    private ListNode list;
    private ListNode last;

    /**
     * Constructs an empty list
     */
    public List() {
        list = null;
        last = null;
    }

    /**
     * Returns the first node in the list
     * @return ListNode - first node of the list
     */
    public ListNode getFirstNode() {
        return list;
    }

    /**
     * Returns the last node in the list
     * @return ListNode - last node of the list
     */
    public ListNode getLastNode() {
        return last;
    }

    /**
     * Returns the first int in the list
     * @return int - first int in the list
     */
    public int getFirst() {
        if (list == null) {
            System.out.println("Runtime Error: getFirst()");
            System.exit(1);
        }
        return list.getInfo();
    }

    /**
     * Returns the last int in the list
     * @return int - last int in the list
     */
    public int getLast() {
        if (list == null) {
            System.out.println("Runtime Error: getLast()");
            System.exit(1);
        }
        return last.getInfo();
    }

    /**
     * Adds an int to the front of a list
     * @param o int
     */
    public void addFirst(int o) {
        ListNode p = new ListNode(o, list);
        if (list == null)
            last = p;
        list = p;
    }

    @Override
    public void addFirst(ListNodeInterface p) {
        if (p == null) {
            System.out.println("Runtime Error: addFirst()");
            System.exit(1);
        }
        p.setNext(list);
        if (list == null)
            last = (ListNode) p;
        list = (ListNode) p;
    }

    /**
     * Adds a node to the front of the list
     * @param p ListNode
     */
    public void addFirst(ListNode p) {
        if (p == null) {
            System.out.println("Runtime Error: addFirst()");
            System.exit(1);
        }
        p.setNext(list);
        if (list == null)
            last = p;
        list = p;
    }

    /**
     * Adds an int to the end of the list
     * @param o int
     */
    public void addLast(int o) {
        ListNode p = new ListNode(o);
        if (list == null)
            list = p;
        else
            last.setNext(p);
        last = p;
    }

    /**
     * Adds a node to the end of the list
     * @param p ListNodeInterface
     */
    @Override
    public void addLast(ListNodeInterface p) {
        if (p == null) {
            System.out.println("Runtime Error: addLast()");
            System.exit(1);
        }
        p.setNext(null);
        if (list == null)
            list = (ListNode) p;
        else
            last.setNext(p);
        last = (ListNode) p;
    }


    public void addLast(ListNode p) {
        if (p == null) {
            System.out.println("Runtime Error: addLast()");
            System.exit(1);
        }
        p.setNext(null);
        if (list == null)
            list = p;
        else
            last.setNext(p);
        last = p;
    }

    /**
     * Removes the first int from the list
     * @return int - removed int
     */
    public int removeFirst() {
        if (list == null) {
            System.out.println("Runtime Error: removeFirst()");
            System.exit(1);
        }
        ListNode p = list;
        list = p.getNext();
        if (list == null)
            last = null;
        return p.getInfo();
    }

    /**
     * Removes the last int from the list
     * @return int - removed int
     */
    public int removeLast() {
        if (list == null) {
            System.out.println("Runtime Error: removeLast()");
            System.exit(1);
        }
        ListNode p = list;
        ListNode q = null;
        while (p.getNext() != null) {
            q = p;
            p = p.getNext();
        }
        if (q == null) {
            list = null;
            last = null;
        }
        else {
            q.setNext(null);
            last = q;
        }
        return p.getInfo();
    }

    @Override
    public void insertAfter(ListNodeInterface p, int o) {
        if (list == null || p == null) {
            System.out.println("Runtime Error: insertAfter()");
            System.exit(1);
        }
        ListNode q = new ListNode(o, (ListNode) p.getNext());
        p.setNext(q);
        if (q.getNext() == null)
            last = q;
    }

    @Override
    public void insertAfter(ListNodeInterface p, ListNodeInterface q) {
        if (list == null || p == null || q == null) {
            System.out.println("Runtime Error: insertAfter()");
            System.exit(1);
        }
        q.setNext(p.getNext());
        p.setNext(q);
        if (last.getNext() != null)
            last = (ListNode) q;
    }

    @Override
    public int deleteAfter(ListNodeInterface p) {
        if (list == null || p == null || p.getNext() == null) {
            System.out.println("Runtime Error: deleteAfter()");
            System.exit(1);
        }
        ListNode q = (ListNode) p.getNext();
        p.setNext(q.getNext());
        if (p.getNext() == null)
            last = (ListNode) p;
        return q.getInfo();
    }

    /**
     * Inserts an int after the node referenced by p
     * @param p ListNode
     * @param o int
     */
    public void insertAfter (ListNode p, int o) {
        if (list == null || p == null) {
            System.out.println("Runtime Error: insertAfter()");
            System.exit(1);
        }
        ListNode q = new ListNode(o, p.getNext());
        p.setNext(q);
        if (q.getNext() == null)
            last = q;
    }

    /**
     * Inserts a node after the node referenced by p
     * @param p ListNode
     * @param q ListNode
     */
    public void insertAfter(ListNode p, ListNode q) {
        if (list == null || p == null || q == null) {
            System.out.println("Runtime Error: insertAfter()");
            System.exit(1);
        }
        q.setNext(p.getNext());
        p.setNext(q);
        if (last.getNext() != null)
            last = q;
    }

    /**
     * Deletes the node after the node referenced by p
     * @param p ListNode
     * @return int Deleted int
     */
    public int deleteAfter(ListNode p) {
        if (list == null || p == null || p.getNext() == null) {
            System.out.println("Runtime Error: deleteAfter()");
            System.exit(1);
        }
        ListNode q = p.getNext();
        p.setNext(q.getNext());
        if (p.getNext() == null)
            last = p;
        return q.getInfo();
    }
    
    /**
     * Inserts an item into its correct location within an ordered list
     * @param o int
     */
    public void  insert(int o) {
        ListNode p = list;
        ListNode q = null;
        while (p != null && (o > p.getInfo())) {
            q = p;
            p = p.getNext();
        }
        if (q == null)
            addFirst(o);
        else
            insertAfter(q, o);
    }

    @Override
    public void insert(ListNodeInterface r) {
        ListNode p = list;
        ListNode q = null;
        while (p != null &&
                (r.getInfo() > p.getInfo())) {
            q = p;
            p = p.getNext();
        }
        if (q == null)
            addFirst(r);
        else
            insertAfter(q, r);
    }

    /**
     * Inserts a node into its correct location within an ordered list
     * @param r ListNode
     */
    public void insert(ListNode r) {
        ListNode p = list;
        ListNode q = null;
        while (p != null &&
        (r.getInfo() > p.getInfo())) {
            q = p;
            p = p.getNext();
        }
        if (q == null)
            addFirst(r);
        else
            insertAfter(q, r);
    }

    /**
     * Removes the first occurrence of an item in a list
     * @param o int
     * @return int Removed int
     */
    public int remove(int o) {
        ListNode p = list;
        ListNode q = null;
        while (p != null && (o != p.getInfo())) {
            q = p;
            p = p.getNext();
        }
        if (p == null)
            return 0;
        else return q == null ? removeFirst() : deleteAfter(q);
    }
    
    /**
     * Returns true if the item is found in the list
     * @param o int
     * @return true - if the list contains the int or
     *                  false - otherwise
     */
    public boolean contains(int o) {
        ListNode p = list;
        while (p != null && (o != p.getInfo()))
            p = p.getNext();
        return p != null;
    }
    
    /**
     * Returns a reference to the node with the requested value.
     * Returns null otherwise
     * @param o int
     * @return ListNode
     */
    public ListNode select(int o) {
        ListNode p = list;
        while (p != null)
            if (o == p.getInfo())
                return p;
            else
                p = p.getNext();
        return null;
    }
    
    /**
     * Determines whether or not a list is empty
     * @return true - if the list is empty or false - otherwise
     */
    public boolean isEmpty() {
        return list == null;
    }

    /**
     * Removes all elements from a list
     */
    public void clear() {
        list = null;
        last = null;
    }
    
    /**
     * Returns the number of elements in the list
     * @return int
     */
    public int size() {
        int count = 0;
        ListNode p = list;
        while (p != null) {
            ++count;
            p = p.getNext();
        }
        return count;
    }

    /**
     * Makes a copy of a list
     * @return List - a new List int
     */
    public List copyList() {
        ListNode p = null;
        ListNode q = null; // to satisfy compiler;
        ListNode r = list;
        
        if (isEmpty())
            return null;
        List newList = new List();
        while (r != null) {
            p = new ListNode(r.getInfo());
            if (newList.isEmpty())
                newList.addFirst(p);
            else
                q.setNext(p);
            q = p;
            r = r.getNext();
        }
        newList.last = p;
        return newList;
    }

    /**
     * Reverses a list
     */
    public void reverse() {
        ListNode p = list;
        ListNode q = null;
        ListNode r;
        
        while (p != null) {
            r = q;
            q = p;
            p = p.getNext();
            q.setNext(r);
        }
        last = list;
        list = q;
    }

}