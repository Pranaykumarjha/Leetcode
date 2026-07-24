class Solution {
    public int uniqueXorTriplets(int[] nums) {

        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }

        max <<= 1; 

        boolean[] pair = new boolean[max];

        
        for (int a : nums) {
            for (int b : nums) {
                pair[a ^ b] = true;
            }
        }

        boolean[] ans = new boolean[max];

        
        for (int x = 0; x < max; x++) {
            if (!pair[x]) continue;

            for (int c : nums) {
                ans[x ^ c] = true;
            }
        }

        
        int count = 0;
        for (boolean x : ans) {
            if (x) count++;
        }

        return count;
    }
}