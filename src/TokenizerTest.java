import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.ArrayList;

public class TokenizerTest {

	@Test
	public void testTokenizer() throws Exception {
		String[] testLine = {"This", "is", "an", "testLine", "that", "represent", "normailizing. ","Some ", " word", "wi!th", "punct.ations", "between."};
		String[] equalLine = {"this","is", "an", "testline", "that", "represent", "normailizing", "some", "word", "wi", "th", "punct","ations", "between"};
		Tokenizer testToken = new Tokenizer(testLine);
		ArrayList<String> temp = testToken.wordList();
		int iterations = 0;
		// here is a simple test representing the normalizing. 
		for (String string : temp) {
			assertEquals(string, equalLine[iterations]);
			iterations++;
		}
	}
}
