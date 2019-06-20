package leetcode;

import java.util.*;

public class _15_3sum {
  public List<List<Integer>> threeSum(int[] nums) {
    HashSet<List<Integer>> res = new HashSet<>();
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) map.put(nums[i], i);
    for (int i = 0; i < nums.length - 1; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        int key = -nums[i] - nums[j];
        if (map.containsKey(key) && map.get(key) != i && map.get(key) != j) {
          List<Integer> array = Arrays.asList(nums[i], nums[j], -nums[i]-nums[j]);
          Collections.sort(array);
          res.add(array);
        }
      }
    }

    return new ArrayList<>(res);
  }

  /**
   * Reference solution
   */
  public List<List<Integer>> threeSum2(int[] nums) {
    Set<List<Integer>> res  = new HashSet<>();
    if(nums.length == 0) return new ArrayList<>(res);
    Arrays.sort(nums);
    for(int i = 0; i < nums.length - 2; i++){
      int j = i + 1;
      int k = nums.length - 1;
      while(j < k){
        int sum = nums[i] + nums[j] + nums[k];
        if (sum == 0) res.add(Arrays.asList(nums[i], nums[j++], nums[k--]));
        else if (sum > 0) k--;
        else j++;
      }

    }
    return new ArrayList<>(res);
  }

  public static void main(String[] args) {
    int[] nums = {-1,0,1,2,-1,-4};
    System.out.println(new _15_3sum().threeSum(nums));
  }
}
