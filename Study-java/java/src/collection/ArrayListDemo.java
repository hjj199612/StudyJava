package src.collection;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: huangjj24
 * @CreateDate: 2021-4-20 14:07
 **/
public class ArrayListDemo {
    public static void main(String[] args) {
        List<Object> arrayList = new ArrayList<>();
        arrayList.addAll(new ArrayList<>());
        System.out.println(arrayList);
    }
}
