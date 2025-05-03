package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class Subset {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(subsets(nums));
    }
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        backtrack(ans, new ArrayList<Integer>(), 0, nums);
        return ans;
    }

    public static void backtrack(List<List<Integer>> ans, ArrayList<Integer> templist, int start, int[] nums){
        ans.add(new ArrayList<>(templist));

        for(int i=start;i<nums.length;i++){
            templist.add(nums[i]);
            backtrack(ans, templist, i+1, nums);
            templist.remove(templist.size() -1);
        }
        return;

    }
}
