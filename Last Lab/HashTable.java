import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Random;

/**
 * HashTable class, implements Map interface
 * @param <K> Key Type
 * @param <V> Value Type
 * @author Aditi Datta
 */
public class HashTable<K, V> implements Map<K, V>{

    private int n = 0; // number of entries in the table
    private int capacity;
    private int prime; // prime factor
    private long scale, shift; // the shift and scaling factors
    private MapEntry<K,V>[] table;
    private MapEntry<K,V> DEFUNCT = new MapEntry<>(null, null);
    private int numberOfCollisions = 0;
    private int numberOfProbes = 0;

    /**
     * Creates a hash table based on the given capacity and the prime factor
     * @param cap int capacity
     * @param p int prime number
     */
    public HashTable(int cap, int p) {
        prime = p;
        capacity = cap;
        Random rand = new Random();
        scale = rand.nextInt(prime-1) + 1;
        shift = rand.nextInt(prime);
        table = (MapEntry<K,V>[]) new MapEntry[capacity];
    }

    /**
     * Creates a hash table based on the given capacity and a
     * default prime factor
     * @param cap int capacity
     */
    public HashTable(int cap) {
        this(cap, 7919);
    } // default prime

    /**
     * Returns the number of entries in the table
     * @return size of the table
     */
    public int size() {
        return n;
    }

    /**
     * Returns the value of the given key
     * @param key K type key
     * @return V type value
     */
    public V get(K key) {
        return bucketGet(hashValue(key), key);
    }

    /**
     * Removes the asked key.
     * @param key K type key to be removed
     * @return V type value of the key after removal
     */
    public V remove(K key) {
        return bucketRemove(hashValue(key), key);
    }

    /**
     * Puts a new key in the table or updates the old value if the key
     * is already present in the table
     * @param key K type key to be inserted
     * @param value V type value
     * @return V type value after insertion
     */
    public V put(K key, V value) {
        V answer = bucketPut(hashValue(key), key, value);
        if (n > capacity / 2) // keep load factor <= 0.5
            resize(2 * capacity - 1); // (or find a nearby prime)
        return answer;
    }

    // private utilities
    private int hashValue(K key) {
        //return (int) (Math.abs(key.hashCode())%capacity);
        return (int) ((Math.abs(key.hashCode()*scale+shift)%prime)%capacity);
    }

    private void resize(int newCap) {
        ArrayList<Entry<K,V>> buffer = new ArrayList<>(n);
        for (Entry<K,V> e : entrySet()) {
            buffer.add(e);
        }
        capacity = newCap;
        createTable();
        numberOfProbes = 0;
        numberOfCollisions = 0;
        n = 0;
        for (Entry<K,V> e : buffer) {
            put(e.getKey(), e.getValue());
        }
    }

    private void createTable() {
        table = (MapEntry<K,V>[]) new MapEntry[capacity];
    }

    private boolean isAvailable(int j) {
        return (table[j] == null || table[j] == DEFUNCT);
    }

     // Returns index with key k, or −(a+1) such that k could be added
     //at index a.
    private int findSlot(int h, K k, boolean calculateProbe) {
        int avail = -1; // no slot available (thus far)
        int j = h;
        do {
            if (isAvailable(j)) { // may be either empty or defunct
                if (avail == -1)
                    avail = j; // this is the first available slot!
                if (table[j] == null)
                    break; // if empty, search fails immediately
            }
            else if (table[j].getKey().equals(k))
                return j; // successful match
            if(calculateProbe)
                numberOfProbes++;
            j = (j+1) % capacity; // keep looking
            } while (j != h); // stop if we return to the start
        return -(avail + 1); // search has failed
        }


     // Returns value associated with key k in bucket with hash value h,
     // or else null
    private V bucketGet(int h, K k) {
        int j = findSlot(h, k, false);
        if (j < 0)
            return null;
        return table[j].getValue();
    }


     // Associates key k with value v in bucket with hash value h;
     // returns old value.
    private V bucketPut(int h, K k, V v) {
        if(!isAvailable(h))
            numberOfCollisions++;
        int j = findSlot(h, k, true);
        if (j >= 0)
            return table[j].setValue(v);
        table[-(j+1)] = new MapEntry<>(k, v);
        n++;
        return null;
    }

    // Removes entry having key k from bucket with hash value h (if any).
    private V bucketRemove(int h, K k) {
        int j = findSlot(h, k, false);
        if (j < 0)
            return null;
        V answer = table[j].getValue();
        table[j] = DEFUNCT; // mark this slot as deactivated
        n--;
        return answer;
    }

    /**
     * checks if the hash table is empty
     * @return true - if empty<br>
     *         false - otherwise.
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Returns the number of collisions
     * @return int
     */
    public int getNumberOfCollisions(){
        return numberOfCollisions;
    }

    /**
     * Returns the number of the Probes
     * @return int
     */
    public int getNumberOfProbes(){
        return numberOfProbes;
    }

    /**
     * Returns the Iterable list of entries from the hash table
     * @return Iterable list of the entries
     */
    public Iterable<Entry<K,V>> entrySet() {
        ArrayList<Entry<K,V>> buffer = new ArrayList<>();
        for (int h=0; h < capacity; h++)
            if (!isAvailable(h)) buffer.add(table[h]);
        return buffer;
    }

}
