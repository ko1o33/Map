import java.util.HashMap;


public class Main {
    public static void main(String[] args) {
        MyHashMap myHashMap = new MyHashMap();
        myHashMap.put(null, "B");
        System.out.println(myHashMap.get(null));
        System.out.println(myHashMap.remove(null));
        System.out.println(myHashMap.get(null));
    }

}