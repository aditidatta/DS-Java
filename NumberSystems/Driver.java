

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Driver class for NumberSystem project
 *
 * @author Aditi Datta
 */
public class Driver {

    /**
     * Main method
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException{
        int choice;

        String fileName = "csis.txt";
        PrintWriter pw = new PrintWriter(new FileWriter(fileName));

        Decimal dec = new Decimal(pw);
        Binary bin = new Binary(pw);
        Hexadecimal hex = new Hexadecimal(pw);
        Menu menu = new Menu(pw);

        do{
            menu.display();
            choice = menu.getSelection();

            switch(choice){
                case 1:
                    dec.decToBin();
                    break;
                case 2:
                    dec.decToHex();
                    break;
                case 3:
                    bin.binToDec();
                    break;
                case 4:
                    bin.binToHex();
                    break;
                case 5:
                    hex.hexToDec();
                    break;
                case 6:
                    hex.hexToBin();
                    break;
            }
        }while (choice != 7);
        pw.close();
    }
}
