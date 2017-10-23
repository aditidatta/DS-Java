/**
 * Polynomial holds a list containing coefficients and exponents;
 * and it has other methods to do different mathematical operations
 * on that polynomial.
 * @author Aditi Datta
 */
public class Polynomial {
    private ObjectList poly;
    private int degree;

    /**
     * Creates an empty polynomial with no coefficient or
     * exponent i.e. degree = 0
     */
    public Polynomial(){
        poly = new ObjectList();
        degree = 0;
    }

    /**
     * Creates a polynomial with a given list of coefficients;
     * coefficients should be arranged in an order that their
     * exponents are in decreasing order. Example - for a poly
     * nomial like this: 4x^3 + 2x - 5, the input coefficients
     * should be [4, 0, 2, -5]
     * @param coeffs int[] array of coefficients
     */
    public Polynomial(int[] coeffs){
        poly = new ObjectList();
        degree = coeffs.length-1;
        int exp = degree;
        for(int coeff : coeffs){
            if(coeff !=0) {
                Term t = new Term(coeff, exp);
                poly.addLast(t);
            }
            exp--;
        }
    }


    /**
     * Creates a polynomial with a given list of terms
     * @param p ObjectList of terms
     */
    public Polynomial(ObjectList p){
        poly = p.copyList();
        degree = ((Term)poly.getFirst()).getExpon();
    }

    /**
     * Creates a copy of the given polynomial
     * @param p other Polynomial objct
     */
    public Polynomial(Polynomial p){
        this(p.poly);
    }

    // Attaches a new term to the end of the sum list.
    private void attach(int coeff, int exp){
        Term t = new Term(coeff, exp);
        poly.addLast(t);
    }

    /**
     * returns the List representation of the polynomial
     * @return ObjectList - the polynomial
     */
    public ObjectList getList(){
        return  poly;
    }

    /**
     * Takes the list representation of the polynomial
     * @param list ObjectList
     */
    public void setList(ObjectList list){
        poly = list;
    }

    /**
     * Returns the degree of the polynomial
     * @return int degree
     */
    public int getDegree() {
        return degree;
    }

    /**
     * Sets the degree of the polynomial
     * @param degree int
     */
    public void setDegree(int degree) {
        this.degree = degree;
    }

    /**
     * Adds this polynomial with the other giver Polynomial
     * object; it uses AddPoly class's sumTwoPolys(ObjectList A,
     * ObjectList B) ans assigns the resultant list to a new
     * Polynomial object.
     * @param poly2 the other Polynomial
     * @return resultant polynomial
     */
    public Polynomial add(Polynomial poly2){

        AddPolys addPolys = new AddPolys();

        Polynomial res = new Polynomial();
        res.poly = addPolys.sumTwoPolys(this.poly, poly2.poly);
        res.degree = ((Term)res.poly.getFirst()).getExpon();
        return res;
    }

    /**
     * Subtracts the given polynomial from this Polynomial
     * object; it uses AddPoly class's sumTwoPolys(ObjectList A,
     * ObjectList B) ans assigns the resultant list to a new
     * Polynomial object.
     * @param poly2 the other Polynomial
     * @return resultant polynomial
     */
    public Polynomial subtract(Polynomial poly2){

        SubtractPolys subPolys = new SubtractPolys();

        Polynomial res = new Polynomial();
        res.poly = subPolys.subtractTwoPolys(this.poly, poly2.poly);
        res.degree = ((Term)res.poly.getFirst()).getExpon();
        return res;
    }

    /**
     * Multiplies the polynomial by a giver number.
     * @param num int input number for scalar multiplication
     * @return Polynomial after multiplying with the number
     */
    public Polynomial multiplyBy(int num){
        Polynomial res = new Polynomial();
        if(num == 0)
            return res;
        ObjectListNode p = poly.getFirstNode();
        while(p != null){
            Term t = (Term) p.getInfo();
            int coeff = t.getCoeff() * num;
            if(coeff != 0)
                res.attach(coeff, t.getExpon());
            p = p.getNext();
        }
        return res;
    }


