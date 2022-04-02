import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;

public class WordStat {
    ArrayList<String> wordList;
    HashTable wordFreqencyHashTable;
    HashEntry[] wordRankArray;

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
        HashEntry[] temp = wordFreqencyHashTable.hashTable;
        Arrays.sort(temp);
        wordRankArray = temp;
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
        int freqencyW1W2 = 0;
        for(int i = 0; i < wordList.size(); i++){
            if(wordList.get(i).equals(w1) && wordList.get(i+1).equals(w2)){
                freqencyW1W2++;
            }
        }
        return freqencyW1W2;
    }

    public int wordRank(String word){
        for(int i = 0; i < wordRankArray.length; i++){
            if(wordRankArray[i].getKey().equals(word)) return i+1;
        }
        return 0;
    }

    public int wordPairRank(String w1, String w2){
        int pairCount = this.wordPairCount(w1, w2);
        for(int i = 0; i < wordRankArray.length; i++){
            if(wordRankArray[i].getValue() < pairCount) return i+1;
        }
        return 0;
    }

    public String[] mostCommonWords(int k){
        String[] kCommonWords = new String[k];
        for(int i = 0; i < k; i++){
            kCommonWords[i] = wordRankArray[i].getKey();
        }
        return kCommonWords;
    }

}
