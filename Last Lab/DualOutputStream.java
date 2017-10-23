

import java.io.PrintStream;
import java.io.PrintWriter;

/**
 * class DualOutputStream can be used to print data to
 * both the console and file using FileWriter object
 */
public class DualOutputStream {

    PrintStream out1;
    PrintWriter out2;

    /**
     * Constructor
     * @param out1 PrintStream object - a reference to System.out
     * @param out2 PrintWriter object
     */
    public DualOutputStream(PrintStream out1, PrintWriter out2){
        this.out1 = out1;
        this.out2 = out2;
    }


    /**
     * prints to console (System.out.print()) and
     * to File (using FileWriter object's print())
     * @param msg int message to be printed
     */
    public void print(Object msg){
        out1.print(msg);
        out2.print(msg);
    }

    /**
     * prints to console (System.out.println()) and
     * to File (using FileWriter object's println()) with a
     * next line
     * @param msg int message to be printed
     */
    public void println(Object msg){
        out1.println(msg);
        out2.println(msg);
    }

    /**
     * prints to console (System.out.print()) and
     * to File (using FileWriter object's print())
     * @param msg int message to be printed
     */
    public void print(int msg){
        out1.print(msg);
        out2.print(msg);
    }

    /**
     * prints to console (System.out.println()) and
     * to File (using FileWriter object's println()) with a
     * next line
     * @param msg int message to be printed
     */
    public void println(int msg){
        out1.println(msg);
        out2.println(msg);
    }

    /**
     * prints to console (System.out.print()) and
     * to File (using FileWriter object's print())
     * @param msg int message to be printed
     */
    public void print(float msg){
        out1.print(msg);
        out2.print(msg);
    }

    /**
     * prints to console (System.out.println()) and
     * to File (using FileWriter object's println()) with a
     * next line
     * @param msg int message to be printed
     */
    public void println(float msg){
        out1.println(msg);
        out2.println(msg);
    }

    /**
     * prints to console (System.out.print()) and
     * to File (using FileWriter object's print())
     * @param msg int message to be printed
     */
    public void print(double msg){
        out1.print(msg);
        out2.print(msg);
    }

    /**
     * prints to console (System.out.println()) and
     * to File (using FileWriter object's println()) with a
     * next line
     * @param msg int message to be printed
     */
    public void println(double msg){
        out1.println(msg);
        out2.println(msg);
    }

    /**
     * prints to console (System.out.print()) and
     * to File (using FileWriter object's print())
     * @param msg int message to be printed
     */
    public void print(char msg){
        out1.print(msg);
        out2.print(msg);
    }

    /**
     * prints to console (System.out.println()) and
     * to File (using FileWriter object's println()) with a
     * next line
     * @param msg int message to be printed
     */
    public void println(char msg){
        out1.println(msg);
        out2.println(msg);
    }

    /**
     * prints to console (System.out.print()) and
     * to File (using FileWriter object's print())
     * @param msg int message to be printed
     */
    public void print(long msg){
        out1.print(msg);
        out2.print(msg);
    }

    /**
     * prints to console (System.out.println()) and
     * to File (using FileWriter object's println()) with a
     * next line
     * @param msg int message to be printed
     */
    public void println(long msg){
        out1.println(msg);
        out2.println(msg);
    }

    /**
     * Returns a reference to the PrintWriter object it holds.
     * @return PrintWriter reference
     */
    public PrintWriter getPrintWriterObj(){
        return out2;
    }

}
