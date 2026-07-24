class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        
        PriorityQueue<int[]> heap =
                new PriorityQueue<>((a, b) -> a[1] - b[1]);

       
        for (int num : map.keySet()) {

            heap.offer(new int[]{num, map.get(num)});

            if (heap.size() > k)
                heap.poll();
        }

        
        int[] ans = new int[k];

        for (int i = k - 1; i >= 0; i--) {
            ans[i] = heap.poll()[0];
        }

        return ans;
    }
}