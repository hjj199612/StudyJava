package leetCode;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author huangjj24
 * @date 2021-5-20 15:33
 * 692. 前K个高频单词
 * 给一非空的单词列表，返回前 k 个出现次数最多的单词。
 * <p>
 * 返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率，按字母顺序排序。
 **/
public class Solution_692 {

    public static void main(String[] args) {

    }

    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Long> map = Arrays.asList(words).stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        List<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list, new Comparator<String>() {
            public int compare(String o1, String o2) {
                return (int) (map.get(o1) == map.get(o2) ? o1.compareTo(o2) : (map.get(o1) - map.get(o2)));
            }
        });
        return list.subList(0, k);
    }
}
