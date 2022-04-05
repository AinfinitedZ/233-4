public class App {
    public static void main(String[] args) throws Exception {
        WordStat ws1984 = new WordStat("/Users/daniel.l/Code/git/233-4/233-4/src/First_Chapter_of_1984.txt");
        int wordCountThe = ws1984.wordCount("winston");
        System.out.println("The count of word 'the' is " + wordCountThe);
        int wordPairCount = ws1984.wordPairCount("ministry", "of");
        System.out.println("The count of word pair 'ministry of' is " + wordPairCount);
        int wordRank = ws1984.wordRank("brother");
        System.out.println("The rank of word 'brother' is " + wordRank);
        String[] mostCommonWordPairs = ws1984.mostCommonWordPairs(10);
        System.out.print("Ten most common word pairs are : ");
        for(int i = 0; i < 10; i++){
            System.out.print(mostCommonWordPairs[i] + ", ");
        }
        System.out.print("\n");
        System.out.print("Ten most common words are : ");
        String[] mostCommonWords = ws1984.mostCommonWords(10);
        for(int i = 0; i < 10; i++){
            System.out.print(mostCommonWords[i] + ", ");
        }
        System.out.print("\n");
        System.out.print("Ten least common words are : ");
        String[] leastCommonWords = ws1984.leastCommonWords(10);
        for(int i = 0; i < 10; i++){
            System.out.print(leastCommonWords[i] + ", ");
        }
        System.out.print("\n");
        System.out.print("Ten Collocations after baseword 'oil' are : ");
        String[] mostCommonCollocsAfter = ws1984.mostCommonCollocs(10, "oil", 1);
        for(int i = 0; i < 10; i++){
            System.out.print(mostCommonCollocsAfter[i] + ", ");
        }
        System.out.print("\n");
        System.out.print("Ten Collocations before baseword 'oil' are : ");
        String[] mostCommonCollocsBefore = ws1984.mostCommonCollocs(10, "oil", -1);
        for(int i = 0; i < 10; i++){
            System.out.print(mostCommonCollocsBefore[i] + ", ");
        }
        System.out.print("\n");

    }
}
