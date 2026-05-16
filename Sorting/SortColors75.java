class Solution {
    public void sortColors(int[] nums) {

        int low = 0;
        int mid = 0;
        int high = nums.length - 1;

        while (mid <= high) {

            // CASE 1 : current element is 0
            if (nums[mid] == 0) {

                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;

                low++;
                mid++;
            }

            // CASE 2 : current element is 1
            else if (nums[mid] == 1) {
                mid++;
            }

            // CASE 3 : current element is 2
            else {

                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;

                high--;

                // IMPORTANT:
                // mid is NOT incremented here
            }
        }
    }
}