import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;

public class Tokenizer{
    private String fileName = new String();
    private static Scanner globalSc;
    private static String tempString;
    private List<String> wordList = new ArrayList<>();

    public Tokenizer(String name) throws FileNotFoundException{
        this.fileName = name; 
        Scanner sc = new Scanner(new File(this.fileName));
        this.globalSc = sc;
    }

    protected Tokenizer(String[] line){
        List<String> tempArrayList = Arrays.asList(line);
        wordList.addAll(tempArrayList);
    }

    private static String[] normalize(){
        if(globalSc.hasNextLine()) tempString = globalSc.nextLine();
        String[] tempLine = tempString.split(Character.UnicodeBlock.GENERAL_PUNCTUATION.toString());
        for(int i = 0; i < tempLine.length; i++){
            tempLine[i].toLowerCase();
        }
        return tempLine;
    }

    protected ArrayList<String> wordList() throws FileNotFoundException{
        while(globalSc.hasNextLine()){
            Tokenizer tempToken = new Tokenizer(normalize());
        }
        return (ArrayList<String>) this.wordList;
    }
}