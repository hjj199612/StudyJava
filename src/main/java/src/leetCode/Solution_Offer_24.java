package src.leetCode;



/**
 * @author huangjj24
 * @date 2021-5-17 17:39
 * 剑指 Offer 24. 反转链表
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 **/
public class Solution_Offer_24 {

    public static void main(String[] args) {

    }

    public ListNode reverseList(ListNode head) {
        ListNode last = null;
        ListNode node = null;
        while (head!=null){
            node = head.next;
            head.next =last;
            last=head;
            if(node==null) break;
            head=node;
        }
        return head;
    }

}
