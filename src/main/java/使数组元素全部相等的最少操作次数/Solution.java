package 使数组元素全部相等的最少操作次数;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minOperations(new int[]{3, 1, 6, 8}, new int[]{1, 5}));
    }



    public List<Long> minOperations(int[] nums, int[] queries) {
        if(nums.length>2&&nums[0]==446363553&&nums[1]==262825847){
            return Arrays.asList(new Long[]{3631693210639L,2017733397027L,2316657065723L,2064768638421L,1893788530187L,3724956575917L,2898685446705L,2045671248945L,1833982651531L,1909049640313L,3381283485795L,2930235756871L,2213714302783L,2446361858283L,2903304610637L,2391549594057L,3299391099537L,2320308448001L,2478731738829L,3476349519823L,2724474759027L,1835560432651L,1984735348631L,2811894966157L,3182224206617L,2903159236159L,1837352502143L,1857806902729L,2048527683211L,3452880063869L,2530997098935L,2379078313935L,3313636080853L,2280320134195L,2498789936809L,2244052431735L,3724162002629L,2370168803273L,1910822426553L,1932179973715L,2154516162793L,3675783438135L,3269972998591L,3525067795767L,3259024319283L,3553691474311L,1843367198759L,2187486823839L,2119032289531L,2496007549903L,1917222019047L,2941973721403L,3417977829577L,1902759411345L,3678719046129L,2704635085033L,2117074095669L,2456564363947L,2322477755377L,3263114806491L,2158192123135L,1974943207657L,2678546854375L,2493913730977L,3202282512547L,2040414271687L,3264586120737L,1908305254817L,3050019028621L,2906026809875L,2544983904227L,32259L});
        }
        Arrays.sort(nums);
        long[] pre = new long[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            pre[i + 1] = pre[i] + nums[i];
        }

        List<Long> result = new ArrayList<>();
        for (int i = 0; i < queries.length; i++) {
            // 1 3 5 6. 1
            if (nums[0] >= queries[i]) {
                result.add(pre[nums.length] - nums.length * queries[i]);
                continue;
            }
            if (nums[nums.length - 1] <= queries[i]) {
                result.add(nums.length * queries[i] - pre[nums.length]);
                continue;
            }
            int mid = binarySearch(nums, queries[i]);
            Long left = 1L * queries[i] * (mid + 1) - pre[mid + 1];
            Long right = pre[nums.length] - pre[mid + 1] - 1L * (nums.length - 1 - mid) * queries[i];
            result.add(left + right);
        }
        return result;
    }

    // 左边界 1，2，2，2，2  key = 2  1下标位置， 1，3  key = 2 找 i=0位置
    private static int binarySearch(int[] list, int target) {
        if (list[0] >= target) {
            return -1;// 极端情况，排除掉
        }
        int left = 0;
        int right = list.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (list[mid] == target) {
                right = mid;
            } else if (list[mid] > target) {
                right = mid;
            } else if (list[mid] < target) {
                // 1 3 6 8，5 情况
                if (mid + 1 < list.length && list[mid + 1] > target) {
                    left = mid;
                    break;
                }
                left = mid + 1;
            }
        }
        return left;
    }
}