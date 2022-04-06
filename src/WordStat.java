import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class WordStat {
    List<String> wordList;
    HashTable wordFreqencyHashTable;
    HashTable wordPairFreqencyHashTable;
    Object[] wordRankIncrementEntries;
    Object[] wordRankDecrementEntries;
    Object[] wordPairIncrementEntries;
    ArrayList<Integer> wordRankEntriesNode = new ArrayList<>();
    ArrayList<Integer> wordPairRankEntriesNode = new ArrayList<>();    
    
    // everything should be initializing when the constructor is invoked. 
    public WordStat(String name) throws FileNotFoundException{
        Tokenizer fileTokenizer = new Tokenizer(name);
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
        int wordFreqencyValue = -1;
        int wordPairFreqencyValue = -1;
        Object[] tempArray = temp.toArray();
        Arrays.sort(tempArray);

        wordRankIncrementEntries = tempArray;
        for(int i = 0; i < tempArray.length; i++){
            if(((HashEntry) tempArray[i]).getValue() != wordFreqencyValue){
                wordRankEntriesNode.add(i);
                wordFreqencyValue = ((HashEntry) tempArray[i]).getValue();
            }
        }
        wordRankDecrementEntries = this.decrementArray(tempArray, wordRankEntriesNode);

        temp.clear();

        for(int i = 0; i < wordPairFreqencyHashTable.hashTable.length; i++){
            if(wordPairFreqencyHashTable.hashTable[i] != null) temp.add(wordPairFreqencyHashTable.hashTable[i]);
        }
        
        Object[] tempPair = temp.toArray();
        Arrays.sort(tempPair);

        for(int i = 0; i < tempPair.length; i++){
            if(((HashEntry) tempPair[i]).getValue() != wordPairFreqencyValue){
                wordPairRankEntriesNode.add(i);
                wordPairFreqencyValue = ((HashEntry) tempPair[i]).getValue();
            }
        }

        wordPairIncrementEntries = this.decrementArray(tempPair, wordPairRankEntriesNode);
    }

    public WordStat(String[] line) throws FileNotFoundException{
        Tokenizer fileTokenizer = new Tokenizer(line);
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
        int wordFreqencyValue = -1;
        int wordPairFreqencyValue = -1;
        Object[] tempArray = temp.toArray();
        Arrays.sort(tempArray);

        wordRankIncrementEntries = tempArray;
        for(int i = 0; i < tempArray.length; i++){
            if(((HashEntry) tempArray[i]).getValue() != wordFreqencyValue){
                wordRankEntriesNode.add(i);
                wordFreqencyValue = ((HashEntry) tempArray[i]).getValue();
            }
        }
        wordRankDecrementEntries = this.decrementArray(tempArray, wordRankEntriesNode);

        temp.clear();

        for(int i = 0; i < wordPairFreqencyHashTable.hashTable.length; i++){
            if(wordPairFreqencyHashTable.hashTable[i] != null) temp.add(wordPairFreqencyHashTable.hashTable[i]);
        }
        
        Object[] tempPair = temp.toArray();
        Arrays.sort(tempPair);

        for(int i = 0; i < tempPair.length; i++){
            if(((HashEntry) tempPair[i]).getValue() != wordPairFreqencyValue){
                wordPairRankEntriesNode.add(i);
                wordPairFreqencyValue = ((HashEntry) tempPair[i]).getValue();
            }
        }

        wordPairIncrementEntries = this.decrementArray(tempPair, wordPairRankEntriesNode);
    }
    // a private constructor that able to deal with List as a input. 
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
        int wordFreqencyValue = -1;
        Object[] tempArray = temp.toArray();
        Arrays.sort(tempArray);

        wordRankIncrementEntries = tempArray;
        for(int i = 0; i < tempArray.length; i++){
            if(((HashEntry) tempArray[i]).getValue() != wordFreqencyValue){
                wordRankEntriesNode.add(i);
                wordFreqencyValue = ((HashEntry) tempArray[i]).getValue();
            }
        }
        wordRankDecrementEntries = this.decrementArray(tempArray, this.wordRankEntriesNode);
    }
    /**
     * Count the time that a word appears. Return 0 if not appear
     * @param word
     * @return the time that a word appears. 
     */
    public int wordCount(String word){
        return wordFreqencyHashTable.get(word) == -1 ? 0 : wordFreqencyHashTable.get(word) + 1;
    }
