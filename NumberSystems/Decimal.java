
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * class - Decimal
 * it can be used to convert Decimal to Binary or Hexadecimal
 *
 * @author Aditi Datta
 * Date -
 */

public class Decimal {

    private PrintWriter out;
    private Scanner sc;
    private int dec;
    private String bin;
    private String hex;
    private DualOutputStream outputStream;

    /**
     * Decimal - constructor
     * @param pw PrintWriter object
     */
    public Decimal(PrintWriter pw){
        out = pw;
        sc = new Scanner(System.in);
        dec = 0;
        bin = "";
        hex = "";
        outputStream = new DualOutputStream(System.out, out);
    }

    /**
     * to convert decimal to binary, it calls
     * inputDec(), toBin() and outBin()
     */
    public void decToBin() {
        dec = 0;
        bin = "";
        inputDec();
        toBin();
        outBin();
    }

    /**
     * to take decimal number input, calls
     * validate() to validate input
     */
    private void inputDec() {
        outputStream.print("\nEnter a Decimal number: ");
        String str = sc.nextLine();
        out.println(str);
        dec = validate(str);
    }

    /**
     * to validate input decimal number
     * @param str input string
     * @return dec int (validated decimal number)
     */
    private int validate(String str){
        String regex = "[0-9]";
        if(str.matches("[-+]?\\d*\\.?\\d+")){
            return Integer.parseInt(str);
        }

        outputStream.println("**** Error: Must be a number! " +
                "Special characters " +
                "are also not allowed");
        outputStream.print("\nEnter again: ");
        str = sc.nextLine();
        out.println(str);
        return validate(str);
    }

    /**
     * converts decimal to binary
     */
    private void toBin() {
        int num = dec;
        int binary[] = new int[32];
        int index = 0;
        while(num > 0){
            binary[index++] = num%2;
            num = num/2;
        }
        for(int i = binary.length-1;i >= 0;i--){
            bin += binary[i];
        }
    }

    /**
     * prints out the converted binary number
     */
    private void outBin() {

        outputStream.println(bin.substring(0,4)+" "+
                bin.substring(4,8)+" "+
                bin.substring(8,12)+" "+
                bin.substring(12,16)+" "+
                bin.substring(16,20)+" "+
                bin.substring(20,24)+" "+
                bin.substring(24,28)+" "+
                bin.substring(28,32)+" ");
    }

    /**
     * called to convert decimal to hexadecimal,
     * it calls inputDec(), toHex() and outHex()
     */
    public void decToHex() {
        dec = 0;
        hex = "";
        inputDec();
        toHex();
        outHex();
    }

    /**
     * converts decimal to hexadecimal
     */
    private void toHex(){
        String digits = "0123456789ABCDEF";
        int num = dec;
        if (num == 0)
            hex = "0";
        else {
            while (num > 0) {
                int digit = num % 16;                // rightmost digit
                hex = digits.charAt(digit) + hex;  // string concatenation
                num = num / 16;
            }
        }
        hex = String.format("%8s",hex).replace(' ','0');

    }

    /**
     * prints out the converted hexadecimal number
     */
    private void outHex(){
        outputStream.println(hex);
    }

}
