class Solution {

    public int largestRectangleArea(int[] input) {

        // To keep track of Next Smallest Element and Previous Smallest Element
        Stack<Integer> s = new Stack<>();

        // To track of the max area we can create with each rectangle
        int maxArea = Integer.MIN_VALUE;
        
        // Start with the first rectangle to last one
        for (int i = 0; i < input.length; i++) {
        
            // We iterate while stack is not empty
            // if the top of stack is greater than the current indexed element
            // This is because, if this is the case, it means we have encounterd
            // the next smallest element
            // and now we can compute the area with the top of stack's indexed element
            while (!s.isEmpty() && input[s.peek()] > input[i]) {
                
                // get the number for which we will compute the area
                int num = input[s.pop()];
                // get the next smallest element which will be the current indexed element
                int nse = i;
                // get the previous smallest element
                int pse = s.isEmpty() ? -1 : s.peek();

                maxArea = Math.max(maxArea, num * (nse - pse - 1));

            }
            
            // if we dont encounter a smaller element, we keep on adding it in the stack
            // this is because now we can capture this element as well for calculating area.
            s.push(i);


        }

        while (!s.isEmpty()) {
            int nse = input.length;
            int num = input[s.pop()];
            int pse = s.isEmpty() ? -1 : s.peek();

            maxArea = Math.max(maxArea, num * (nse - pse - 1));
        }

        return maxArea;


    }

    // Brute Force
//     public int largestRectangleArea(int[] input) {
        
//         int maxAreaTillNow = Integer.MIN_VALUE;

//         for (int i = 0; i < input.length; i++) {
//             int left = i;
//             int right = i;

//             for (int j = i - 1; j >= 0; j--) {
//                 if (input[j] < input[i]) {
//                     break;
//                 }
//                 left--;

//             }

//             for (int k = i + 1; k < input.length; k++) {

//                 if (input[k] < input[i]) {
//                     break;
//                 }
//                 right++;
//             }

//             maxAreaTillNow = Math.max(maxAreaTillNow, input[i] * (right - left + 1));
            
//     }

//     return maxAreaTillNow;
// }
}