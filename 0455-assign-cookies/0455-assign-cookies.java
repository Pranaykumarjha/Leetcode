class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(s);
        Arrays.sort(g);

        int child=0;
        int cookie=0;

        while(child<g.length && cookie<s.length)
        {
            if(s[cookie]>=g[child])
            {
                child++;
            }
            cookie++;
        }
        return child;
    }
}