/**
 * Count the time that a pair of word appears. Return 0 if not appear. 
 * @param w1
 * @param w2
 * @return the time that a pair of word appears. 
 */
    public int wordPairCount(String w1, String w2){
        return wordPairFreqencyHashTable.get(w1+w2) == -1 ? 0 : wordPairFreqencyHashTable.get(w1+w2) + 1;
    }

    /**
     * Give the rank that word had appeared. 
     * @param word
     * @return the rank that how many this word had appeared. 
     */
    public int wordRank(String word){
        for(int i = 0; i < wordRankIncrementEntries.length; i++){
            if(((HashEntry) wordRankIncrementEntries[i]).getKey().equals(word)) return wordRankIncrementEntries.length - i;
        }
        return 0;
    }

    /**
     * Give the rank that a pair of word had appeared. 
     * @param w1
     * @param w2
     * @return the rank that a pair of word had appeared. 
     */
    public int wordPairRank(String w1, String w2){
        String target = w1 + w2;
        for(int i = 0; i < wordPairIncrementEntries.length; i++){
            // if((wordPairIncrementEntries[i]).equals(target)) return i + 1;
        }
        return 0;
    }

    /**
     * return k-th of the most common words. 
     * @param k number of words
     * @return k words that are most common
     */
    public String[] mostCommonWords(int k){
        if(k < 1) return new String[1];
        int actualSize = (k > wordRankDecrementEntries.length) ? wordRankDecrementEntries.length : k;
        String[] kMostCommonWords = new String[actualSize];
        for(int i = 0; i < actualSize; i++){
            kMostCommonWords[i] = (String) ((wordRankDecrementEntries[i]));
        }
        return kMostCommonWords;
    }
    /**
     * return k-th of the least common words. 
     * @param k number of words
     * @return k words that are least common
     */
    public String[] leastCommonWords(int k){
        if(k < 1) return new String[1];
        int actualSize = (k > wordRankIncrementEntries.length) ? wordRankIncrementEntries.length : k;
        String[] kLeastCommonWords = new String[actualSize];
        for(int i = 0; i < actualSize; i++){
            kLeastCommonWords[i] = ((HashEntry) wordRankIncrementEntries[i]).getKey();
        }
        return kLeastCommonWords;
    }

    /**
     * return k-th of the most common word pairs. 
     * @param k number of words
     * @return k word pairs that are most common
     */
    public String[] mostCommonWordPairs(int k){
        if(k < 1) return new String[1];
        int actualSize = (k > wordPairIncrementEntries.length) ? wordPairIncrementEntries.length : k;
        String[] kMostCommonWordPairs = new String[actualSize];
        for(int i = 0; i < actualSize; i++){
            kMostCommonWordPairs[i] = ((String) wordPairIncrementEntries[i]);
        }
        return kMostCommonWordPairs;
    }

    /**
     * return k-th of the most common words that before or after the baseword. 
     * @param k number of words
     * @param baseword the word that used as base position
     * @param i integer that determine before or after
     * @return k words that are most common that before or after the baseword. 
     */
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

    private String[] decrementArray(Object[] line, ArrayList<Integer> node){
        String[] kMostCommonWords = new String[line.length];
        Object[] teminars = node.toArray();
        int firstTeminar = node.get(node.size() - 1);
        int iterations = 0;
        if(node.size() > 1){
            while(iterations < (line.length-firstTeminar)){
                if(iterations < line.length) kMostCommonWords[iterations] = ((HashEntry) line[firstTeminar + iterations]).getKey();
                iterations++;
            }
            for(int i = (int) teminars.length - 2; i >= 0; i--){
                for(int j = (int) teminars[i]; j < (int)teminars[i + 1]; j++){
                    if(iterations < line.length){ 
                        kMostCommonWords[iterations] = ((HashEntry) line[j]).getKey();
                        iterations++;
                    }
                }
            }
    
        } else if(node.size() == 1) {
            for(int i = 0; i < line.length; i++){
                kMostCommonWords[i] = ((HashEntry) line[line.length - i - 1]).getKey();
            }
        }
        return kMostCommonWords;
    }

}
