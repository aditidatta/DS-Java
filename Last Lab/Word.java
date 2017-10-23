/**
 * Word class object stores a string word in it and the number of repetitions
 *  of the word in a text.
 * @author Aditi Datta
 */
public class Word implements TreeComparable{
    private String word;
    private int count;
    private Xref ref;
    private DualOutputStream dualOut;
    private LinePosition linePosition;

    /**
     * Creates a word with a string in it.
     * @param s String
     * @param dualOut DualOutputStream
     */
    public Word(String s, DualOutputStream dualOut){
        word = s;
        count = 1;
        linePosition = new LinePosition(0,0);
        ref = null;
        this.dualOut = dualOut;
    }

    /**
     * creates a word with a string, line number and position in the line.
     * @param s String
     * @param line int
     * @param position int
     * @param dualOut DualOutputStream
     */
    public Word(String s, int line, int position, DualOutputStream dualOut){
        word = s;
        count = 1;
        linePosition = new LinePosition(line, position);
        ref = new Xref();
        ref.insert(linePosition);
        this.dualOut = dualOut;
    }

    /**
     * Generates hash code for the word
     * @return int hash code
     */
    @Override
    public int hashCode() {
        int code=0;
        for (int i=0; i<word.length(); i++) {
            code = (code << 5) | (code >>> 27); // 5-bit cyclic shift of the running sum
            code += (int) word.charAt(i); // add in next character
        }
        return code;
    }

    /**
     * increases the count by 1
     */
    public void incrementCount(){
        count++;
    }

    /**
     * Sets the count to a particular number
     * @param count int
     */
    public void setCount(int count) {
        this.count = count;
    }

    /**
     * Returns the String word that is stored in the Word object
     * @return String
     */
    public String getString() {
        return word;
    }

    /**
     * Returns the count
     * @return int
     */
    public int getCount() {
        return count;
    }

    /**
     * returns the line position of the object
     * @return LinePosition object
     */
    public LinePosition getLinePosition(){
        return new LinePosition(linePosition.getLineNumber(),
                linePosition.getPosition());
    }

    /**
     * Returns the String representation of the object, including it's count,
     * cross reference list
     * @return String
     */
    @Override
    public String toString() {
        return String.format("%-14s  %2d\t",word,count)+" "+ref;
    }

    /**
     * Copies the duplicate word's line position and adds it to its own list,
     * and increments the count
     * @param o Object
     */
    @Override
    public void operate(Object o) {
        Word duplicate = (Word) o;
        ref.insert(duplicate.getLinePosition());
        count++;
    }

    /**
     * Prints out the object
     */
    @Override
    public void visit() {
        dualOut.println(this);
    }

    /**
     * Compares to the other word
     * @param o Object
     * @return +ve int - if the the object is greater than the other<br>
     *         -ve int - if the object is smaller that the other<br>
     *         0 - if the object is equal to the other.
     */
    @Override
    public int compareTo(Object o) {
        Word otherWord = (Word) o;
        return this.word.compareTo(otherWord.word);
    }
}
