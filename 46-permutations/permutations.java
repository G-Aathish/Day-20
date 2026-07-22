import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

class Solution {
    // Tracking the size manually avoids overhead from repeated container calls
    private int stkSize = 0;

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        Stack<Integer> stk = new Stack<>();
        
        getPermutations(stk, used, nums, permutations);
        return permutations;
    }

    private void getPermutations(Stack<Integer> stk, boolean[] used, int[] nums, List<List<Integer>> permutations) {
        // Base case: we have selected elements equal to the total length
        if (nums.length == this.stkSize) {
            permutations.add(new ArrayList<>(stk));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }

            // Choose element
            stk.push(nums[i]);
            used[i] = true;
            this.stkSize++;

            // Explore paths recursively
            getPermutations(stk, used, nums, permutations);

            // Unchoose element (Backtrack)
            stk.pop();
            used[i] = false;
            this.stkSize--;
        }
    }
}
