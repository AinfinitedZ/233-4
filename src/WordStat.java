import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordStat {
    List<String> wordList;
    HashTable wordFreqencyHashTable;
    HashTable wordPairFreqencyHashTable;
    Object[] wordRankEntries;
    Object[] wordPairRankEntries;
    String name;

    public WordStat(String name) throws FileNotFoundException{
        Tokenizer fileTokenizer = new Tokenizer(name);
        this.name = name;
        wordList = fileTokenizer.wordList();
        this.wordFreqencyHashTable = new HashTable();
        this.wordPairFreqencyHashTable = new HashTable();
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
        // Add a filter before actually sort the whole array. 
        ArrayList<HashEntry> temp = new ArrayList<>();
        for(int i = 0; i < wordFreqencyHashTable.hashTable.length; i++){
            if(wordFreqencyHashTable.hashTable[i] != null) temp.add(wordFreqencyHashTable.hashTable[i]);
        }
        Object[] tempArray = temp.toArray();
        Arrays.sort(tempArray);
        wordRankEntries = tempArray;

        temp.clear();

        for(int i = 0; i < wordPairFreqencyHashTable.hashTable.length; i++){
            if(wordPairFreqencyHashTable.hashTable[i] != null) temp.add(wordPairFreqencyHashTable.hashTable[i]);
        }
        Object[] tempPair = temp.toArray();
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

    private WordStat(List<String> array) throws FileNotFoundException{
        this.wordList = array;
        this.wordFreqencyHashTable = new HashTable();
        for(String i : wordList){
            if(wordFreqencyHashTable.get(i) == -1){
                wordFreqencyHashTable.put(i, 0);
            } else {
                wordFreqencyHashTable.update(i, wordFreqencyHashTable.get(i) + 1);
            }
        }
        ArrayList<HashEntry> temp = new ArrayList<>();
        for(int i = 0; i < wordFreqencyHashTable.hashTable.length; i++){
            if(wordFreqencyHashTable.hashTable[i] != null) temp.add(wordFreqencyHashTable.hashTable[i]);
        }
        Object[] tempArray = temp.toArray();
        Arrays.sort(tempArray);
        wordRankEntries = tempArray;
    }
    
    public int wordCount(String word){
        return wordFreqencyHashTable.get(word) == -1 ? 0 : wordFreqencyHashTable.get(word) + 1;
    }

    public int wordPairCount(String w1, String w2){
        return wordPairFreqencyHashTable.get(w1+w2) == -1 ? 0 : wordPairFreqencyHashTable.get(w1+w2) + 1;
    }

    public int wordRank(String word){
        for(int i = 0; i < wordRankEntries.length; i++){
            if(((HashEntry) wordRankEntries[i]).getKey().equals(word)) return wordRankEntries.length - i;
        }
        return 0;
    }

    public int wordPairRank(String w1, String w2){
        String target = w1 + w2;
        for(int i = 0; i < wordPairRankEntries.length; i++){
            if(((HashEntry) wordPairRankEntries[i]).getKey().equals(target)) return wordPairRankEntries.length - i;
        }
        return 0;
    }

    public String[] mostCommonWords(int k){
        if(k < 1) return new String[1];
        String[] kMostCommonWords = new String[k];
        for(int i = 0; i < k; i++){
            kMostCommonWords[i] = ((HashEntry) wordRankEntries[wordRankEntries.length - i - 1]).getKey();
        }
        return kMostCommonWords;
    }

    public String[] leastCommonWords(int k){
        if(k < 1) return new String[1];
        String[] kLeastCommonWords = new String[k];
        for(int i = 0; i < k; i++){
            kLeastCommonWords[i] = ((HashEntry) wordRankEntries[i]).getKey();
        }
        return kLeastCommonWords;
    }

    public String[] mostCommonWordPairs(int k){
        if(k < 1) return new String[1];
        String[] kMostCommonWordPairs = new String[k];
        for(int i = 0; i < k; i++){
            kMostCommonWordPairs[i] = ((HashEntry) wordPairRankEntries[wordPairRankEntries.length - i - 1]).getKey();
        }
        return kMostCommonWordPairs;
    }

    public String[] mostCommonCollocs(int k, String baseWord, int i) throws FileNotFoundException{
        if(Math.abs(i) != 1 || !wordList.contains(baseWord)) return new String[1];
        int firstLocation = wordList.indexOf(baseWord);
        List<String> kArrayList = new ArrayList<>();
        if(i == -1){
            kArrayList = wordList.subList(0, firstLocation);
        } else if (i == 1){
            kArrayList = wordList.subList(firstLocation, wordList.size());
        }
        WordStat tempStat = new WordStat(kArrayList);
        return tempStat.mostCommonWords(k);
    }
}
