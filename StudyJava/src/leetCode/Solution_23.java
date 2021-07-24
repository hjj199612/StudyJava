package leetCode;



/**
 * @author huangjj24
 * @date 2021-5-17 20:41
 * 23. 合并K个升序链表
 **/
public class Solution_23 {

    public static void main(String[] args) {

    }

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = getMinListNode(lists);
        ListNode node = head;
        while (node != null){
            ListNode next = getMinListNode(lists);
            node.next = next;
            node = node.next;
        }
        return head;
    }

    public ListNode getMinListNode(ListNode[] lists) {
        int minIndex = -1;
        for (int i = 0; i < lists.length; i++) {
            if (minIndex == -1 && lists[i] != null) {
                minIndex = i;
            }
            if (minIndex != -1 && lists[i] != null && lists[minIndex].val > lists[i].val) {
                minIndex = i;
            }
        }
        if (minIndex == -1) return null;
        ListNode min = lists[minIndex];
        lists[minIndex] = lists[minIndex].next;
        return min;
    }

}
