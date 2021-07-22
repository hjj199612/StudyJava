package src.leetCode;

import java.util.*;

/**
 * @author huangjj24
 * @date 2021-6-21 9:53
 * 1600. 皇位继承顺序
 * 一个王国里住着国王、他的孩子们、他的孙子们等等。每一个时间点，这个家庭里有人出生也有人死亡。
 * <p>
 * 这个王国有一个明确规定的皇位继承顺序，第一继承人总是国王自己。我们定义递归函数 Successor(x, curOrder) ，给定一个人 x 和当前的继承顺序，该函数返回 x 的下一继承人。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/throne-inheritance
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class Solution_1600 {

    public static void main(String[] args) {
        String[] s = {"s", "sa"};
        System.out.println(s);
    }

    class ThroneInheritance {

        private String kingName;
        private Map<String, List<String>> tree;
        private Set<String> death;

        public ThroneInheritance(String kingName) {
            this.kingName = kingName;
            tree = new HashMap<>();
            death = new HashSet<>();
        }

        public void birth(String parentName, String childName) {
            List<String> list = tree.getOrDefault(parentName, new ArrayList<>());
            list.add(childName);
            tree.put(parentName, list);
        }

        public void death(String name) {
            death.add(name);
        }

        public List<String> getInheritanceOrder() {
            List<String> res = new ArrayList();
            dfs(kingName, res);
            return res;
        }

        public void dfs(String father, List<String> res) {
            if (!death.contains(father)) {
                res.add(father);
            }
            List<String> sons = tree.getOrDefault(father, new ArrayList<>());
            for (String son : sons) {
                dfs(son, res);
            }
        }
    }
}
