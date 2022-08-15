package leetCode;


import java.util.LinkedList;

/**
 * 641. ���ѭ��˫�˶���
 * ���ʵ��˫�˶��С�
 * <p>
 * ʵ�� MyCircularDeque ��:
 * <p>
 * MyCircularDeque(int k)?�����캯��,˫�˶������Ϊ k ��
 * boolean insertFront()����һ��Ԫ����ӵ�˫�˶���ͷ���� ��������ɹ����� true?�����򷵻� false ��
 * boolean insertLast()?����һ��Ԫ����ӵ�˫�˶���β������������ɹ����� true?�����򷵻� false ��
 * boolean deleteFront()?����˫�˶���ͷ��ɾ��һ��Ԫ�ء� ��������ɹ����� true?�����򷵻� false ��
 * boolean deleteLast()?����˫�˶���β��ɾ��һ��Ԫ�ء���������ɹ����� true?�����򷵻� false ��
 * int getFront()?)����˫�˶���ͷ�����һ��Ԫ�ء����˫�˶���Ϊ�գ����� -1?��
 * int getRear()?�����˫�˶��е����һ��Ԫ�ء�?���˫�˶���Ϊ�գ����� -1 ��
 * boolean isEmpty()?����˫�˶���Ϊ�գ��򷵻�?true?�����򷵻� false ?��
 * boolean isFull()?����˫�˶������ˣ��򷵻�?true?�����򷵻� false ��
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode.cn/problems/design-circular-deque
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
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
