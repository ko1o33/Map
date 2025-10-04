import java.util.HashMap;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        MyHashMap myHashMap = new MyHashMap();
        myHashMap.put("key1", "value1");
        myHashMap.put("key1", "value11");
        myHashMap.put("key2", "value2");
        myHashMap.put("key3", "value3");
        myHashMap.put("key4", "value2");
        myHashMap.put("key5", "value2");
        myHashMap.put("key6", "value2");
        myHashMap.put("key7", "value2");
        myHashMap.put("key8", "value2");
        myHashMap.put("key9", "value2");
        myHashMap.put("key10", "value2");
        myHashMap.put("key11", "value2");
        myHashMap.put("key12", "value2");
        myHashMap.put("key13", "value2");
        System.out.println(myHashMap.toString());
        System.out.println(myHashMap.get("key1"));
        System.out.println(myHashMap.remove("key13"));
        System.out.println(myHashMap.get("key2"));
    }
}