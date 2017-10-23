/**
 * ObjectTreeNodeInterface interface.
 * @author Aditi Datta
 */
public interface ObjectTreeNodeInterface {

    void setInfo(Object o);
    Object getInfo();
    void setLeft(ObjectTreeNodeInterface p);
    ObjectTreeNodeInterface getLeft();
    void setRight(ObjectTreeNodeInterface p);
    ObjectTreeNodeInterface getRight();
}
