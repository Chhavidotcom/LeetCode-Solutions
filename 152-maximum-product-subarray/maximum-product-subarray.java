class Solution {
    public int maxProduct(int[] nums) {

        int maxProd = nums[0];
        int minProd = nums[0];
        int answer = nums[0];

        for (int i = 1; i < nums.length; i++) {

            int num = nums[i];

            int oldMax = maxProd;
            int oldMin = minProd;

            maxProd = Math.max(
                num,
                Math.max(num * oldMax, num * oldMin)
            );

            minProd = Math.min(
                num,
                Math.min(num * oldMax, num * oldMin)
            );

            answer = Math.max(answer, maxProd);
        }

        return answer;
    }
}