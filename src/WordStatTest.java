import org.junit.Test;

import static org.junit.Assert.*;


public class WordStatTest {
	/**
	 * The sample text I have used in this class is, 
	 * This is an testLine with WORD that represent normailizing. the the the Some   word wi!th punct.ations betweens.
	 * As you can see, there are 3 'the' and 2 'word' in the sample text. 
	 * There are 2 'the the', and 1 'it was', as shown in testWordPairCount(). 
	 * 
	 */
	@Test
	public void testWordCount() throws Exception {
		WordStat demoWordStat = new WordStat(new String[] {"This", "is", "an", "testLine", "with", "WORD", "that", "represent", "normailizing. ", "the", "the", "the" ,"Some ", " word", "wi!th", "punct.ations", "between."});
		Integer countOfThe = demoWordStat.wordCount("the");
		// there should be 3 'the' in the sample line. 
		assertTrue(countOfThe.equals(3));
		// there should be 0 'aaaa' in the sample text. 
		Integer countOfUnexist = demoWordStat.wordCount("aaaa");
		assertTrue(countOfUnexist.equals(0));
	}

	@Test
	public void testWordPairCount() throws Exception {
		WordStat demoWordStat = new WordStat(new String[] {"This", "is", "an", "testLine", "with", "WORD", "that", "represent", "normailizing. ", "the", "the", "the" ,"Some ", " word", "wi!th", "punct.ations", "between."});		
		Integer countOfIsAn = demoWordStat.wordPairCount("is", "an");
		// there should be 1 'it was' in the sample text. 
		assertTrue(countOfIsAn.equals(1));
		// there should be 0 'aaaa bbbb' in the sample text.
		Integer countOfAAAABBBB = demoWordStat.wordPairCount("aaaa","bbbb");
		assertTrue(countOfAAAABBBB.equals(0));

	}

	@Test
	public void testWordRank() throws Exception {
		WordStat demoWordStat = new WordStat(new String[] {"This", "is", "an", "testLine", "with", "WORD", "that", "represent", "normailizing. ", "the", "the", "the" ,"Some ", " word", "wi!th", "punct.ations", "between."});		
		// there are 3 'the'. As the first place of the word freqency
		int countOfThe = demoWordStat.wordRank("the");
		assertEquals(1, countOfThe);
		// there are 2 'word'. As the second place of the word freqency
		int countOfWord = demoWordStat.wordRank("word");
		assertEquals(2, countOfWord);
		// test for unexisted word
		Integer countOfAAAA = demoWordStat.wordRank("aaaa");
		assertTrue(countOfAAAA.equals(0));
	}

	@Test
	public void testWordPairRank() throws Exception {
		WordStat demoWordStat = new WordStat(new String[] {"This", "is", "an", "testLine","with", "WORD", "that", "represent", "normailizing. ", "the", "the", "the" ,"Some ", " word", "wi!th", "punct.ations", "between."});		
		// most common word pair should be "the the"
		int countOfTheThe = demoWordStat.wordPairRank("the", "the");
		assertEquals(countOfTheThe, 1);
		// second common word pair should be "an testline"
		int countOfIsAn = demoWordStat.wordPairRank("an","testline");
		assertEquals(countOfIsAn, 2);
		// unreasonbale input should get a value of 0.
		Integer countOfAaAa = demoWordStat.wordPairRank("aa", "aa");
		assertTrue(countOfAaAa.equals(0));
	}

