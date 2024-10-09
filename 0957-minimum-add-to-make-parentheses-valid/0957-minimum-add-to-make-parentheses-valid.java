class Solution {

    // Without using extra space

    public int minAddToMakeValid(String s) {
        char[] charArr = s.toCharArray();
        int open = 0;
        int close = 0;
        for (int i = 0; i < charArr.length; i++) {
            if (charArr[i] == '(') {
                open++;
            } else if (charArr[i] == ')' && open > 0) {
                open--;
            } else {
                close++;
            }
        }

        return open + close;
    }

    // With using extra space
    // public int minAddToMakeValid(String s) {
    //     Stack<Character> stack = new Stack<>();

    //     char[] charArr = s.toCharArray();
    //     int counter = 0;
    //     for (int i = 0; i < charArr.length; i++) {
    //         if (charArr[i] == '(') {
    //             stack.push(charArr[i]);
    //         }

    //         if (charArr[i] == ')') {
    //             if (!stack.isEmpty()) {
    //                 stack.pop();
    //             } else {
    //                 counter++;
    //             }
    //         }
    //     }

    //     while (!stack.isEmpty()) {
    //         stack.pop();
    //         counter++;
    //     }

    //     return counter;

    // }
}