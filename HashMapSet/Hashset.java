import java.util.HashSet;
public class Hashset
{
    //HashSet is a class implementing set interface
    //the purpose of set is to maintain uniqueness
    //HashSet is implemented using hash table and it does not maintain insertion order
    //HashSet allows null values
    //HashSet is non synchronized
    //HashSet is not thread safe
    //HashSet is faster than TreeSet
    //TreeSet is a data structure that is based on a red-black tree
    //TreeSet is implemented using a tree structure and it maintains ascending order
    public static void main(String[] args) 
    {
        HashSet<Integer> st = new HashSet<>();
        st.add(4);
        st.add(4);
        st.add(5);
        st.add(6);
        System.out.println(st);
        System.out.println(st.size());
        System.out.println(st.contains(5));
    }    
}