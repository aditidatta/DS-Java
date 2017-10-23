import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Driver class
 * @author Aditi Datta
 */
public class Driver {
    public static void main(String[] args) throws IOException{

        PrintWriter pw = new PrintWriter(new File("csis.txt"));
        DualOutputStream outputStream = new DualOutputStream(
                System.out, pw);
        Menu menu = new Menu(outputStream);
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        do {
            menu.display();
            choice = menu.getSelection();

            if (choice == 1) {
                menu.factorial();
            }
        }while(choice != 2);

        pw.close();
    }


}
