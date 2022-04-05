public class HashEntry implements Comparable<HashEntry>{
    private String key;
    private int value;

    public HashEntry(String key, int value){
        this.key = key;
        this.value = value;
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

    @Override
    public int compareTo(HashEntry o) {
        if(o != null){
            return Integer.compare(this.value, o.value);
        }
        return -1;
    }

}
