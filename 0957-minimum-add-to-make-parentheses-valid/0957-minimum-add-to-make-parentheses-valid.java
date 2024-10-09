class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();

        char[] charArr = s.toCharArray();
        int counter = 0;
        for (int i = 0; i < charArr.length; i++) {
            if (charArr[i] == '(') {
                stack.push(charArr[i]);
            }

            if (charArr[i] == ')') {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    counter++;
                }
            }
        }

        while (!stack.isEmpty()) {
            stack.pop();
            counter++;
        }

        return counter;



    }
}