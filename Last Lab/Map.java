import java.util.Map.Entry;

/**
 * Map interface for the HashTable class.
 * @author Aditi Datta
 */
public interface Map<K, V>{
    int size();
    boolean isEmpty();
    V get(K key);
    V put(K key, V value);
    V remove(K key);
    Iterable<Entry<K,V>> entrySet();
}
