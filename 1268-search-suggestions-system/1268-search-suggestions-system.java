class Solution {

    class TrieNode {

        TrieNode[] children = new TrieNode[26];
        boolean isEnd;
        String word;
    }

    TrieNode root = new TrieNode();

    private void insert(String word) {

        TrieNode node = root;

        for (char ch : word.toCharArray()) {

            int idx = ch - 'a';

            if (node.children[idx] == null)
                node.children[idx] = new TrieNode();

            node = node.children[idx];
        }

        node.isEnd = true;
        node.word = word;
    }

    private void dfs(TrieNode node, List<String> list) {

        if (node == null || list.size() == 3)
            return;

        if (node.isEnd)
            list.add(node.word);

        for (int i = 0; i < 26; i++)
            dfs(node.children[i], list);
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {

        Arrays.sort(products);

        for (String p : products)
            insert(p);

        List<List<String>> ans = new ArrayList<>();

        TrieNode node = root;

        for (char ch : searchWord.toCharArray()) {

            if (node != null)
                node = node.children[ch - 'a'];

            List<String> curr = new ArrayList<>();

            if (node != null)
                dfs(node, curr);

            ans.add(curr);
        }

        return ans;
    }
}