public class HashTable {

    protected HashEntry[] hashTable;
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
        if(hashTable[position] == null){
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
        if(hashTable[position] == null){
            hashTable[position] = temp;
        }
        else{
            position = quadraticProbing(position, key, hashCode);
            hashTable[position] = temp;
        }
        elements++;
        reSize();
    }

    private void reSize(){
        double loadFactor = (double) elements / size;
        if(loadFactor > 0.7){
            HashEntry[] hashTableNew = new HashEntry[2*size];
            HashEntry[] temp = hashTable;
            hashTable = hashTableNew;
            this.elements = 0;
            size = size*2;
            for(int i = 0; i < size / 2; i++){
                if(temp[i] != null){
                    this.put(temp[i].getKey(), temp[i].getValue());
                }
            }
            this.hashTable = hashTableNew;
        }
    }

    public void update(String key, int value){
        int i = findKey(key);
        if(i != -1) {
            hashTable[i].setValue(value);
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
            if(hashTable[positionF].getKey().equals(key)){
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
        while(hashTable[positionF] != null){
            positionF = (positionF + secondHashCode * secondHashCode) % size;
            iterations++;
            if(iterations > size) return -1;
        }
        return positionF;
    }

    private int quadraticProbing(int position, String key, int hashCode){
        int positionF = hashCode % size;
        int secondHashCode = 1;
        int iterations = 0;
        while(hashTable[positionF] != null){
            positionF = (positionF + secondHashCode * secondHashCode) % size;
            iterations++;
            secondHashCode++;
            if(iterations > size) return -1;
        }
        return positionF;
    }
    private int findKey(String key){
        int positionF = Math.abs(key.hashCode())%size;
        int secondHashCode = 1;
        int iterations = 0;
        while(hashTable[positionF] != null){
            if(hashTable[positionF].getKey().equals(key)){
                return positionF;
            }
            positionF = (positionF + secondHashCode * secondHashCode) % size;
            iterations++;
            if(iterations > size) return -1;
        }
        return -1;
    }
}
