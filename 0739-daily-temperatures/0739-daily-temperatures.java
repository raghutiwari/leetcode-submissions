class Solution {
    public int[] dailyTemperatures(int[] temperatures) {

        Stack<Integer> s = new Stack<>();
        int n = temperatures.length;
        int[] result = new int[n];
        
        for(int i = n - 1; i >= 0; i--) {
            
            while (!s.isEmpty() && (temperatures[s.peek()] <= temperatures[i])) {
                s.pop();
            }
            if (s.isEmpty()) {
                result[i] = 0;
            } else {
                result[i] = s.peek() - i;
            }

            s.push(i);

        }
        
        return result;
        
    }
}

// 73,74,75,71,69,72,76,73
// 0, 1, 2, 3, 4, 5, 6, 7

// i = 0;

// stack: 0(73)


// i = 1;

// stack: pop 0
// result[0] = 1 - 0;

// stack: 1 (74)


// i = 2;
// stack: pop 1
// result[1] = 2 - 1;
// stack: 2 (75)

// i = 3
// stack: 2 (75), 3(71)


// i = 4
// stack: 2(75), 3(71), 4(69)

// i = 5
// stack: pop 4(69)
// result[4] = 5 - 4

// stack: 2, 3, 5

// i = 6 (76)
// stack: pop 72
// result[5] = 6 - 5;

// stack: pop 3
// stack[3] = 6 - 3 = 3



// Stack: 
// answer: 