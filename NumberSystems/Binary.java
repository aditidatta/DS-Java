

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * class Binary -
 * it can be used to convert Binary to Decimal or Hexadecimal
 *
 * @author Aditi Datta
 * Date -
 */
public class Binary {

    private PrintWriter out;
    private Scanner sc;
    private String bin;
    private StringBuilder hex;
    private int dec;
    private DualOutputStream outputStream;

    /**
     * constructor
     * @param pw PrintWriter object
     */
    public Binary(PrintWriter pw){
        out = pw;
        sc = new Scanner(System.in);
        hex = new StringBuilder("00000000");
        dec = 0;
        bin = "";
        outputStream = new DualOutputStream(System.out, out);
    }

    /**
     * to convert binary to decimal, it calls
     * inputBin(), toDec() and outDec()
     */
    public void binToDec(){
        dec = 0;
        bin = "";
        inputBin();
        toDec();
        outDec();
    }

    /**
     * to take binary number input, calls
     * validate() to validate input
     */
    private void inputBin(){
        outputStream.print("\nEnter a Binary number: ");
        String str = sc.nextLine();
        out.println(str);
        bin = validate(str);
    }

    /**
     * to validate input binary number
     * @param str input string
     * @return str validated String
     */
    private String validate(String str){

        if(str.matches("[01]+") && str.length() <= 32)
            return str;

        outputStream.println("**** Error: Must be a binary number " +
                "and length <= 32 !");
        outputStream.print("\nEnter again: ");
        str = sc.nextLine();
        out.println(str);
        return validate(str);
    }

    /**
     * converts hexadecimal to decimal
     */
    private void toDec(){
        int num = 0;
        for(int i=0;i<bin.length();i++){
            if(bin.charAt(i)== '1'){
                num=num+ (int)Math.pow(2,bin.length()-1-i);
            }

        }
        dec = num;
    }

    /**
     * prints out decimal number
     */
    private void outDec(){
        outputStream.println(dec);
    }

    /**
     * called to convert binary to hexadecimal,
     * it calls inputBin(), toHex() and outHex()
     */
    public void binToHex(){
        hex = new StringBuilder("00000000");
        bin = "";
        inputBin();
        toHex();
        outHex();
    }


    /**
     * converts decimal to hexadecimal
     */
    private void toHex(){
        String bin = String.format("%32s",this.bin).replace(' ','0');
        for(int i = 0; i < bin.length(); i+=4) {
            if (bin.substring(i, i + 4).equals("0000"))
                hex.setCharAt(i / 4, '0');
            else if (bin.substring(i, i + 4).equals("0001"))
                hex.setCharAt(i / 4, '1');
            else if (bin.substring(i, i + 4).equals("0010"))
                hex.setCharAt(i / 4, '2');
            else if (bin.substring(i, i + 4).equals("0011"))
                hex.setCharAt(i / 4, '3');
            else if (bin.substring(i, i + 4).equals("0100"))
                hex.setCharAt(i / 4, '4');
            else if (bin.substring(i, i + 4).equals("0101"))
                hex.setCharAt(i / 4, '5');
            else if (bin.substring(i, i + 4).equals("0110"))
                hex.setCharAt(i / 4, '6');
            else if (bin.substring(i, i + 4).equals("0111"))
                hex.setCharAt(i / 4, '7');
            else if (bin.substring(i, i + 4).equals("1000"))
                hex.setCharAt(i / 4, '8');
            else if (bin.substring(i, i + 4).equals("1001"))
                hex.setCharAt(i / 4, '9');
            else if (bin.substring(i, i + 4).equals("1010"))
                hex.setCharAt(i / 4, 'A');
            else if (bin.substring(i, i + 4).equals("1011"))
                hex.setCharAt(i / 4, 'B');
            else if (bin.substring(i, i + 4).equals("1100"))
                hex.setCharAt(i / 4, 'C');
            else if (bin.substring(i, i + 4).equals("1101"))
                hex.setCharAt(i / 4, 'D');
            else if (bin.substring(i, i + 4).equals("1110"))
                hex.setCharAt(i / 4, 'E');
            else if (bin.substring(i, i + 4).equals("1111"))
                hex.setCharAt(i / 4, 'F');

        }

    }

    /**
     * prints out the converted hexadecimal number
     */
    private void outHex(){
        outputStream.println(hex.toString());
    }
}
