/*

Rotate an array of n elements to the right by k steps.

For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].

Note:
Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.

[show hint]

Related problem: Reverse Words in a String II

*/

class Problem189 {
    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        int arr[] = new int[n];
        
        for(int i = n-1; i>=n; i++) {
        	 if(i+k >= n)
                arr[i] = nums[i+k-n];
             else
                 arr[i] = nums[i+k];
        }
        
        for(int i = 0; i<n; i++) {
            nums[i] = arr[i];
        }
    }
}