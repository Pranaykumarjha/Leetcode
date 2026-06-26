import java.util.*;

class Solution {
    public int maxPoints(int[][] points) {
        if (points.length <= 2) return points.length;

        int maxPoints = 0;

        for (int i = 0; i < points.length; i++) {
            HashMap<String, Integer> map = new HashMap<>();
            int duplicate = 1;

            for (int j = i + 1; j < points.length; j++) {
                int x1 = points[i][0], y1 = points[i][1];
                int x2 = points[j][0], y2 = points[j][1];

                // Duplicate point
                if (x1 == x2 && y1 == y2) {
                    duplicate++;
                    continue;
                }

                int dx = x2 - x1;
                int dy = y2 - y1;

                int gcd = gcd(dx, dy);
                dx /= gcd;
                dy /= gcd;

                String slope = dx + "/" + dy;

                map.put(slope, map.getOrDefault(slope, 0) + 1);
            }

            int localMax = 0;
            for (int count : map.values()) {
                localMax = Math.max(localMax, count);
            }

            maxPoints = Math.max(maxPoints, localMax + duplicate);
        }

        return maxPoints;
    }

    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}