	@Test
	public void testMostCommonWords() throws Exception {
		WordStat demoWordStat = new WordStat(new String[] {"This", "is", "an", "testLine","with", "WORD", "that", "represent", "normailizing. ", "the", "the", "the" ,"Some ", " word", "wi!th", "punct.ations", "between."});		
		// most common word should be "the"
		String[] MostCommonWordAlpha1 = demoWordStat.mostCommonWords(19);
		String[] MostCommonWord1 = demoWordStat.mostCommonWords(1);
		assertEquals("the", MostCommonWord1[0]);
		// most two common words should be "the" and "word".
		String[] MostCommonWord2 = demoWordStat.mostCommonWords(2);
		assertEquals("the", MostCommonWord1[0]);
		assertEquals("word", MostCommonWord2[1]);
		// exceed input would result a fixed size array
		String[] MostCommonWordAlpha = demoWordStat.mostCommonWords(19);
		assertEquals("an", MostCommonWordAlpha[2]);
		assertEquals("ations", MostCommonWordAlpha[3]);
		// unreasonable input should get an empty object to avoid NullPointerException.
		String[] MostCommonWord0 = demoWordStat.mostCommonWords(-1);
		assertEquals(null, MostCommonWord0[0]);
	}

	@Test
	public void testLeastCommonWords() throws Exception {
		WordStat demoWordStat = new WordStat(new String[] {"This", "is", "an", "testLine","with", "WORD", "that", "represent", "normailizing. ", "the", "the", "the" ,"Some ", " word", "wi!th", "punct.ations", "between."});		
		// the least Common Word should be "th" 
		String[] leastCommonWord1 = demoWordStat.leastCommonWords(1);
		assertEquals("an", leastCommonWord1[0]);
		// the second least common word should be "some".
		String[] leastCommonWord2 = demoWordStat.leastCommonWords(2);
		assertEquals("an", leastCommonWord2[0]);
		assertEquals("ations", leastCommonWord2[1]);
		// unreasonable input should get an empty object to avoid NullPointerException
		String[] leastCommonWord0 = demoWordStat.leastCommonWords(-1);
		assertEquals(null, leastCommonWord0[0]);
	}

	@Test
	public void testMostCommonWordPairs() throws Exception {
		WordStat demoWordStat = new WordStat(new String[] {"This", "is", "an", "testLine","with", "WORD", "that", "represent", "normailizing. ", "the", "the", "the" ,"Some ", " word", "wi!th", "punct.ations", "between."});		
		// the most common word pair should be "thethe", as before
		String[] mostCommonWordPair1 = demoWordStat.mostCommonWordPairs(19);
		assertEquals("thethe", mostCommonWordPair1[0]);
		// the second common word pair should be "wordwi", as before
		String[] mostCommonWordPair2 = demoWordStat.mostCommonWordPairs(2);
		assertEquals("antestline", mostCommonWordPair2[1]);
		// unreasonable input should get an empty object to avoid NullPointerException. 
		String[] mostCommonWordPair0 = demoWordStat.mostCommonWordPairs(-1);
		assertEquals(null, mostCommonWordPair0[0]);
	}

	@Test
	public void testMostCommonCollocs() throws Exception {
		WordStat demoWordStat = new WordStat(new String[] {"This", "is", "an", "testLine","with", "WORD", "that", "represent", "normailizing. ", "the", "the", "the" ,"Some ", " word", "wi!th", "punct.ations", "between."});		
		String[] mostcommonCollocsBeforeSignature = demoWordStat.mostCommonCollocs(3, "represent", -1);
		String[] mostcommonCollocsAfterSignature = demoWordStat.mostCommonCollocs(3, "represent", 1);
		assertEquals("word", mostcommonCollocsBeforeSignature[0]);		
		assertEquals("with", mostcommonCollocsBeforeSignature[1]);
		assertEquals("this", mostcommonCollocsBeforeSignature[2]);
		assertEquals("the", mostcommonCollocsAfterSignature[0]);
		assertEquals("ations", mostcommonCollocsAfterSignature[1]);
		assertEquals("between", mostcommonCollocsAfterSignature[2]);
		// unreasonable input of base word. 
		String[] unreasonableInput1 = demoWordStat.mostCommonCollocs(10, "aaaa", 1);
		assertEquals(null, unreasonableInput1[0]);
		// unreasonable input of i-value
		String[] unreasonableInput2 = demoWordStat.mostCommonCollocs(10, "thousand", 5);
		assertEquals(null, unreasonableInput2[0]);
	}

}
