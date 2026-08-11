class Solution {
    public int search(int[] nums, int target) {
int pivot= findPivot(nums);
if (target >= nums[pivot] && target <= nums[nums.length - 1]) {
return binarySearch(nums, pivot, nums.length - 1, target);
        }
else
return binarySearch(nums, 0, pivot - 1, target);
        }


public int findPivot(int[] nums){
    int start=0;
int end=nums.length-1;
   if (nums[start] <= nums[end]) {
            return 0;
        }

        while (start <= end) {

            int mid = start + (end - start) / 2;

            // Pivot mil gaya
            if (mid > 0 && nums[mid] < nums[mid - 1]) {
                return mid;
            }

            if (nums[mid] >= nums[0]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return 0;
    }
    public int binarySearch(int[] nums,int start,int end,int target){
    while(start<=end){
    int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return -1;
}}