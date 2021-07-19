package src.collection;

import java.util.*;

/**
 * @Description:
 * @Author: huangjj24
 * @CreateDate: 2021-4-17 17:04
 **/
public class CollectionDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("SpringBoot课程");
        list.add("架构课程");
        list.add("微服务SpringCloud课程");
        //设置为只读List集合
        list = Collections.unmodifiableList(list);
        System.out.println(list);
        Set<String> set = new HashSet<>();
        set.add("Mysql教程");
        set.add("Linux服务器教程");
        set.add("Git教程");
        //设置为只读Set集合
        set = Collections.unmodifiableSet(set);
        System.out.println(set);
        Map<String, String> map = new HashMap<>();
        map.put("key1", "课程1");
        map.put("key2", "课程2");
        //设置为只读Map集合
        Map<String, String> map2 = Collections.unmodifiableMap(map);
        System.out.println(map2);
        map.put("key3", "课程3");
        System.out.println(map2);

    }

}
