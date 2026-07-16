class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();

        for(int nums:nums2)
        {
            while(!stack.isEmpty() && nums>stack.peek())
            {
                map.put(stack.pop(),nums);
            }
            stack.push(nums);
        }
        while(!stack.isEmpty())
        {
            map.put(stack.pop(),-1);
        }
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = map.get(nums1[i]);
        }

        return result;
    }
}