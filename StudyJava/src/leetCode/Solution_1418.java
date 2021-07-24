package leetCode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author huangjj24
 * @date 2021-7-6 9:09
 * 1418. 点菜展示表
 * 给你一个数组 orders，表示客户在餐厅中完成的订单，确切地说， orders[i]=[customerNamei,tableNumberi,foodItemi] ，其中 customerNamei 是客户的姓名，tableNumberi 是客户所在餐桌的桌号，而 foodItemi 是客户点的餐品名称。
 * <p>
 * 请你返回该餐厅的 点菜展示表 。在这张表中，表中第一行为标题，其第一列为餐桌桌号 “Table” ，后面每一列都是按字母顺序排列的餐品名称。接下来每一行中的项则表示每张餐桌订购的相应餐品数量，第一列应当填对应的桌号，后面依次填写下单的餐品数量。
 * <p>
 * 注意：客户姓名不是点菜展示表的一部分。此外，表中的数据行应该按餐桌桌号升序排列。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/display-table-of-food-orders-in-a-restaurant
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class Solution_1418 {

    public static void main(String[] args) {
        List<List<String>> lists = Arrays.asList(
                Arrays.asList("David", "3", "Ceviche"),
                Arrays.asList("Corina", "10", "Beef Burrito"),
                Arrays.asList("David", "3", "Fried Chicken"),
                Arrays.asList("Carla", "5", "Water"),
                Arrays.asList("Carla", "5", "Ceviche"),
                Arrays.asList("Rous", "3", "Ceviche"));
        Solution_1418 solution_1418 = new Solution_1418();
        System.out.println((solution_1418.displayTable(lists)).toString());
    }

    public List<List<String>> displayTable(List<List<String>> orders) {
        List<String> table = orders.stream().map(e -> e.get(1)).distinct()
                .sorted(Comparator.comparing(Integer::valueOf)).collect(Collectors.toCollection(ArrayList::new));
        List<String> food = orders.stream().map(e -> e.get(2)).distinct().sorted()
                .collect(Collectors.toCollection(ArrayList::new));
        Map<String, Long> map = orders.stream()
                .collect(Collectors.groupingBy(e -> e.get(1) + e.get(2), Collectors.counting()));
        System.out.println(food);
        List<List<String>> res = new ArrayList<>(table.size() + 1);
        food.add(0, "Table");
        res.add(food);
        for (int i = 0; i < table.size(); i++) {
            List<String> ls = new ArrayList<>(food.size());
            ls.add(table.get(i));
            for (int j = 1; j < food.size(); j++) {
                ls.add(map.getOrDefault(table.get(i) + food.get(j), 0L) + "");
            }
            res.add(ls);
        }
        return res;
    }
}
