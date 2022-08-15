package leetCode;


import java.util.LinkedList;

/**
 * 641. 设计循环双端队列
 * 设计实现双端队列。
 * <p>
 * 实现 MyCircularDeque 类:
 * <p>
 * MyCircularDeque(int k)?：构造函数,双端队列最大为 k 。
 * boolean insertFront()：将一个元素添加到双端队列头部。 如果操作成功返回 true?，否则返回 false 。
 * boolean insertLast()?：将一个元素添加到双端队列尾部。如果操作成功返回 true?，否则返回 false 。
 * boolean deleteFront()?：从双端队列头部删除一个元素。 如果操作成功返回 true?，否则返回 false 。
 * boolean deleteLast()?：从双端队列尾部删除一个元素。如果操作成功返回 true?，否则返回 false 。
 * int getFront()?)：从双端队列头部获得一个元素。如果双端队列为空，返回 -1?。
 * int getRear()?：获得双端队列的最后一个元素。?如果双端队列为空，返回 -1 。
 * boolean isEmpty()?：若双端队列为空，则返回?true?，否则返回 false ?。
 * boolean isFull()?：若双端队列满了，则返回?true?，否则返回 false 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/design-circular-deque
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution_641 {

    public static void main(String[] args) {

    }

    class MyCircularDeque {

        private int k;
        private int size = 0;
        private LinkedList<Integer> queue;

        public MyCircularDeque(int k) {
            this.k = k;
            queue = new LinkedList<>();
        }

        public boolean insertFront(int value) {
            if (size == k) return false;
            queue.addFirst(value);
            size++;
            return true;
        }

        public boolean insertLast(int value) {
            if (size == k) return false;
            queue.addLast(value);
            size++;
            return true;
        }

        public boolean deleteFront() {
            if (size == 0) return false;
            queue.removeFirst();
            size--;
            return true;
        }

        public boolean deleteLast() {
            if (size == 0) return false;
            queue.removeLast();
            size--;
            return true;
        }

        public int getFront() {
            if (size == 0) return -1;
            return queue.getFirst();
        }

        public int getRear() {
            if (size == 0) return -1;
            return queue.getLast();
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == k;
        }
    }
}
