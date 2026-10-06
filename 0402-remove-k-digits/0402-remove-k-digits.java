class Solution {
    public String removeKdigits(String num, int k) {

        if (k == num.length()) {
            return "0";
        }

        Stack<Character> stack = new Stack<>();

        for (char digit : num.toCharArray()) {

            // Remove bigger digits from the stack
            while (!stack.isEmpty() &&
                   k > 0 &&
                   stack.peek() > digit) {

                stack.pop();
                k--;
            }

            stack.push(digit);
        }

        // If k is still remaining,
        // remove digits from the end
        while (k > 0) {
            stack.pop();
            k--;
        }

        // Build answer
        StringBuilder ans = new StringBuilder();

        boolean leadingZero = true;

        for (char digit : stack) {

            if (leadingZero && digit == '0') {
                continue;
            }

            leadingZero = false;
            ans.append(digit);
        }

        return ans.length() == 0 ? "0" : ans.toString();
    }
}