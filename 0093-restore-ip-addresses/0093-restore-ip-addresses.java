class Solution {

    List<String> ans = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        backtrack(s, 0, 0, new StringBuilder());
        return ans;
    }

    private void backtrack(String s, int index, int parts, StringBuilder path) {

        if (parts == 4 && index == s.length()) {
            ans.add(path.substring(0, path.length() - 1));
            return;
        }

        if (parts == 4 || index == s.length())
            return;

        int len = path.length();

        for (int i = 1; i <= 3 && index + i <= s.length(); i++) {

            String part = s.substring(index, index + i);

            if (part.length() > 1 && part.charAt(0) == '0')
                break;

            int num = Integer.parseInt(part);

            if (num > 255)
                break;

            path.append(part).append('.');

            backtrack(s, index + i, parts + 1, path);

            path.setLength(len);
        }
    }
}