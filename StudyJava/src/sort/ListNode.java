package sort;

public class ListNode {//µ¥Á´±í
    public int val;
    public ListNode next;

    @Override
    public ListNode clone() {
        ListNode node = new ListNode();
        ListNode clone = node;
        ListNode real = this;
        ListNode last = node;
        while (real != null) {
            if (node == null)
                node = new ListNode();
            node.val = real.val;
            real = real.next;
            last.next = node;
            last = node;
            node = null;
        }
        return clone;
    }
}

