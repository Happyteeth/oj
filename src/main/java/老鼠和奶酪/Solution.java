package 老鼠和奶酪;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.miceAndCheese(new int[]{1,2,1,2,1,2}, new int[]{1,1}, 2);
    }

    /**
     * 解法：贪心
     * 经典贪心问题。先假设所有奶酪都是第二只老鼠吃掉的，那么得分为 sum(reward2)。
     *
     * 现在我们要把 kkk 个奶酪改成第一只老鼠吃掉的。假设我们把第 iii 个奶酪改成第一只老鼠吃掉，那么与第二只老鼠吃掉相比，得分的变化量为 reward1[i] - reward2[i]。
     *
     * 为了让得分尽量大，我们需要让得分的变化量总和尽量大。因此选择前 kkk 大的变化量即可。复杂度 O(nlog⁡n)\mathcal{O}(n\log n)O(nlogn)，主要是排序的复杂度。
     *
     * 作者：TsReaper
     * 链接：https://leetcode.cn/problems/mice-and-cheese/solutions/2203918/tan-xin-by-tsreaper-a60f/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param reward1
     * @param reward2
     * @param k
     * @return
     */
    public int miceAndCheese(int[] reward1, int[] reward2, int k) {
        int max = 0;
        for(int i=0;i<reward2.length;i++){
            max += reward2[i];
        }
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<reward1.length;i++){
            list.add(reward1[i]-reward2[i]);
        }
        Collections.sort(list);
        for(int i=0;i<k;i++){
            max += list.get(list.size()-i);
        }
        return max;
    }
    int reward1[];
    int reward2[];
    int k;
    int max;

    /**
     * TODO 通过递归穷举所有 可能，记录 reward1 可能的所有k 个下标情况，再和reward2 相加, 判断
     * @param reward1
     * @param reward2
     * @param k
     * @return
     */
    public int miceAndCheese1(int[] reward1, int[] reward2, int k) {
        this.reward1 = reward1;
        this.reward2 = reward2;
        this.k = k;
        this.max = 0;
        if(k==0){
            for(int i=0;i<reward2.length;i++){
                this.max = this.max+reward2[i];
            }
            return this.max;
        }
        for(int i=0;i<reward1.length;i++){
            List<Integer> list = new ArrayList<>();
            list.add(i);
            this.dfs(list);
        }
        return max;
    }
    public void dfs(List<Integer> idx){
        if(idx.size()==k){
            this.max = Math.max(this.max, calculate(idx));
        }
        for(int i=0;i<this.reward1.length;i++){
            if(!idx.contains(i)){
                idx.add(i);
                dfs(idx);
                idx.remove(idx.size()-1);
            }
        }
    }
    public int calculate(List<Integer> idx){
        int  score = 0;
        for(int i=0;i<idx.size();i++){
            score = score+reward1[idx.get(i)];
        }
        for(int i=0;i<reward2.length;i++){
            if(!idx.contains(i)){
                score = score+reward2[i];
            }
        }
        return score;
    }
}