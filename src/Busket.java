import org.w3c.dom.Node;

public class Busket<K,V> {
    final K key;
    V value;
    Busket<K,V> next;

    public Busket(K key, V value) {
        this.key = key;
        this.value = value;
    }

}
