import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Driver class for Binary Tee and hashing lab.<br>
 * @author Aditi Datta
 */
public class Driver {
    public static void main(String[] args) throws IOException{
        String fileName = "csis.txt";
        PrintWriter pw = new PrintWriter(new FileWriter(fileName));
        DualOutputStream dualOut = new DualOutputStream(System.out, pw);
        Query query = new Query(pw, dualOut);
        query.loadOmitted("omitted.txt");
        query.printHashTable();
        query.readFile("getty.txt");
        query.printIndex();
        boolean exit = false;
        Scanner sc = new Scanner(System.in);
        do {
            dualOut.print("\nEnter a word to search OR enter '#' to exit: ");
            String str = sc.nextLine();
            pw.println(str);
            if(str.trim().equals("#"))
                break;
            query.query(str.trim());
        }while(true);
        pw.close();
    }
}
