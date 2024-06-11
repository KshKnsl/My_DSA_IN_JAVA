import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
public class SequencingDesequencing
{
  public List<String> serialize(Node node) {
    List<String> list = new ArrayList<>();
    helper(node, list);
    return list;
  }
  void helper(Node node, List<String> list) {
    if (node == null) {
      list.add("null");
      return;
    }  
    
    list.add(String.valueOf(node.val));

    helper(node.left, list);
    helper(node.right, list);
  }

  Node deserialize(List<String> list) {
    Collections.reverse(list);
    Node node = helper(list);
    return node;
  }
  Node helper(List<String> list) {
    String val = list.remove(list.size() - 1);

    if (val.charAt(0) == 'n') {
      return null;
    }
    
    Node node = new Node(Integer.parseInt(val));

    node.left = helper(list);
    node.right = helper(list);

    return node;
  }
}
class Node{
    int val;
    Node left, right;
    Node(int val){
        this.val = val;
        left = right = null;
    }
}