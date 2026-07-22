class Solution {
    int stkSize = 0;
    
    
    public void getPermutations(Stack<Integer> stk, boolean[] used, int[] nums, List<List<Integer>> permutations) {
        if (nums.length == this.stkSize) {
            permutations.add(new ArrayList<>(stk));
            return;
        }
        
        
        for (int i = 0; i < nums.length; i++) {
            if (used[i] == true)
                continue;
            
            
            stk.push(nums[i]);
            used[i] = true;
            this.stkSize++;
            
            
            getPermutations(stk, used, nums, permutations);
            
            
            stk.pop();
            used[i] = false;
            this.stkSize--;
        }
    }
    
    
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        Stack<Integer> stk = new Stack<>();
        
        
        getPermutations(stk, used, nums, permutations);
        return permutations;
    }
}