class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character,Character> map = new HashMap<>();
        HashMap<Character,Character> map1 = new HashMap<>();
        for(int i=0;i<s.length();i++)
        {
            char a = s.charAt(i);
            char b = t.charAt(i);

            if(map.containsKey(a) && map.get(a)!=b)
            {
                return false;
            }

            if (map1.containsKey(b) && map1.get(b) != a) {
                return false;
            }

            map.put(a, b);
            map1.put(b, a);
        }
        return true;
    }
}