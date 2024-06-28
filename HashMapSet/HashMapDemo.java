import java.util.*;
class HashMapDemo 
{
    public static void hashDemo() 
    {
        Integer a = 4235678;
        int code = a.hashCode();
        System.out.println(code);
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Kunal", 89);
        map.put("Karan", 99);
        map.put("Rahul", 94);
        System.out.println(map.get("Karan"));
        System.out.println(map.getOrDefault("Apoorv", 78));
        System.out.println(map.containsKey("Karan"));
    }
}