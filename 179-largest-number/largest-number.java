class Solution {
    public String largestNumber(int[] nums) {

        String[] arr = new String[nums.length];

        // Convert int[] to String[]
        for (int i = 0; i < nums.length; i++) {
            arr[i] = String.valueOf(nums[i]);
        }

        // Custom sorting
        Arrays.sort(arr, (a, b) -> {
            String ab = a + b;
            String ba = b + a;

            return ba.compareTo(ab);
        });

        // Edge case: [0, 0]
        if (arr[0].equals("0")) {
            return "0";
        }

        // Build answer
        StringBuilder ans = new StringBuilder();

        for (String s : arr) {
            ans.append(s);
        }

        return ans.toString();
    }
}