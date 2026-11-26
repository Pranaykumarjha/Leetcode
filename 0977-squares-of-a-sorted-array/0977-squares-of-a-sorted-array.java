class Solution {
    public int[] sortedSquares(int[] nums) {
        int length = nums.length;
        int arr[]=new int[length];
        for(int i=0;i<arr.length;i++)
        {
            arr[i] = nums[i]*nums[i];
        }
        Arrays.sort(arr);

        return arr;
        
    }
}