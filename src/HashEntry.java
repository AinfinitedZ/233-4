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

    /**
     * Override the compareTo method. Used in Arrays.sort() method. 
     */
    @Override
    public int compareTo(HashEntry o) {
        if(o != null){
            // if(this.value < o.value){
            //     return -Integer.compare(this.value, o.value);
            // } else {
            //     return -this.key.compareTo(o.key);
            // }
            return (this.value*999 - o.value*999 + this.key.compareTo(o.key));
        }
        return -1;
    }

}
