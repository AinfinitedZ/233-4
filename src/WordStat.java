import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;

public class WordStat {
    ArrayList<String> wordList;
    HashTable wordFreqencyHashTable;
    HashTable wordPairFreqencyHashTable;
    HashEntry[] wordRankEntries;
    HashEntry[] wordPairRankEntries;

    public WordStat(String name) throws FileNotFoundException{
        Tokenizer fileTokenizer = new Tokenizer(name);
        wordList = fileTokenizer.wordList();
        for(String i : wordList){
            if(wordFreqencyHashTable.get(i) == -1){
                wordFreqencyHashTable.put(i, 0);
            } else {
                wordFreqencyHashTable.update(i, wordFreqencyHashTable.get(i) + 1);
            }
        }
        for(int i = 0; i < wordList.size() - 1; i++){
            String temp = wordList.get(i) + wordList.get(i + 1);
            if(wordPairFreqencyHashTable.get(temp) == -1){
                wordPairFreqencyHashTable.put(temp, 0);
            } else {
                wordPairFreqencyHashTable.update(temp, wordPairFreqencyHashTable.get(temp) + 1);
            }
        }
        HashEntry[] temp = wordFreqencyHashTable.hashTable;
        Arrays.sort(temp);
        wordRankEntries = temp;
        HashEntry[] tempPair = wordPairFreqencyHashTable.hashTable;
        Arrays.sort(tempPair);
        wordPairRankEntries = tempPair;
    }

    public WordStat(String[] line) throws FileNotFoundException{
        Tokenizer fileTokenizer = new Tokenizer(line);
        wordList = fileTokenizer.wordList();
        for(String i : wordList){
            if(wordFreqencyHashTable.get(i) == -1){
                wordFreqencyHashTable.put(i, 0);
            } else {
                wordFreqencyHashTable.update(i, wordFreqencyHashTable.get(i) + 1);
            }
        }
    }

    public int wordCount(String word){
        return wordFreqencyHashTable.get(word) == -1 ? 0 : wordFreqencyHashTable.get(word);
    }

    public int wordPairCount(String w1, String w2){
        return wordPairFreqencyHashTable.get(w1+w2) == -1 ? 0 : wordPairFreqencyHashTable.get(w1+w2);
    }

    public int wordRank(String word){
        for(int i = 0; i < wordRankEntries.length; i++){
            if(wordRankEntries[i].getKey().equals(word)) return i+1;
        }
        return 0;
    }

    public int wordPairRank(String w1, String w2){
        String target = w1 + w2;
        for(int i = 0; i < wordPairRankEntries.length; i++){
            if(wordPairRankEntries[i].getKey().equals(target)) return i+1;
        }
        return 0;
    }

    public String[] mostCommonWords(int k){
        String[] kMostCommonWords = new String[k];
        for(int i = 0; i < k; i++){
            kMostCommonWords[i] = wordRankEntries[i].getKey();
        }
        return kMostCommonWords;
    }

    public String[] leastCommonWords(int k){
        String[] kLeastCommonWords = new String[k];
        for(int i = wordRankEntries.length; i > k; i--){
            kLeastCommonWords[i] = wordRankEntries[i].getKey();
        }
        return kLeastCommonWords;
    }

    public String[] mostCommonWordPairs(int k){
        String[] kMostCommonWordPairs = new String[k];
        for(int i = 0; i < k; i++){
            kMostCommonWordPairs[i] = wordPairRankEntries[i].getKey();
        }
        return kMostCommonWordPairs;
    }

    public String[] mostCommonCollocs(int k, String baseWord, int i){
        String[] kMostCommonCollocs = new String[k];
        int location = wordCount(baseWord);
        int position = 0;
        while(k > 0 && k < wordRankEntries.length && position < k){
            kMostCommonCollocs[position] = wordRankEntries[location].getKey();
            location = location + i;
            position++;
        }  
        return kMostCommonCollocs;
    }
    
}
