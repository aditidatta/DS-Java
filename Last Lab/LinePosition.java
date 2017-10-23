/**
 * This class stores a line number and position of a word in the line
 * @author Aditi Datta
 */
public class LinePosition implements Comparable{
    private int lineNumber;
    private int colmNumber;

    /**
     * Creates a LinePosition object
     * @param l int
     * @param c int
     */
    public LinePosition(int l, int c){
        lineNumber = l;
        colmNumber = c;
    }

    /**
     * Returns the line number
     * @return int
     */
    public int getLineNumber() {
        return lineNumber;
    }

    /**
     * Returns the position
     * @return int
     */
    public int getPosition() {
        return colmNumber;
    }

    /**
     * Compares a LinePosition object to the other
     * @param o Object
     * @return +ve int - if the the object is greater than the other<br>
     *         -ve int - if the object is smaller that the other<br>
     *         0 - if the object is equal to the other.
     */
    @Override
    public int compareTo(Object o) {
        LinePosition otherLP = (LinePosition) o;
        if(lineNumber > otherLP.lineNumber)
            return 1;
        else if(lineNumber < otherLP.lineNumber)
            return -1;
        else{
            if(colmNumber > otherLP.colmNumber)
                return 1;
            else if(colmNumber < otherLP.colmNumber)
                return -1;
            else
                return 0;
        }
    }

    /**
     * String representation of the LinePosition object
     * @return String
     */
    @Override
    public String toString() {
        return lineNumber+"-"+colmNumber;
    }
}
