import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class HashTableTest {

	@Test
	public void testPut(){
		HashTable demoHashTable = new HashTable();
		// test for collison. Using quadratic probing. 
		demoHashTable.put("a", 0, 1);
		demoHashTable.put("b", 0, 2);
		demoHashTable.put("c", 0, 1);
		System.out.println("hello world");
		HashTable demoHashTable2 = new HashTable();
		// test for resize. Since our load factor is 0.7, the 71st put would cause resize. 
		for(int i = 0; i < 70; i++){
			demoHashTable2.put("a", 0, i);
		}
		demoHashTable2.put("a", 0, 71);
		// test for update. key "a" have a value of 0, an update would change that value to 1.
		HashTable demoHashTable3 = new HashTable();
		demoHashTable3.put("a", 0);
		demoHashTable3.update("a", 1);
		assertEquals(1, demoHashTable3.get("a"));
		// meaningless command line for debug.
		System.out.println("Hello world");
	}
}
