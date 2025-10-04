import java.util.Arrays;
import java.util.Objects;

public class MyHashMap<K,V> {
    private int size = 13;

    private  Busket<K,V>[] mas;

    public  MyHashMap() {
        mas = new Busket[size];
    }

    public void  put(K key, V value) {
        int index = hash(key);
        var newBusket = new Busket<>(key, value);
        Busket<K,V> last = null;
        if(mas[index] == null) {
            mas[index] = newBusket;
        }else  {
            var next = mas[index];
            int sizeBusket=1;
            while(next != null) {
                if(next.key.equals(key)) {
                    next.value = value;
                    break;
                }
                last = next;
                next = next.next;
                sizeBusket++;
            }
            last.next = newBusket;
            if(sizeBusket>8) {
                expand();
            }
        }
    }

    public V get(K key) {
        int index = hash(key);
        var busket = mas[index];
        while(busket != null) {
            if(busket.key.equals(key)) {
                return busket.value;
            }
            busket = busket.next;
        }
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        MyHashMap<?, ?> myHashMap = (MyHashMap<?, ?>) o;
        return size == myHashMap.size && Objects.deepEquals(mas, myHashMap.mas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(size, Arrays.hashCode(mas));
    }

    @Override
    public String toString() {
        return "MyHashMap{" +
                "size=" + size +
                ", mas=" + Arrays.toString(mas) +
                '}';
    }

    public boolean remove(K  key) {
        int index = hash(key);
        var busket = mas[index];
        Busket<K,V> lastBusket = null;
        while(busket != null) {
            if(busket.key.equals(key)) {
                if(busket.next == null) {
                    mas[index] = null;
                }else {
                    lastBusket.next = busket.next;
                }
                return true;
            }
            lastBusket = busket;
            busket = busket.next;
        }
        return false;
    }

    private  int hash(K key) {
        return Math.abs(key.hashCode()) % size;
    }

    private void expand() {
        size = size*2;
        var saveMas = mas;
        mas = new Busket[size];

        for(Busket<K,V> busket : saveMas) {
            if(busket == null) {
                continue;
            }
            var next = busket;
            while(next != null) {
                put(next.key,next.value);
                next = next.next;
            }
        }
    }

}
