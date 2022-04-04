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

4.2 08:10

Rewrite the WordStat class. Change the way how wordPair works for conventiently use. 

4.2 09:16

Finish the whole WordStat class. List the rank of words acquiring them from ordered array. 



  





