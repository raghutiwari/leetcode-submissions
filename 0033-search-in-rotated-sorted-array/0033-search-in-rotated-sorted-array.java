class Solution {
    public int search(int[] arr, int n) {

        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
           int  mid = (left + right) / 2;

           if (arr[mid] == n) {
               return mid;
           }

           if (arr[left] <= arr[mid]) {
               if (arr[left] <= n && n < arr[mid]) {
                   right = mid - 1;
               } else {
                   left = mid + 1;
               }
           } else {
               if (arr[right] >= n && n > arr[mid]) {
                   left = mid + 1;
               } else {
                   right = mid - 1;
               }
           }

        }

        return -1;
    }
}