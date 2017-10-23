

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * class Menu - it generates a menu like -
 * ------ Main Menu ------
 * 1. Decimal to Binary.
 * 2. Decimal to Hexadecimal.
 * 3. Binary to Decimal.
 * 4. Binary to Hexadecimal.
 * 5. Hexadecimal to Decimal.
 * 6. Hexadecimal to Binary.
 * 7. Quit.
 *
 * and reads user's choice
 *
 * @author Aditi Datta
 *
 */
public class Menu {

    private PrintWriter out;
    private Scanner sc;
    private DualOutputStream outputStream;

    /**
     * constructor Menu
     * @param pw PrintWriter object
     */
    public Menu(PrintWriter pw){
        out = pw;
        sc = new Scanner(System.in);
        outputStream = new DualOutputStream(System.out, out);
    }

    /**
     * displays the main menu
     */
    public void display(){
        outputStream.println("\n------ Main Menu ------");
        outputStream.println("\n 1. Decimal to Binary."
                          +"\n 2. Decimal to Hexadecimal."
                          +"\n 3. Binary to Decimal."
                          +"\n 4. Binary to Hexadecimal."
                          +"\n 5. Hexadecimal to Decimal"
                          +"\n 6. Hexadecimal to Binary."
                          +"\n 7. Quit.");

    }

    /**
     * reads and returns user's choice
     * @return int returns user's choice
     */
    public int getSelection(){
        outputStream.print("\nEnter your choice: ");
        String str = sc.nextLine();
        out.println(str);
        int choice = validate(str);
        return choice;
    }

    /**
     * validates user's input
     * @param str input string
     * @return int validated choice
     */
    private int validate(String str){
        String regex = "[0-9]";
        if(str.matches("[-+]?\\d*\\.?\\d+")) {
            int i = Integer.parseInt(str);
            if (i >= 1 && i <= 7){
                return i;
            }
        }
        outputStream.println("**** Error: Not a valid entry!");
        outputStream.print("\nEnter your choice again: ");
        str = sc.nextLine();
        out.println(str);
        return validate(str);
    }

}
