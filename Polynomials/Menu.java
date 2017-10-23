

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * class Menu - it generates a menu and reads user's choice
 *
 * @author Aditi Datta
 *
 */
public class Menu {

    private PrintWriter pw;
    private Scanner sc;
    private DualOutputStream outputStream;
    private Polynomial poly;
    private boolean created = false;
    /**
     * constructor Menu
     * @param dualOut DualOutputStream object
     */
    public Menu(DualOutputStream dualOut){
        sc = new Scanner(System.in);
        outputStream = dualOut;
        pw = outputStream.getPrintWriterObj();
        poly = new Polynomial();
    }

    /**
     * displays the main menu
     */
    public void display(){
        outputStream.println("\n------ Main Menu ------");
        outputStream.println("\n 1.  Create a Polynomial."
                          +"\n 2.  Print the polynomial."
                          +"\n 3.  PLUS (another polynomial)."
                          +"\n 4.  MINUS (another polynomial)."
                          +"\n 5.  Evaluate the polynomial."
                          +"\n 6.  Perform a scalar multiplication " +
                                    "of the polynomial."
                          +"\n 7.  Find 1st derivative of the polynomial."
                          +"\n 8.  Find 2nd derivative of the polynomial."
                          +"\n 9.  Find 3rd derivative of the polynomial."
                          +"\n 10. Add two polynomials."
                          +"\n 11. Subtract two polynomials."
                          +"\n 12. Quit.");

    }

    /**
     * reads and returns user's choice
     * @return int - user's choice
     */
    public int getSelection(){
        outputStream.print("\nEnter your choice: ");
        String str = sc.nextLine();
        pw.println(str);
        int choice = validateInt(str);
        if(choice < 1 || choice > 12) {
            outputStream.println("[ERROR] Not a valid choice.");
            return getSelection();
        }
        return choice;
    }

    private int validateInt(String str){
        try {
            int i = Integer.parseInt(str);
            return i;
        }
        catch(NumberFormatException e) {
            outputStream.println("[ERROR] Not a valid entry! Must be" +
                    " an integer.");
            outputStream.print("\nEnter again: ");
            str = sc.nextLine();
            pw.println(str);
            return validateInt(str);
        }
    }

    private int getNumber(){
        outputStream.print("\nEnter number (Integer): ");
        int n = -1;
        String str = sc.nextLine();
        pw.println(str);
        n = validateInt(str);

        return n;
    }

    private Polynomial create(){
        outputStream.println("Enter the coefficients in order " +
                "with spaces: ");
        String str[] = sc.nextLine().split("\\s+");
        int[] coeffs = new int[str.length];
        for(int i = 0; i < str.length; i++){
            coeffs[i] = Integer.parseInt(str[i]);
        }
        Polynomial p = new Polynomial(coeffs);
        //outputStream.println(p);
        return p;
    }

    /**
     * Prompts user for coefficients and creates a polynomial
     */
    public void createPoly(){

        poly = create();
        outputStream.println("Created " + poly);
        created = true;

    }

    /**
     * Prompts user for another Polynomial and adds it to the current
     * polynomial
     */
    public void plus(){
        if(!created){
            outputStream.println("Have to create a Polynomial first!");
            return;
        }
        Polynomial poly1 = create();
        outputStream.println("Adding (" + poly1 + ") with ("+ poly + ")");
        Polynomial res = poly.add(poly1);
        outputStream.println("Resultant polynomial:- ");
        outputStream.println(res);
    }

    /**
     * Prompts the user for another polynomial and subtracts it from
     * the current polynomial
     */
    public void minus(){
        if(!created){
            outputStream.println("Have to create a Polynomial first!");
            return;
        }
        Polynomial poly1 = create();
        outputStream.println("Performing: (" + poly + ") minus ("+ poly1 +")");
        Polynomial res = poly.subtract(poly1);
        outputStream.println("Resultant polynomial:- ");
        outputStream.println(res);
    }

    /**
     * Prompts the user for an integer and evaluates the polynomial
     * at the number
     */
    public void evaluate(){
        if(!created){
            outputStream.println("Have to create a Polynomial first!");
            return;
        }
        int x = getNumber();
        int res = poly.evaluateAt(x);
        outputStream.println("Result: " + res);
    }

    /**
     * Prompts the user for an integer and multiplies the polynomial
     * by the number
     */
    public void scalarMult(){
        if(!created){
            outputStream.println("Have to create a Polynomial first!");
            return;
        }
        int x = getNumber();
        Polynomial res = poly.multiplyBy(x);
        outputStream.println("Resultant polynomial:- ");
        outputStream.println(res);
    }

    /**
     * Prints 1st derivative of the polynomial
     */
    public void deriv1(){
        if(!created){
            outputStream.println("Have to create a Polynomial first!");
            return;
        }
        Polynomial res = poly.diff(1);
        outputStream.println("1st derivative of " + poly + " :- ");
        outputStream.println(res);
    }

    /**
     * Prints 2nd derivative of the polynomial
     */
    public void deriv2(){
        if(!created){
            outputStream.println("Have to create a Polynomial first!");
            return;
        }
        Polynomial res = poly.diff(2);
        outputStream.println("2nd derivative of " + poly + " :- ");
        outputStream.println(res);
    }

    /**
     * Prints 3rd derivative of the polynomial
     */
    public void deriv3(){
        if(!created){
            outputStream.println("Have to create a Polynomial first!");
            return;
        }
        Polynomial res = poly.diff(3);
        outputStream.println("3rd derivative of " + poly + " :- ");
        outputStream.println(res);
    }

    /**
     * Prompts the user for two polynomials and then adds them
     */
    public void add2polys(){
        outputStream.println("For 1st polynomial:-");
        Polynomial A = create();

        outputStream.println("For 2nd polynomial:-");
        Polynomial B = create();

        outputStream.println("Adding (" + A + ") with ("+ B +")");
        AddPolys add = new AddPolys();
        ObjectList C = add.sumTwoPolys(A.getList(),B.getList());
        Polynomial res = new Polynomial();
        res.setList(C);
        res.setDegree(((Term)C.getFirst()).getExpon());
        outputStream.println("Resultant polynomial:- ");
        outputStream.println(res);
    }

    /**
     * Prompts the user for two polynomials and then subtracts one from
     * the other
     */
    public void sub2polys(){
        outputStream.println("For 1st polynomial:-");
        Polynomial A = create();

        outputStream.println("For 2nd polynomial:-");
        Polynomial B = create();

        outputStream.println("Performing: (" + A + ") minus ("+ B +")");
        SubtractPolys sub = new SubtractPolys();
        ObjectList C = sub.subtractTwoPolys(A.getList(),B.getList());
        Polynomial res = new Polynomial();
        if (C.getFirstNode() != null) {
            res.setList(C);
            res.setDegree(((Term) C.getFirst()).getExpon());
        }
        outputStream.println("Resultant polynomial:-");
        outputStream.println(res);
    }

    /**
     * Prints the current polynomial
     */
    public void print(){
        if(!created){
            outputStream.println("Have to create a Polynomial first!");
            return;
        }
        outputStream.println(poly);
    }

}
