package realworld.interviewprep.morganstanley;

/**
 * Created by jianshen on 1/10/15.
 */
public class SimpleHashMap {

    private static final int SIZE = 128;
    private HashEntry[] table = new HashEntry[SIZE];

    SimpleHashMap(){
        for (int i=0; i<SIZE; i++){
            table[i] = null;
        }
    }

    //solve hash collision via linear probing
    public String get(String key){
        int hash = key.hashCode() % SIZE;
        while (table[hash] != null && !table[hash].getKey().equals(key)) {
            hash++;
        }

        if (table[hash] == null){
            return "not found";
        } else {
            return table[hash].getValue();
        }
    }

    //solve hash collision via linear probing
    public void put(String key, String value){
        int hash = key.hashCode() % SIZE;
        while (table[hash] != null && !table[hash].getKey().equals(key)) {
            hash++;
        }

        table[hash] = new HashEntry(key, value);
    }

}

class HashEntry {
    private String key;
    private String value;

    HashEntry(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
