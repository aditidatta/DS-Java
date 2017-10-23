/**
 * AddPolys class can be used to add two polynomials.
 */
public class AddPolys {
    private ObjectList sum;

    /**
     * Constructs a new AddPoly List
     */
    public AddPolys(){
        sum = new ObjectList();
    }

    /**
     * Attaches a new term to the end of the sum list.
     * @param coeff integer coefficient for the term
     * @param exp integer exponent for the term
     */
    private void attach(int coeff, int exp){
        Term t = new Term(coeff, exp);
        sum.addLast(t);
    }

    /**
     * Adds two polynomial linked lists
     * @param list1 ObjectList for the first polynomial
     * @param list2 ObjectList for the second polynomial
     * @return ObjectList containing the sum of the polynomials
     */
    public ObjectList sumTwoPolys(ObjectList list1, ObjectList list2){
        ObjectListNode p = list1.getFirstNode();
        ObjectListNode q = list2.getFirstNode();

        while(p!= null && q!= null){
            Term t1 = (Term) p.getInfo();
            Term t2 = (Term) q.getInfo();
            if(t1.getExpon() == t2.getExpon()){
                int coeff = t1.getCoeff() + t2.getCoeff();
                if(coeff != 0)
                    attach(coeff, t1.getExpon());
                p = p.getNext();
                q = q.getNext();
            }
            else if(t1.getExpon() > t2.getExpon()){
                attach(t1.getCoeff(), t1.getExpon());
                p = p.getNext();
            }
            else {
                attach(t2.getCoeff(), t2.getExpon());
                q = q.getNext();
            }
        }

        while( p != null ){
            Term t1 = (Term) p.getInfo();
            attach(t1.getCoeff(), t1.getExpon());
            p = p.getNext();
        }

        while( q != null ){
            Term t2 = (Term) q.getInfo();
            attach(t2.getCoeff(), t2.getExpon());
            q = q.getNext();
        }

        return sum;
    }


}
