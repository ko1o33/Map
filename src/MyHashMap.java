import java.util.Arrays;
import java.util.Objects;

public class MyHashMap<K,V> {
    private int DEFAULT_CAPACITY = 16;

    private  Bucket<K,V>[] array;

    public  MyHashMap() {
        array = new Bucket[DEFAULT_CAPACITY];
    }

    public void  put(K key, V value) {
        int index = hash(key);
        boolean keyFound = false;
        var newBucket = new Bucket<>(key, value);
        Bucket<K,V> last = null;
        if(array[index] == null) {
            array[index] = newBucket;
        }else  {
            var next = array[index];
            int sizeBusket=1;
            while(next != null) {
                if(next.key.equals(key)) {
                    next.value = value;
                    keyFound = true;
                    break;
                }
                last = next;
                next = next.next;
                sizeBusket++;
            }
            //Исправил от дубликата
            if(keyFound == false) {
                last.next = newBucket;
            }
            if(sizeBusket>8) {
                resize();
            }
        }
    }

    public V get(K key) {
        int index = hash(key);
        var bucket = array[index];
        while(bucket != null) {
            if(bucket.key.equals(key)) {
                return bucket.value;
            }
            bucket = bucket.next;
        }
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        MyHashMap<?, ?> myHashMap = (MyHashMap<?, ?>) o;
        return DEFAULT_CAPACITY == myHashMap.DEFAULT_CAPACITY && Objects.deepEquals(array, myHashMap.array);
    }

    @Override
    public int hashCode() {
        return Objects.hash(DEFAULT_CAPACITY, Arrays.hashCode(array));
    }

    @Override
    public String toString() {
        return "MyHashMap{" +
                "size=" + DEFAULT_CAPACITY +
                ", mas=" + Arrays.toString(array) +
                '}';
    }

    public boolean remove(K  key) {
        int index = hash(key);
        var bucket = array[index];
        Bucket<K,V> lastBucket = null;
        while(bucket != null) {
            if(bucket.key.equals(key)) {
                if(bucket.next == null) {
                    array[index] = null;
                }else {
                    lastBucket.next = bucket.next;
                }
                return true;
            }
            lastBucket = bucket;
            bucket = bucket.next;
        }
        return false;
    }

    private  int hash(K key) {
        return Math.abs(key.hashCode()) % DEFAULT_CAPACITY;
    }

    private void resize() {
        DEFAULT_CAPACITY = DEFAULT_CAPACITY*2;
        var saveMas = array;
        array = new Bucket[DEFAULT_CAPACITY];

        for(Bucket<K,V> bucket : saveMas) {
            if(bucket == null) {
                continue;
            }
            var next = bucket;
            while(next != null) {
                put(next.key,next.value);
                next = next.next;
            }
        }
    }

}
