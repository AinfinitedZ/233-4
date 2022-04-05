import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;

public class Tokenizer{
    private String fileName = new String();
    private Scanner globalSc;
    private String tempString = new String("");
    private ArrayList<String> normailizeStrings;
    private ArrayList<String> wordList = new ArrayList<>();

    public Tokenizer(String name) throws FileNotFoundException{
        this.fileName = name; 
        Scanner sc = new Scanner(new File(this.fileName));
        while(sc.hasNextLine()){
            this.globalSc = sc;
            normailizeStrings = this.normailize();
            wordList.addAll(normailizeStrings);
        }
    }

    protected Tokenizer(String[] line){ 
        ArrayList<String> actualLine = new ArrayList<>();
        for(int j = 0; j < line.length; j++){
            tempString = tempString + " " + line[j];
        }
        String[] spiltStrings = tempString.split("[^A-Za-z]");
        for(int i = 0; i < spiltStrings.length; i++){
            if(!spiltStrings[i].equals("")){
                actualLine.add(spiltStrings[i].toLowerCase());
            }
        }
        wordList.addAll(actualLine);
    }

    protected ArrayList<String> normailize(){
        if(globalSc.hasNextLine()) tempString = globalSc.nextLine();
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
        return (ArrayList<String>) this.wordList;
    }
}