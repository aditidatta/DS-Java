import java.util.*;
import java.util.Map.Entry;

/**
 * MapEntry class, implements java.util.Map.Entry
 * @author Aditi Datta
 */
public class MapEntry<K,V> implements Entry<K,V> {
    private K k; // key
    private V v; // value

    /**
     * Creates a MapEntry object using the key and value
     * @param key K type key
     * @param value V type value
     */
    public MapEntry(K key, V value) {
        k = key;
        v = value;
    }

    /**
     * Returns the key
     * @return K type key
     */
    public K getKey() {
        return k;
    }

    /**
     * Returns the value
     * @return V type value
     */
    public V getValue() {
        return v;
    }

    /**
     * Sets key to the given key
     * @param key K type key
     */
    public void setKey(K key) {
        k = key;
    }

    /**
     * Sets value too the given value
     * @param value V type value
     * @return old value after update
     */
    public V setValue(V value) {
        V old = v;
        v = value;
        return old;
    }
}
