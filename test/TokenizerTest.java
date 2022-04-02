import org.junit.Test;

import static org.junit.Assert.*;

import java.util.ArrayList;

public class TokenizerTest {

	@Test
	public void testTokenizer() throws Exception {
		Tokenizer testToken = new Tokenizer("123.rtf");
		ArrayList<String> temp = testToken.wordList();
		assertEquals(temp, "abc");
	}

}
