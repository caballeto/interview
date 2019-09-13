package leetcode.session1;

import java.util.TreeSet;

public class _132_pattern {
  public boolean find132patternBad(int[] nums) {
    if (nums == null || nums.length < 3) return false;
    int min = nums[0];

    for (int i = 1; i < nums.length - 1; i++) {
      min = Math.min(min, nums[i]);
      for (int j = i + 1; j < nums.length; j++) {
        if (min < nums[j] && nums[j] < nums[i]) {
          return true;
        }
      }
    }

    return false;
  }

  public boolean find132pattern(int[] nums) {
    if(nums == null || nums.length == 0) return false;
    int[] ones = new int[nums.length];
    ones[0] = nums[0];
    for(int i = 1;i<nums.length;i++){
      ones[i] = Math.min(nums[i-1],ones[i-1]);
    }                                               //ones[i] = minimum from index 0 to index i-1
    TreeSet<Integer> twoSet = new TreeSet<>();      //Time complexity when add one by one is lg1+lg2+lg3+...+lg(n-1) = lg(n!)<nlgn
    for(int i = nums.length - 1;i>0;i--){           //scan from right to find one < three and two < three and one < two
      int one = ones[i];
      int three = nums[i];
      if(one < three){                             //one < three
        Integer two = twoSet.floor(three-1);    //two < three
        if(two != null && one < two) return true;  //one < two
      }
      twoSet.add(nums[i]);// After we take nums[i] as three, nums[i] will be added to twoSet
    }
    return false;
  }
}
