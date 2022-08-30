package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hjj199612
 * @date 2022/8/16 8:52 上午
 * @description 1656. 设计有序流
 * 有 n 个 (id, value) 对，其中 id 是 1 到 n 之间的一个整数，value 是一个字符串。不存在 id 相同的两个?(id, value) 对。
 * <p>
 * 设计一个流，以 任意 顺序获取 n?个?(id, value)?对，并在多次调用时 按 id 递增的顺序 返回一些值。
 * <p>
 * 实现 OrderedStream 类：
 * <p>
 * OrderedStream(int n) 构造一个能接收 n 个值的流，并将当前指针 ptr 设为 1 。
 * String[] insert(int id, String value) 向流中存储新的 (id, value) 对。存储后：
 * 如果流存储有 id = ptr 的 (id, value) 对，则找出从 id = ptr 开始的 最长 id 连续递增序列 ，并 按顺序 返回与这些 id 关联的值的列表。然后，将 ptr 更新为最后那个? id + 1?。
 * 否则，返回一个空列表。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/design-an-ordered-stream
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution_1656 {

    public static void main(String[] args) {

    }

    class OrderedStream {

        private String[] values;
        int ptr = 1;

        public OrderedStream(int n) {
            values = new String[n];
        }

        public List<String> insert(int idKey, String value) {
            values[idKey - 1] = value;
            List<String> res = new ArrayList<>();
            while (ptr <= values.length && values[ptr - 1] != null) res.add(values[ptr++-1]);
            return res;
        }
    }

}
