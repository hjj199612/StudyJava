package leetCode;



/**
 * @author huangjj24
 * @date 2021-7-10 19:40
 * 147. 对链表进行插入排序
 * 对链表进行插入排序。
 * 插入排序的动画演示如上。从第一个元素开始，该链表可以被认为已经部分排序（用黑色表示）。
 * 每次迭代时，从输入数据中移除一个元素（用红色表示），并原地将其插入到已排好序的链表中。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/insertion-sort-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class Solution_147 {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(-1);
        ListNode node2 = new ListNode(5);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(0);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        Solution_147 solution_147 = new Solution_147();
        System.out.println(solution_147.insertionSortList(node1));
    }

    public ListNode insertionSortList(ListNode head) {
        ListNode node = head.next;
        ListNode nodeLeft = head;
        while (node != null) {
            if (node.val <= head.val) {
                nodeLeft.next = node.next;
                node.next = head;
                head = node;
            } else {
                ListNode listNode = head;
                while (listNode.next != null) {
                    if (listNode == nodeLeft) {
                        nodeLeft = nodeLeft.next;
                        break;
                    }
                    if (listNode.next.val >= node.val) {
                        nodeLeft.next = node.next;
                        node.next = listNode.next;
                        listNode.next = node;
                        break;
                    }
                    listNode = listNode.next;
                }
            }
            node = nodeLeft.next;
        }
        return head;
    }
}