    /**
     * Calculates 1st derivative of the polynomial
     * @return Polynomial
     */
    public Polynomial diff(){
        Polynomial res = new Polynomial();
        if(degree == 0)
            return res;
        if(degree == 1) {
            int coeff = ((Term) poly.getFirst()).getCoeff();
            res.attach(coeff, 0);
            res.degree = 0;
            return res;
        }
        res.degree = degree - 1;
        ObjectListNode p = poly.getFirstNode();
        while(p != null){
            Term t = (Term)p.getInfo();
            if(t.getExpon() == 0)
                break;
            int exp = t.getExpon()-1;
            int coeff = t.getCoeff() * t.getExpon();
            res.attach(coeff, exp);
            p = p.getNext();
        }
        return res;
    }

    /**
     * Calculates 2nd derivative of the polynomial
     * @return Polynomial
     */
    public Polynomial diff2(){
        Polynomial res = new Polynomial();
        if(degree == 0 || degree == 1) {
            return res;
        }
        res.degree = degree - 2;
        ObjectListNode p = poly.getFirstNode();
        while(p != null){
            Term t = (Term)p.getInfo();
            if(t.getExpon() <= 1)
                break;
            int exp = t.getExpon()-2;
            int coeff = t.getCoeff() * t.getExpon() * (t.getExpon()-1);
            res.attach(coeff, exp);
            p = p.getNext();
        }

        return res;
    }

    /**
     * Calculates 3rd derivative of the polynomial
     * @return Polynomial
     */
    public Polynomial diff3(){
        Polynomial res = new Polynomial();
        if(degree == 0 || degree == 1 || degree == 2) {
            return res;
        }
        res.degree = degree - 3;
        ObjectListNode p = poly.getFirstNode();
        while(p != null){
            Term t = (Term)p.getInfo();
            if(t.getExpon() <= 2)
                break;
            int exp = t.getExpon()-3;
            int coeff = t.getCoeff() * t.getExpon() * (t.getExpon()-1) *
                    (t.getExpon()-2);
            res.attach(coeff, exp);
            p = p.getNext();
        }

        return res;
    }

    /**
     * Calculates 1st, 2nd, or 3rd derivative of the polynomial
     *  based on the given number
     * @param n int 1 - 1st deriv, 2 - 2nd deriv, 3 - 3rd deriv
     * @return Polynomial
     */
    public Polynomial diff(int n) {
        if (n == 1)
            return diff();
        else if (n == 2)
            return diff2();
        else if( n == 3)
            return diff3();
        else
            throw new RuntimeException("Must be 1st, 2nd or 3rd " +
                    "derivative.");
    }

    /**
     * Evaluates the polynomial at a given value of X
     * @param x int value of x
     * @return int - evaluated result
     */
    public int evaluateAt(int x){
        ObjectListNode p = poly.getFirstNode();
        int res = 0;
        while(p!= null){
            Term t = (Term) p.getInfo();
            res += t.getCoeff() * (int)Math.pow(x,t.getExpon());
            p = p.getNext();
        }
        return res;
    }

    /**
     * String representation of the polynomial
     * @return String
     */
    public String toString(){
        String str = "";

        ObjectListNode p = poly.getFirstNode();
        int i = 0;
        if(p == null){
            return "0";
        }
        while(p!=null){
            Term t = (Term) p.getInfo();
            int coeff = t.getCoeff();
            int exp = t.getExpon();
            if(coeff < 0)
                str += " - ";
            else if(i > 0 && coeff > 0)
                str += " + ";

            if (exp == 0){
                str = str + Math.abs(coeff);
            }
            else
                str = str + Math.abs(coeff) + "x^" + exp;

            i++;
            p = p.getNext();
        }
        return str;
    }
}
