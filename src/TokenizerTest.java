import org.junit.Test;

import static org.junit.Assert.*;

import java.util.ArrayList;

public class TokenizerTest {

	@Test
	public void testTokenizer() throws Exception {
		Tokenizer testToken = new Tokenizer("/Users/daniel.l/Code/git/233-4/233-4/src/123.txt");
		ArrayList<String> temp = testToken.wordList();
		// test by using debug. 
	}
	
}
