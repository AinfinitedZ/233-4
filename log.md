4.1 22:34

Beginning working on the idea of how may implement the classes. 

4.1 22:41

Working on the Tokenizer Constructor;

4.2 00:35

Finish working on the Tokenizer class

4.2 01:35

Finish working on the HashEntry class and begin working on the HashTable class.

4.2 01:48

We finally choose to use quadratic probing strategy. After considering about checking method, I think that checking method is only related to loading factor when using quadratic probing strategy $O(\frac{1}{(1-\lambda)^2})$ in average, but related to element size when using chaining strategy $O(\frac{element}{size})$ in average. 

4.2 12:07

Finish working on both put method. Still need working on the Quadratic probing.

4.2 14:23

Finish reSize(). A private method that enlarge the size of hashtable by the factor of 2. It happens when the load factor is going to over 0.7.

Finish update(). A method that modify the value by comparing target String hashcode to input hashcode. if not found, 

4.2 14:45

Finish working on quadratic probing.

4.2 14:51

Finish working on the findKey. Refer to the method that was shown on the slide. 

4.2 14:58

Finish working on the both get() method by simply return the value in the hashtable.

Modify the reSize() method. Now it could handle the situation that too much space was occipuied. 

4.2 17:22

Fix Tokenizer constructor. Now the constructor should work as what the assignment shows. 

4.2 17:36

Finish WordStat constructor. Its related hash table should include the pair of word freqency and word itself.

4.2 18:03

Finish wordPairCount(). Figure out pair count by traversing wordList().

4.2 18:34

Fix private method reSize(). Change the way how it was coding. 

Override compareTo() method in HashEntry. Now sort() method inside ArrayList could apply for HashTable. 

4.2 18:52

Finish wordRank() method. Implememt by using Array.sorts() method. 

4.2 19:16

Finish wordPairRank() method. Implement by using Array.sorts() method and compare their freqency. 

4.2 19:29

Finish mostCommonWords() method. Implement by traverse first k elements in the word count array. 

4.4 08:10

Rewrite the WordStat class. Change the way how wordPair works for conventiently use. 

4.4 09:16

Finish the whole WordStat class. List the rank of words acquiring them from ordered array. 

4.4 14:55

Finish testing the Tokenizer class by using debug. The whole wordList is seperated by regular expression [ ^ a-zA-Z] which exclude all character expect these. 

4.4 15:57 

Test the collison situation. Fix the quadratic probing. Forget to iterate the second hashcode. All tests finish by debug.

Fix the resize() by solving some small problems such as the typecasting and array initizialing. All tests finish by debug. 

Test the update() method. 

4.4 19:27

Finish testing testWordCount() method. Fix some NullPointerException caused by the null in the hashtable array. Add a filter before the hashtable is sorted. 

4.4 20:32

finish testing wordRank() method and wordPairRank() method. 

finish testing MostCommonWords() method. Fix the bug that the array was increasing sorted word freqency but the return array return decreasing sorted word freqency. 

Add a pre-testing on mostCommonWords and leastCommonWords. These method should return a empty object when the input isn’t reasonable. That would avoid NullPointerException. 

Finish testing mostCommonWordPair() method. 

4.4 22:14

Finish and fix testing kMostCommonCollocs. Implement by create another wordStat object by a private constructor that accept List<> as input parameter. That allow one to divide the original wordList to part of the List and easily convert them into word freqency. 

4.5 10:11

finish test of tokenizer for constructor(String[] line). 

4.5 10:43

Finish test of word stat test. Instead of direct use sample text, I rewrite the constructor to build the test unit. 

4.5 15:09

Deal with the edge situations that return String arrays. one with same count is returned by alphabetical order. 

Deal with the edge situations that input value is too large. One would return whole array if k is too large. 


4.5 23:54
Finish extra credit that edge cases of method that return String[] Have no time to write more log xD




