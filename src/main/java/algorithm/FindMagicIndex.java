package algorithm;

public class FindMagicIndex {

    public int findMagicIndex(int[] nums) {
        if (nums[0] == 0)
            return 0;
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + ((hi - lo) >> 1);
            if (nums[mid] < mid) {
                lo = mid;
            } else
                hi = mid - 1;
        }
        if (nums[lo + 1] != lo + 1)
            return -1;
        return lo + 1;
    }

}
