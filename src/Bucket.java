public class Bucket<K,V> {
    final K key;
    V value;
    Bucket<K,V> next;

    public Bucket(K key, V value) {
        this.key = key;
        this.value = value;
    }

}
