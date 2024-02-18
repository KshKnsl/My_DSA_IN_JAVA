import java.util.HashSet;
public class Hashset
{
    //HashSet is a class implementing set interface
    //the purpose of set is to maintain uniqueness
    public static void main(String[] args) 
    {
        HashSet<Integer> st = new HashSet<>();
        st.add(4);
        st.add(4);
        st.add(5);
        st.add(6);
        System.out.println(st);
        System.out.println(st.size());

    }    
}