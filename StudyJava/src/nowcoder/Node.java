package nowcoder;


/**
 * @author huangjj24
 * @date 2021-5-19 14:54
 **/
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }


}