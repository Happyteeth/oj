package 全组和;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int arr[] = {69,69,69,69,69,54,119,85,103,53,155,170};
        solution.getResultWeiCal(arr);
//        solution.getResult();
    }
    List<List<Integer>> result = new ArrayList<>();

    /**
     * arr不重复情况
     * @param arr
     * @return
     */
    public List<List<Integer>> getResult(int arr[]){
        if(arr.length==0){
            return result;
        }
        add(arr, new ArrayList<Integer>(), new ArrayList<Integer>(), 0);
        add1(arr, new ArrayList<Integer>(), 0);
        return result;
    }
    public void add(int arr[], List<Integer> list, List<Integer> idxList,int idx){
        result.add(new ArrayList<>(list));
        for(int i=idx;i<arr.length;i++){
            if(!idxList.contains(i)){
                list.add(arr[i]);
                idxList.add(i);
                add(arr, list, idxList, i);
                list.remove(list.size()-1);
                idxList.remove(idxList.size()-1);
            }
        }
    }

    public void add1(int arr[], List<Integer> list, int idx){

        for(int i=idx;i<arr.length;i++){
            if(!list.contains(arr[i])){
                list.add(arr[i]);

                add1(arr,list,i);
                list.remove(list.size()-1);

            }
        }
    }

    Set<List<Integer>> hsSet = new HashSet<>();
    public List<List<Integer>> getNoRepeat(int arr[]){
        List<List<Integer>> list = new ArrayList<>();
        if(arr.length==0){
            return list;
        }
        return null;
    }

    /**
     * 位运算
     */
    List<List<Integer>> weiResult = new ArrayList<>();
//    Set<List<Integer>> set = new HashSet<>();
    public List<List<Integer>> getResultWeiCal(int arr[]){
        if(arr.length==0){
            return weiResult;
        }
        int n = arr.length;
        n = 1<<n;
        for(int i=0;i<n;i++){
            List<Integer> list = new ArrayList<>();
            for(int j=0;j<arr.length;j++){
                int tmp = 1<<j;
                if((tmp&i)!=0){
                    list.add(arr[j]);
                }
            }
            weiResult.add(list);

        }
        return weiResult;
    }

//    public void addNoRepeat(int arr[], List<Integer> list, List<Integer> idxList, )
}
