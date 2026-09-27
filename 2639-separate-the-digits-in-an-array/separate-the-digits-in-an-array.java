class Solution {
    public int[] separateDigits(int[] nums) {

        List<Integer> list = new ArrayList<>();

        for (int num : nums) {

            List<Integer> digits = new ArrayList<>();

            while (num > 0) {
                digits.add(num % 10);
                num = num / 10;
            }

            // digits reverse mein aaye hain
            for (int i = digits.size() - 1; i >= 0; i--) {
                list.add(digits.get(i));
            }
        }

        // List<Integer> → int[]
        int[] answer = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}