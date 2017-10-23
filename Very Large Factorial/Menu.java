

import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * class Menu - it generates a menu and reads user's choice
 *
 */
public class Menu {

    private PrintWriter pw;
    private Scanner sc;
    private DualOutputStream outputStream;

    /**
     * constructor Menu
     * @param dualOut DualOutputStream object
     */
    public Menu(DualOutputStream dualOut){
        sc = new Scanner(System.in);
        outputStream = dualOut;
        pw = outputStream.getPrintWriterObj();
    }

    /**
     * displays the main menu
     */
    public void display(){
        outputStream.println("------------------------ Main Menu " +
                             "------------------------");
        outputStream.println("Press 1 to find factorial of a number.");
        outputStream.println("Press 2 to QUIT.");

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
        if(choice != 1 && choice != 2) {
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
            outputStream.print("\nEnter your choice again: ");
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

        if(n < 0){
            outputStream.println("Only positive numbers " +
                    "are accepted.");
            return getNumber();
        }
        return n;
    }

    /**
     * Prompts the user for the number and calculates the factorial of the
     * number; Prints it along with number of digits and time taken to
     * calculate the factorial.
     */
    public void factorial(){
        int n = getNumber();
        long startTime = System.currentTimeMillis();
        List fact = Factorial.findFactorial(n);
        long endTime = System.currentTimeMillis();


        outputStream.println("\n" + Factorial.formatNumberOutput(fact));
        outputStream.println("\nNumber of digits in " + n + "! : " +
                Factorial.numOfDigits(fact));
        outputStream.print("\nTime taken to calculate " + n +
                "! (in milliseconds): ");
        outputStream.println(endTime-startTime);
        outputStream.println("\n--------------------------- END " +
                               "---------------------------\n");
    }

}
