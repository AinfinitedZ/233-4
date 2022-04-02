import javax.swing.PopupFactory;

public class HashTable {
    private class HashEntry{
        private String key;
        private int value;
        private boolean removed;

        public HashEntry(String key, int value){
            this.key = key;
            this.value = value;
            this.removed = false;
        }

        public String getKey(){ 
            return this.key;
        }

        public int getValue(){
            return this.value;
        }

        public void setValue(int value){
            this.value = value;
        }
    }
    private HashEntry[] hashTable;
    private int size = 100;
    private int elements = 0;

    public HashTable(){
        this.hashTable = new HashEntry[100];
        this.size = 100;
    }
    
    public HashTable(int size){
        hashTable = new HashEntry[size];
        this.size = size;
    }

    public void put(String key, int value){
        HashEntry temp = new HashEntry(key, value);
        int position = Math.abs(key.hashCode())%size;
        if(hashTable[position] == null && hashTable[position].removed == true){
            hashTable[position] = temp;
        }
        else{
            position = quadraticProbing(position, key);
            hashTable[position] = temp;
        }
        elements++;
        reSize();
    }

    public void put(String key, int value, int hashCode){
        HashEntry temp = new HashEntry(key, value);
        int position = Math.abs(hashCode)%size;
        if(hashTable[position] == null && hashTable[position].removed == true){
            hashTable[position] = temp;
        }
        else{
            position = quadraticProbing(position, key);
            hashTable[position] = temp;
        }
        elements++;
        reSize();
    }

    private void reSize(){
        if(elements / size == 0.7){
            HashTable hashTableNew = new HashTable(2*size);
            for(int i = 0; i < size; i++){
                if(hashTable[i].removed == false && hashTable[i] != null){
                    hashTableNew.put(hashTable[i].getKey(), hashTable[i].getValue());
                }
            }
            size = size*2;
        }
    }

    public void update(String key, int value){
        int i = findKey(key);
        if(i != -1) {
            hashTable[i].value = value;
        }
    }

    public int get(String key){
        int i = findKey(key);
        if(i == -1){
            return -1;
        } else {
            return hashTable[i].getValue();
        }
    }

    public int get(String key, int hashCode){
        int positionF = Math.abs(hashCode)%size;
        int secondHashCode = 1;
        int iterations = 0;
        while(hashTable[positionF] != null){
            if(hashTable[positionF].removed == false && hashTable[positionF].getKey().equals(key)){
                return hashTable[positionF].getValue();
            }
            positionF = (positionF + secondHashCode * secondHashCode) % size;
            iterations++;
            if(iterations > size) return -1;
        }
        return -1;
    }

    private int quadraticProbing(int position, String key){
        int positionF = Math.abs(key.hashCode())%size;
        int secondHashCode = 1;
        int iterations = 0;
        while(hashTable[positionF] != null && hashTable[positionF].removed == false){
            positionF = (positionF + secondHashCode * secondHashCode) % size;
            iterations++;
            if(iterations > size) return -1;
        }
        return positionF;
    }

    private int findKey(String key){
        int positionF = Math.abs(key.hashCode())%size;
        int secondHashCode = 1;
        int iterations = 0;
        while(hashTable[positionF] != null){
            if(hashTable[positionF].removed == false && hashTable[positionF].getKey().equals(key)){
                return positionF;
            }
            positionF = (positionF + secondHashCode * secondHashCode) % size;
            iterations++;
            if(iterations > size) return -1;
        }
        return -1;
    }
}
