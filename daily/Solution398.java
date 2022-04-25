import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Solution398 {
    class Solution {
        HashMap<Integer, List<Integer>> map;
        Random random;
        public Solution(int[] nums) {
            map = new HashMap<>();
            random = new Random();
            for (int i = 0; i < nums.length; i++) {
                List<Integer> list = map.getOrDefault(nums[i], new ArrayList<>());
                list.add(i);
                map.put(nums[i],list);
            }
        }

        public int pick(int target) {
            List<Integer> results = map.get(target);
            return results.get(random.nextInt(results.size()));
        }
    }

    class Solution1 {
        Random random = new Random();
        int[] nums;
        public Solution1(int[] nums) {
            this.nums = nums;
        }

        public int pick(int target) {
            int ans = 0;
            for (int i = 0,j = 0; i < nums.length; i++) {
                if (nums[i] == target){
                    j++;
                    if (random.nextInt(j) == 0){
                        ans = i;
                    }
                }
            }
            return ans;
        }
    }
}
