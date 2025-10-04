import java.util.HashMap;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        MyHashMap myHashMap = new MyHashMap();
        for (int i = 1; i <= 500; i++) {
            myHashMap.put(i % 10 , i);
        }
        System.out.println(myHashMap.toString());
        System.out.println(myHashMap.get("key1"));
        System.out.println(myHashMap.remove("key13"));
        System.out.println(myHashMap.get("key2"));
    }
}