package current.thread.mkevin.demo7;

import java.util.Arrays;

public class SampleDemo {

    public static void main(String[] args) {
        // 用一个小例子来说明快照的产生
        Object[] array = new Object[]{1,2,3};
        Object[] snapshot = array;
        Object[] newArray = new Object[]{1,2,3,4};
        array = newArray;
        System.out.println("array:"+Arrays.toString(array));
        System.out.println("snapshot:"+Arrays.toString(snapshot));
    }

}
