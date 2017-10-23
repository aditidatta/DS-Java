/**
 * ObjectBinaryTreeInterface  interface.
 * @author Aditi Datta
 */
public interface ObjectBinaryTreeInterface {
    void setLeftChild(ObjectTreeNodeInterface parent, ObjectTreeNodeInterface r);
    void setRightChild(ObjectTreeNodeInterface parent, ObjectTreeNodeInterface r);
    void insertBST(Object o);
    void insertBSTDup(Object o);
    ObjectTreeNodeInterface searchBST(Object o);
    void preTrav(ObjectTreeNodeInterface tree);
    void inTrav(ObjectTreeNodeInterface tree);
    void postTrav(ObjectTreeNodeInterface tree);
}
