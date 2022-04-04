import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;

public class Tokenizer{
    private String fileName = new String();
    private Scanner globalSc;
    private String tempString;
    private String[] normailizeStrings;
    private List<String> wordList = new ArrayList<>();

    public Tokenizer(String name) throws FileNotFoundException{
        this.fileName = name; 
        Scanner sc = new Scanner(new File(this.fileName));
        while(sc.hasNextLine()){
            this.globalSc = sc;
            normailizeStrings = this.normailize();
            List<String> tempArrayList = Arrays.asList(normailizeStrings);
            wordList.addAll(tempArrayList);
        }
    }

    protected Tokenizer(String[] line){
        for(int i = 0; i < line.length; i++){
            line[i] = line[i].trim();
            line[i].toLowerCase();
        }
        normailizeStrings = line;
        List<String>tempArrayList = Arrays.asList(normailizeStrings);
        wordList.addAll(tempArrayList);
    }

    protected String[] normailize(){
        if(globalSc.hasNextLine()) tempString = globalSc.nextLine();
        String[] tempLine = tempString.split("[^A-Za-z]");
        for(int i = 0; i < tempLine.length; i++){
            tempLine[i] = tempLine[i].trim();
            tempLine[i].toLowerCase();
        }
        return tempLine;
    }

    protected ArrayList<String> wordList() throws FileNotFoundException{
        return (ArrayList<String>) this.wordList;
    }
}