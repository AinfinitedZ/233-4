import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;

public class Tokenizer{
    private String fileName = new String();
    private static Scanner globalSc;
    private static String[] globalLine;
    private static String tempString;
    private List<String> wordList = new ArrayList<>();

    public Tokenizer(String name) throws FileNotFoundException{
        this.fileName = name; 
        Scanner sc = new Scanner(new File(this.fileName));
        this.globalSc = sc;
        normalize();
        
    }

    protected Tokenizer(String[] line){
        List<String> tempArrayList = Arrays.asList(globalLine);
        wordList = tempArrayList;
        normalize();
    }

    private static void normalize(){
        if(globalSc.hasNextLine()) tempString = globalSc.nextLine();
        globalLine = tempString.split(Character.UnicodeBlock.GENERAL_PUNCTUATION.toString());
        for(int i = 0; i < globalLine.length; i++){
            globalLine[i].toLowerCase();
        }
    }

    protected ArrayList<String> wordList(){
        return (ArrayList<String>) this.wordList;
    }
}