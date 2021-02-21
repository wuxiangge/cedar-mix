package q435;

import java.util.Arrays;
import java.util.Comparator;
//给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
//
// 注意:
//
//
// 可以认为区间的终点总是大于它的起点。
// 区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。
//
//
// 示例 1:
//
//
//输入: [ [1,2], [2,3], [3,4], [1,3] ]
//
//输出: 1
//
//解释: 移除 [1,3] 后，剩下的区间没有重叠。
//
//
// 示例 2:
//
//
//输入: [ [1,2], [1,2], [1,2] ]
//
//输出: 2
//
//解释: 你需要移除两个 [1,2] 来使剩下的区间没有重叠。
//
//
// 示例 3:
//
//
//输入: [ [1,2], [2,3] ]
//
//输出: 0
//
//解释: 你不需要移除任何区间，因为它们已经是无重叠的了。
//
// Related Topics 贪心算法
// 👍 353 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        // [ [1,2],
        //   [2,3],
        //   [3,4],
        //   [1,3]
        // ]  int[4][2]

        if (intervals.length == 0 || intervals.length == 1) {
            return 0;
        }

        // 以数组的后面的字段进行排序
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));

        int length = intervals.length;

        int total = 0;

        int prev = intervals[0][1];

        for (int i = 1; i < length; ++i) {
            if (intervals[i][0] < prev) {
                ++total;
            } else {
                prev = intervals[i][1];
            }
        }

        return total;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
