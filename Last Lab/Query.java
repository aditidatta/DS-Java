import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.util.Map.Entry;

/**
 * Query class.
 * @author Aditi Datta
 */
public class Query {
    private PrintWriter pw;
    private DualOutputStream dualOut;
    private HashTable<String, Integer> omitted = new HashTable<String, Integer>(37);
    private ObjectBinaryTree bst = new ObjectBinaryTree();

    /**
     * Creates a Query class object
     * @param pw PrintWriter
     * @param dualOut DualOutputStream
     */
    public Query(PrintWriter pw, DualOutputStream dualOut){
        this.pw = pw;
        this.dualOut = dualOut;
    }

    /**
     * Reads the omitted words from a file and stores them in a hash
     * table
     * @param fileName String file name
     * @throws IOException File I/O Error
     */
    public void loadOmitted(String fileName) throws IOException{
        Scanner omittedFile = new Scanner(new File(fileName));
        while (omittedFile.hasNext()) {
            String omittedWord = omittedFile.nextLine().trim().toLowerCase();
            omitted.put(omittedWord, 1);
        }
    }

    /**
     * Prints the omitted words from the hash table
     */
    public void printHashTable(){
        dualOut.println("Omitted words loaded into a hash table: ");
        for (Entry<String, Integer> entry : omitted.entrySet()){
            dualOut.println(entry.getKey());
        }
        dualOut.println("");
        dualOut.println("Number of collisions at first try: "+
                omitted.getNumberOfCollisions());
        dualOut.println("");
        dualOut.println("Total number of Probes needed to handle all the" +
                " collisions: " + omitted.getNumberOfProbes());
        dualOut.println("");
    }

    /**
     * Reads words from a text file and creates indices for the words
     * @param fileName String
     * @throws IOException File I/O Error
     */
    public void readFile(String fileName) throws IOException{
        Scanner textFile = new Scanner(new File(fileName));
        String regex = "[[ ]*|[,]*|[\\.]*|[:]*|[;]*|[/]*|[!]*|[?]*|[+]*]+";
        int lineNumber = 0;
        while (textFile.hasNextLine()) {
            lineNumber++;
            String buffer = textFile.nextLine();
            String[] tokens = buffer.split(regex);
            for (int i = 0; i < tokens.length; i++) {
                if (!tokens[i].equals("-")) {
                    String token = tokens[i].toLowerCase();
                    if (omitted.get(token) == null) {
                        Word word = new Word(token, lineNumber, i+1,
                                dualOut);
                        bst.insertBSTDup(word);
                    }
                }
            }
        }
    }

    /**
     * Prints the indices of the words
     */
    public void printIndex(){
        bst.inTrav(bst.getRoot());
        dualOut.println("");
    }

    /**
     * Searches for a word and prints out the indices if found
     * @param s String
     */
    public void query(String s){
        Word word = new Word(s.toLowerCase(), dualOut);
        ObjectTreeNode found = bst.searchBST(word);
        if(found != null){
            dualOut.println("Found:\n" + found.getInfo());
        }
        else
            dualOut.println("Not Found!");
        dualOut.println("");
    }

}
