class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right= getMax(piles);

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (canFinish(piles, h, mid)) {
                right = mid - 1; 
            } else {
                left = mid + 1;  
            }
        }
        return left;     
    }
    private boolean canFinish(int[] piles, int h, int k)
    {
        long totalHours = 0;

        for (int pile : piles) {
            totalHours += (pile + k - 1) / k; 
        }

        return totalHours <= h;
    }
     private int getMax(int[] piles) {
        int max = 0;
        for (int pile : piles) {
            max = Math.max(max, pile);
        }
        return max;
    }
}