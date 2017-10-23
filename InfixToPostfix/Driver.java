import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Driver class for InfixToPostfix
 * @author Aditi Datta
 */
public class Driver {

    public static void main(String[] args) throws IOException{
        int choice;

        String inFileName = "infix.txt";
        String outFileName = "csis.txt";
        Scanner sc = new Scanner(new File(inFileName));
        PrintWriter pw = new PrintWriter(new FileWriter(outFileName));

        DualOutputStream outputStream = new DualOutputStream(System.out, pw);

        InfixToPostfix infixToPostfix = new InfixToPostfix();
        EvalPostfix evalPostfix = new EvalPostfix();

        while (sc.hasNextLine()){
            String infix = sc.nextLine();
            if(infix.trim().length() <= 0){
                continue;
            }
            try {
                outputStream.println("Infix:   " + infix);

                String postfix = infixToPostfix.convert(infix);
                outputStream.println("Postfix: " + postfix);

                double res = evalPostfix.evaluate(postfix);
                outputStream.println("Eval:    " + res);

            }catch(IllegalArgumentException ex){
                outputStream.println("[ERROR]  " + ex.getMessage());
            }

            outputStream.println();
            outputStream.println();
        }

        pw.close();
    }
}
