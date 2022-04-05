import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;

public class Tokenizer{
    private Scanner globalSc;
    private String tempString = new String("");
    private ArrayList<String> normailizeStrings;
    private ArrayList<String> wordList = new ArrayList<>();

    public Tokenizer(String name) throws FileNotFoundException{
        // Scanner used to read file by one's path name. 
        Scanner sc = new Scanner(new File(name));
        while(sc.hasNextLine()){
            this.globalSc = sc;
            normailizeStrings = this.normailize();
            wordList.addAll(normailizeStrings);
        }
    }

    protected Tokenizer(String[] line){ 
        ArrayList<String> actualLine = new ArrayList<>();
        // use in test constructor only. Refine the input to String. 
        for(int j = 0; j < line.length; j++){
            tempString = tempString + " " + line[j];
        }
        // use regular expression to filtrate every character except A-Z, a-z.
        String[] spiltStrings = tempString.split("[^A-Za-z]");
        for(int i = 0; i < spiltStrings.length; i++){
            if(!spiltStrings[i].equals("")){
                actualLine.add(spiltStrings[i].toLowerCase());
            }
        }
        wordList.addAll(actualLine);
    }

    protected ArrayList<String> normailize(){
        // scan the next line if existed. 
        if(globalSc.hasNextLine()) tempString = globalSc.nextLine();
        // use regular expression to filtrate every character except A-Z, a-z.
        String[] tempLine = tempString.split("[^A-Za-z]");
        ArrayList<String> actualLine = new ArrayList<>();
        for(int i = 0; i < tempLine.length; i++){
            if(!tempLine[i].equals("")){
                actualLine.add(tempLine[i].toLowerCase());
            }
        }
        return actualLine;
    }

    protected ArrayList<String> wordList() throws FileNotFoundException{
        return this.wordList;
    }
}