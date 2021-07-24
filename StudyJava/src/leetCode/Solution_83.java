package leetCode;



/**
 * @author huangjj24
 * @date 2021-6-21 11:28
 * 83. 删除排序链表中的重复元素
 * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除所有重复的元素，使每个元素 只出现一次 。
 * <p>
 * 返回同样按升序排列的结果链表。
 **/
public class Solution_83 {

    public static void main(String[] args) {

    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode node = head.next;
        ListNode nodeLeft = head;
        while (node != null) {
            if (nodeLeft.val == node.val)
                node = node.next;
            else {
                nodeLeft.next = node;
                nodeLeft = node;
            }
        }
        nodeLeft.next = null;
        return head;
    }

}
