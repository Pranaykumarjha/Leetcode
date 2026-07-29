class Solution {
    int parent[];
    int rank[];
    int count;
    public int findCircleNum(int[][] isConnected) {
        int i,j;
        int n = isConnected.length;
        parent = new int[n];
        rank = new int[n];
        count = n;

        for(i=0;i<n;i++){
            parent[i]=i;
        }
        for(i=0;i<n;i++)
        {
            for(j=i+1;j<n;j++)
            {
                if(isConnected[i][j]==1)
                {
                    union(i,j);
                }
            }
        }
        return count;
    }

   private int find(int x)
   {
    if(parent[x]!=x)
    {
        parent[x]=find(parent[x]);
    }
    return parent[x];
   }

   private void union(int x, int y)
   {
    int rootX = find(x);
    int rootY = find(y);

    if(rootX == rootY)
    {
        return;
    }
    if(rank[rootX]<rank[rootY])
    {
        parent[rootX]=rootY;
    }
    else if(rank[rootX]>rank[rootY])
    {
        parent[rootY]=rootX;
    }
    else
    {
        parent[rootY]=rootX;
        rank[rootX]++;
    }
    count--;
   }
}