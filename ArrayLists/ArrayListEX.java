package ArrayLists;
import java.util.ArrayList;
import java.util.Scanner;
class ArrayListEX {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>(5);
//        list.add(67);
//        list.add(234);
//        list.add(654);
//        System.out.println(list.contains(765432));
//        list.set(0, 99);
//        list.remove(2);
//        System.out.println(list);
        for (int i = 0; i < 5; i++) {
            list.add(in.nextInt());
        }
        // get item at any index
        for (int i = 0; i < 5; i++) 
            System.out.println(list.get(i)); 
        System.out.println(list);
        in.close();
    }
}