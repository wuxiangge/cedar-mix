package q752.v2;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @author zhangnan
 * @date 2021-05-09 18:01
 * @description 第一步，我们不管所有的限制条件，不管 deadends 和 target 的限制，就思考一个问题：如果让你设计一个算法，穷举所有可能的密码组合，你怎么做？
 * 穷举呗，再简单一点，如果你只转一下锁，有几种可能？总共有 4 个位置，每个位置可以向上转，也可以向下转，也就是有 8 种可能对吧。
 * 比如说从 "0000" 开始，转一次，可以穷举出 "1000", "9000", "0100", "0900"... 共 8 种密码。
 * 然后，再以这 8 种密码作为基础，对每个密码再转一下，穷举出所有可能...
 * 仔细想想，这就可以抽象成一幅图，每个节点有 8 个相邻的节点，又让你求最短距离，这不就是典型的 BFS 嘛，
 * 框架就可以派上用场了，先写出一个「简陋」的 BFS 框架代码再说别的：
 */
public class Solution {

    public static final char NINE = '9';
    public static final char ZERO = '0';
    public static final String FOUR_ZERO = "0000";

    public int openLock(String[] deadends, String target) {

        Set<String> visitedSet = new HashSet<>();
        for (String deadend : deadends) {
            visitedSet.add(deadend);
        }
        Queue<String> queue = new LinkedList<>();

        queue.offer(FOUR_ZERO);

        int step = 0;

        while (!queue.isEmpty()) {
            int sz = queue.size();
            for (int i = 0; i < sz; i++) {
                String cur = queue.poll();
                // 判断是否到达终点
                if (visitedSet.contains(cur)) {
                    continue;
                }else {
                    visitedSet.add(cur);
                }
                if (cur.equals(target)) {
                    return step;
                }

                // 将没有访问的添加到队列中
                for (int j = 0; j < 4; j++) {
                    String upOne = plushOne(cur, j);
                    if (!visitedSet.contains(upOne)) {
                        queue.offer(upOne);
                        visitedSet.add(upOne);
                    }
                    String minusOne = minusOne(cur, j);
                    if (!visitedSet.contains(minusOne)) {
                        queue.offer(minusOne);
                        visitedSet.add(minusOne);
                    }
                }
            }
            step++;
        }
        return -1;
    }


    private String plushOne(String target, int j) {
        char[] charArray = target.toCharArray();
        if (charArray[j] == NINE) {
            charArray[j] = ZERO;
        } else {
            charArray[j] += 1;
        }
        return new String(charArray);
    }


    private String minusOne(String target, int j) {
        char[] charArray = target.toCharArray();
        if (charArray[j] == ZERO) {
            charArray[j] = NINE;
        } else {
            charArray[j] -= 1;
        }
        return new String(charArray);
    }

}
