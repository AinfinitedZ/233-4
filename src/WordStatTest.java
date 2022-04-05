import org.junit.Test;

import static org.junit.Assert.*;


public class WordStatTest {
	@Test
	public void testWordCount() throws Exception {
		WordStat demoWordStat = new WordStat("/Users/daniel.l/Code/git/233-4/233-4/src/First_Chapter_of_1984.txt");
		Integer countOfThe = demoWordStat.wordCount("the");
		// there should be 431 'the' in the sample text. 
		assertTrue(countOfThe.equals(431));
		// there should be 0 'aaaa' in the sample text. 
		Integer countOfUnexist = demoWordStat.wordCount("aaaa");
		assertTrue(countOfUnexist.equals(0));
	}

	@Test
	public void testWordPairCount() throws Exception {
		WordStat demoWordStat = new WordStat("/Users/daniel.l/Code/git/233-4/233-4/src/First_Chapter_of_1984.txt");
		Integer countOfItWas = demoWordStat.wordPairCount("it", "was");
		// there should be 58 'it was' in the sample text. 
		assertTrue(countOfItWas.equals(58));
		// there should be 0 'aaaa bbbb' in the sample text.
		Integer countOfAAAABBBB = demoWordStat.wordPairCount("aaaa","bbbb");
		assertTrue(countOfAAAABBBB.equals(0));

	}

	@Test
	public void testWordRank() throws Exception {
		WordStat demoWordStat = new WordStat("/Users/daniel.l/Code/git/233-4/233-4/src/First_Chapter_of_1984.txt");
		// there are 481 'the'. As the first place of the word freqency
		Integer countOfThe = demoWordStat.wordRank("the");
		assertTrue(countOfThe.equals(1));
		// there are 231 'of'. As the second place of the word freqency
		Integer countOfOf = demoWordStat.wordRank("of");
		assertTrue(countOfOf.equals(2));
		// test for unexisted word
		Integer countOfAAAA = demoWordStat.wordRank("aaaa");
		assertTrue(countOfAAAA.equals(0));
	}

	@Test
	public void testWordPairRank() throws Exception {
		WordStat demoWordStat = new WordStat("/Users/daniel.l/Code/git/233-4/233-4/src/First_Chapter_of_1984.txt");
		// most common word pair should be "it was"
		Integer countOfItWas = demoWordStat.wordPairRank("it", "was");
		assertTrue(countOfItWas.equals(1));
		// second common word pair should be "of the"
		Integer countOfOfThe = demoWordStat.wordPairRank("of","the");
		assertTrue(countOfOfThe.equals(2));
		// unreasonbale input should get a value of 0.
		Integer countOfAaAa = demoWordStat.wordPairRank("aa", "aa");
		assertTrue(countOfAaAa.equals(0));
	}

	@Test
	public void testMostCommonWords() throws Exception {
		WordStat demoWordStat = new WordStat("/Users/daniel.l/Code/git/233-4/233-4/src/First_Chapter_of_1984.txt");
		// most common word should be "the"
		String[] MostCommonWord1 = demoWordStat.mostCommonWords(1);
		assertEquals("the", MostCommonWord1[0]);
		// most two common words should be "the" and "of".
		String[] MostCommonWord2 = demoWordStat.mostCommonWords(2);
		assertEquals("the", MostCommonWord1[0]);
		assertEquals("of", MostCommonWord2[1]);
		// unreasonable input should get an empty object to avoid NullPointerException.
		String[] MostCommonWord0 = demoWordStat.mostCommonWords(-1);
		assertEquals(null, MostCommonWord0[0]);
	}

	@Test
	public void testLeastCommonWords() throws Exception {
		WordStat demoWordStat = new WordStat("/Users/daniel.l/Code/git/233-4/233-4/src/First_Chapter_of_1984.txt");
		// the least Common Word should be "letin" 
		// (Although it seems to be 'let' and 'in', but 'letin' did exist in the first Chapter of 1984 )
		String[] leastCommonWord1 = demoWordStat.leastCommonWords(1);
		assertEquals("letin", leastCommonWord1[0]);
		// the second least common word should be "confidence".
		String[] leastCommonWord2 = demoWordStat.leastCommonWords(2);
		assertEquals("confidence", leastCommonWord2[1]);
		// unreasonable input should get an empty object to avoid NullPointerException
		String[] leastCommonWord0 = demoWordStat.leastCommonWords(-1);
		assertEquals(null, leastCommonWord0[0]);
	}

	@Test
	public void testMostCommonWordPairs() throws Exception {
		WordStat demoWordStat = new WordStat("/Users/daniel.l/Code/git/233-4/233-4/src/First_Chapter_of_1984.txt");
		// the most common word pair should be "itwas", as before
		String[] mostCommonWordPair1 = demoWordStat.mostCommonWordPairs(1);
		assertEquals("itwas", mostCommonWordPair1[0]);
		// the second common word pair should be "ofthe", as before
		String[] mostCommonWordPair2 = demoWordStat.mostCommonWordPairs(2);
		assertEquals("ofthe", mostCommonWordPair2[1]);
		// unreasonable input should get an empty object to avoid NullPointerException. 
		String[] mostCommonWordPair0 = demoWordStat.mostCommonWordPairs(-1);
		assertEquals(null, mostCommonWordPair0[0]);
	}

	@Test
	public void testMostCommonCollocs() throws Exception {
		WordStat demoWordStat = new WordStat("/Users/daniel.l/Code/git/233-4/233-4/src/First_Chapter_of_1984.txt");
		// these words are "the", "of", "was", "and", "a", "it", "in", "to", "his", "winston".
		String[] mostcommonCollocsBeforeSignature = demoWordStat.mostCommonCollocs(10, "thousand", -1);
		// these words are "the", "of", "was", "a", "and", "he", "to", "it", "in", "had"
		String[] mostcommonCollocsAfterSignature = demoWordStat.mostCommonCollocs(10, "thousand", 1);
		assertEquals("winston", mostcommonCollocsBeforeSignature[9]);
		assertEquals("had", mostcommonCollocsAfterSignature[9]);
		// unreasonable input of base word. 
		String[] unreasonableInput1 = demoWordStat.mostCommonCollocs(10, "aaaa", 1);
		assertEquals(null, unreasonableInput1[0]);
		// unreasonable input of i-value
		String[] unreasonableInput2 = demoWordStat.mostCommonCollocs(10, "thousand", 5);
		assertEquals(null, unreasonableInput2[0]);
	}

}
