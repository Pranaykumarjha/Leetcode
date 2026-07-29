class Solution {

    int[] parent;
    int[] rank;

    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        int n = accounts.size();

        parent = new int[n];
        rank = new int[n];

        for(int i=0;i<n;i++)
            parent[i]=i;

        Map<String,Integer> emailOwner = new HashMap<>();

        // Step 1 : Union accounts having same email
        for(int i=0;i<n;i++){

            List<String> account = accounts.get(i);

            for(int j=1;j<account.size();j++){

                String email = account.get(j);

                if(!emailOwner.containsKey(email)){

                    emailOwner.put(email,i);

                }else{

                    union(i,emailOwner.get(email));
                }
            }
        }

        // Step 2 : Group emails by root
        Map<Integer,List<String>> merged = new HashMap<>();

        for(String email : emailOwner.keySet()){

            int owner = emailOwner.get(email);

            int root = find(owner);

            merged.computeIfAbsent(root,k->new ArrayList<>()).add(email);
        }

        // Step 3 : Build answer
        List<List<String>> ans = new ArrayList<>();

        for(int root : merged.keySet()){

            List<String> emails = merged.get(root);

            Collections.sort(emails);

            List<String> temp = new ArrayList<>();

            temp.add(accounts.get(root).get(0));

            temp.addAll(emails);

            ans.add(temp);
        }

        return ans;
    }

    private int find(int x){

        if(parent[x]!=x)
            parent[x]=find(parent[x]);

        return parent[x];
    }

    private void union(int x,int y){

        int rootX=find(x);
        int rootY=find(y);

        if(rootX==rootY)
            return;

        if(rank[rootX]<rank[rootY]){

            parent[rootX]=rootY;

        }else if(rank[rootX]>rank[rootY]){

            parent[rootY]=rootX;

        }else{

            parent[rootY]=rootX;
            rank[rootX]++;
        }
    }
}