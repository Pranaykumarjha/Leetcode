import java.util.*;

class Solution {
    public int shortestSubarray(int[] nums, int k) {

        int n = nums.length;

       
        long[] prefix = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        Deque<Integer> dq = new LinkedList<>();
        int minLen = Integer.MAX_VALUE;

        for (int i = 0; i <= n; i++) {

          
            while (!dq.isEmpty() && prefix[i] - prefix[dq.peek()] >= k) {
                minLen = Math.min(minLen, i - dq.peek());
                dq.poll(); 
            }

            
            while (!dq.isEmpty() && prefix[i] <= prefix[dq.peekLast()]) {
                dq.pollLast(); 
            }

         
            dq.offer(i);
        }

        return minLen == Integer.MAX_VALUE ? -1 : minLen;
    }
}