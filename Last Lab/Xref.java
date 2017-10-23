/**
 * Xref class stores a ObjectList object that stores all the line positions
 * a word. Each word object a Xref object to store its cross references.
 */
public class Xref {

    private ObjectList list;

    /**
     * Creates an empty Xref object
     */
    public Xref(){
        list = new ObjectList();
    }

    /**
     * Inserts a line position object to the list
     * @param linePosition LinePosition
     */
    public void insert(LinePosition linePosition){
        list.addLast(linePosition);
    }

    /**
     * String representation of the LinePosition object
     * @return String
     */
    @Override
    public String toString(){
        String str = "";

        ObjectListNode p = list.getFirstNode();
        int i = 0;
        while(p!= null){
            LinePosition lp = (LinePosition) p.getInfo();
            str = str + "  " + lp;
            p = p.getNext();
        }
        return str;
    }
}
