/**
 * Term class stores two variables, coefficient and exponent.
 * @author Aditi Datta
 */
public class Term implements Comparable{
    private int coeff;
    private int exp;

    /**
     * Creates a term with a coefficient and an exponent.
     * @param c int coefficient
     * @param e int exponent
     */
    public Term(int c, int e){
        coeff = c;
        exp = e;
    }

    /**
     * Sets a value for the coefficient of the term.
     * @param coeff int coefficient
     */
    public void setCoeff(int coeff){
        this.coeff = coeff;
    }

    /**
     * Returns the coefficient of the term.
     * @return int coefficient
     */
    public int getCoeff() {
        return coeff;
    }

    /**
     * Returns the exponent og the term
     * @return int exponent
     */
    public int getExpon() {
        return exp;
    }

    /**
     * Sets a value for the exponent of the term.
     * @param exp int exponent
     */
    public void setExpon(int exp) {
        this.exp = exp;
    }

    /**
     * Compares this object with the specified object for order.  Returns a
     * negative integer, zero, or a positive integer as this object is less
     * than, equal to, or greater than the specified object.
     * @param o the object to be compared.
     * @return a negative integer, zero, or a positive integer as this object
     * is less than, equal to, or greater than the specified object.
     * @throws NullPointerException if the specified object is null
     * @throws ClassCastException   if the specified object's type prevents it
     *                              from being compared to this object.
     */
    @Override
    public int compareTo(Object o) {
        if(o == null){
            throw new NullPointerException("Term is being compared " +
                    "with a null object.");
        }

        if(!(o instanceof Term)){
            throw new ClassCastException("[ERROR] An Term object can" +
                    " only be compared to another object of Term" +
                    " class.");
        }

        Term otherTerm = (Term) o;
        if(this.exp > otherTerm.exp)
            return 1;
        else if(this.exp < otherTerm.exp)
            return -1;
        else
            return 0;
    }
}
