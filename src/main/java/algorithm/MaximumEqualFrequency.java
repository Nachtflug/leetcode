package algorithm;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.stream.Collectors;

/**
 * 1224. 最大相等频率
 * 给出一个正整数数组 nums，请你帮忙从该数组中找出能满足下面要求的 最长 前缀，并返回其长度：
 *
 * 从前缀中 删除一个 元素后，使得所剩下的每个数字的出现次数相同。
 * 如果删除这个元素后没有剩余元素存在，仍可认为每个数字都具有相同的出现次数（也就是 0 次）。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [2,2,1,1,5,3,3,5]
 * 输出：7
 * 解释：对于长度为 7 的子数组 [2,2,1,1,5,3,3]，如果我们从中删去 nums[4]=5，就可以得到 [2,2,1,1,3,3]，里面每个数字都出现了两次。
 * 示例 2：
 *
 * 输入：nums = [1,1,1,2,2,2,3,3,3,4,4,4,5]
 * 输出：13
 * 示例 3：
 *
 * 输入：nums = [1,1,1,2,2,2]
 * 输出：5
 * 示例 4：
 *
 * 输入：nums = [10,2,8,9,3,8,1,5,2,3,7,6]
 * 输出：8
 *
 *
 * 提示：
 *
 * 2 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^5
 */
public class MaximumEqualFrequency {

    public static int maxEqualFreq(int[] nums) {

        HashMap<Integer, Integer> curMap = new HashMap<>();
        int lastCheckPoint = 0, oneCnt = 0, max = 1, maxCnt = 0;
        OUTER:
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            Integer curV = curMap.get(cur);
            if (curV == null) {
                oneCnt ++;
                curMap.put(cur, 1);
            } else {
                if (curV == 1)
                    oneCnt --;
                int newV = curV + 1;
                curMap.put(cur, newV);
                if (max < newV) {
                    max = newV;
                    maxCnt = 1;
                } else if (max == newV) {
                    maxCnt ++;
                }
            }

            int mSize = curMap.size();
            if (mSize == 1 || oneCnt == mSize || (oneCnt == mSize - 1 && max == 2 && maxCnt == 1)) {
                lastCheckPoint = i;
            }
            if (oneCnt == 1 && max * (mSize - 1) == i) {
                lastCheckPoint = i;
            }
            if (oneCnt == 0 && maxCnt == 1 && (max - 1) * (mSize - 1) + max == i + 1) {
                lastCheckPoint = i;
            }

        }

        return lastCheckPoint + 1;
    }

    public static void main(String[] args) throws InterruptedException {

        LinkedBlockingQueue<Integer> queue = new LinkedBlockingQueue<>(10);

        new Thread(() -> {
            while (true) {
//                try {
//                    System.out.println(queue.take());
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }
        }).start();
        int i = 0;
        while (true) {

            queue.put(i++);
            System.out.println("succ add " + i);
            Thread.sleep(1000);
        }

    }


}
