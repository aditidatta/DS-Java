

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Driver class for Polynomials project
 *
 * @author Aditi Datta
 */
public class Driver {

    /**
     * Main method
     * @param args String[]
     * @throws IOException File I/O error
     */
    public static void main(String[] args) throws IOException{
        int choice;

        String fileName = "csis.txt";
        PrintWriter pw = new PrintWriter(new FileWriter(fileName));
        DualOutputStream outputStream = new DualOutputStream(System.out, pw);
        Menu menu = new Menu(outputStream);

        do{
            menu.display();
            choice = menu.getSelection();

            switch(choice){
                case 1:
                    menu.createPoly();
                    break;
                case 2:
                    menu.print();
                    break;
                case 3:
                    menu.plus();
                    break;
                case 4:
                    menu.minus();
                    break;
                case 5:
                    menu.evaluate();
                    break;
                case 6:
                    menu.scalarMult();
                    break;
                case 7:
                    menu.deriv1();
                    break;
                case 8:
                    menu.deriv2();
                    break;
                case 9:
                    menu.deriv3();
                    break;
                case 10:
                    menu.add2polys();
                    break;
                case 11:
                    menu.sub2polys();
                    break;

            }
        }while (choice != 12);
        pw.close();
    }
}
