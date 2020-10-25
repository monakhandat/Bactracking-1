class Solution {
    List<List<Integer>> output;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        output = new ArrayList<>();
        Arrays.sort(candidates);
        helper(0, new ArrayList<Integer>(), target, candidates, 0);
        
        return output;
        
    }
    private void helper(int currSum, ArrayList<Integer> out, int target, int[] candidates, int index)
    {
        // Base case
        if(currSum > target)
            return;
        if(currSum==target)
        {
            output.add(new ArrayList<>(out));
            return;
        }
        
        for(int i=index;i<candidates.length; i++)
        {
            int val = candidates[i];
            // Make a choice
            out.add(val);
            // Follow the path
            helper(currSum+val, out, target, candidates, i);
            // Undo the choice
            out.remove(out.size()-1);
        }
    }
}

// TC= O(N^(Target/Min. sum))
// SC= O(Target/ Min. sum)
