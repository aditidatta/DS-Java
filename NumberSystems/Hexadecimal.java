

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * class Hexadecimal -
 * it can be used to convert hexadecimal to Binary or Decimal
 *
 * @author Aditi Datta
 */
public class Hexadecimal {

    private static String[] staticLookup = new String[]
            {"0000","0001","0010","0011","0100","0101",
                    "0110","0111","1000","1001","1010",
                    "1011","1100","1101","1110","1111"};
    private PrintWriter out;
    private Scanner sc;
    private String hex;
    private int dec;
    private String bin;
    private DualOutputStream outputStream;


    /**
     * constructor
     * @param pw PrintWriter object
     */
    public Hexadecimal(PrintWriter pw){
        out = pw;
        sc = new Scanner(System.in);
        hex = "";
        dec = 0;
        bin = "";
        outputStream = new DualOutputStream(System.out, out);
    }

    /**
     * it is called to convert hexadecimal to decimal, it calls
     * inputHex(), toDec() and outDec()
     */
    public void hexToDec(){
        hex = "";
        dec = 0;
        inputHex();
        toDec();
        outDec();
    }

    /**
     * to take hexadecimal number input, calls
     * validate() to validate input
     */
    private void inputHex(){
        outputStream.print("\nEnter a Hexadecimal number: ");
        String str = sc.nextLine();
        out.println(str);
        hex = validate(str);
        hex = hex.toUpperCase();
    }

    /**
     * validates input hexadecimal number
     * @param str input string to be validated
     * @return str validated string
     */
    private String validate(String str){

        if(str.matches("[0-9a-fA-F]+") && str.length() <= 8)
            return str;

        outputStream.println("*****Error: Not a valid Hexadecimal number! ");
        outputStream.print("\nEnter again: ");
        str = sc.nextLine();
        out.println(str);
        return validate(str);
    }

    /**
     * converts hexadecimal to decimal
     */
    private void toDec(){

        int val = 0;
        for (int i = 0; i < hex.length(); i++) {
            char c = hex.charAt(i);
            int d;
            if(c >= '0' && c <= '9')
                d = c - '0';
            else //hex string is already validated to be [0-9][A-F]
                d = c - 'A' + 10;
            val = 16*val + d;
        }
        dec = val;
    }

    /**
     * prints out decimal number
     */
    private void outDec(){
        outputStream.println(dec);
    }

    /**
     * it is called to convert hexadecimal to binary,
     * it calls inputHex(), toBin() and outBin()
     */
    public void hexToBin(){
        hex = "";
        bin = "";
        inputHex();
        toBin();
        outBin();
    }

    /**
     * converts hexadecimal to binary
     */
    private void toBin() {

        String binary = "";
        for (int i = 0; i < hex.length(); i++) {
            char c = hex.charAt(i);
            int d;
            if(c >= '0' && c <= '9')
                d = c - '0';
            else //hex string is already validated to be [0-9][A-F]
                d = c - 'A' + 10;
            binary += staticLookup[d];
        }
        for(int i = hex.length(); i < 8; i++){
            binary = "0000" + binary;
        }
        bin = binary;
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
}
