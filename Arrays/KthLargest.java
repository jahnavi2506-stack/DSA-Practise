class Solution {
    private Random rand = new Random();

    public int findKthLargest(int[] nums, int k) {
        int target = nums.length - k;
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int pivotIndex = left + rand.nextInt(right - left + 1);
            int pivot = nums[pivotIndex];

            // 3-way partition
            int lt = left, i = left, gt = right;

            while (i <= gt) {
                if (nums[i] < pivot) {
                    swap(nums, lt++, i++);
                } else if (nums[i] > pivot) {
                    swap(nums, i, gt--);
                } else {
                    i++;
                }
            }
            if (target < lt) {
                right = lt - 1;
            } else if (target > gt) {
                left = gt + 1;
            } else {
                return nums[target];
            }
        }
        return -1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
} //o(n) , o(1)
