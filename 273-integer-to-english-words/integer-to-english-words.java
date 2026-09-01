class Solution {

    String[] belowTwenty = {
        "", "One", "Two", "Three", "Four",
        "Five", "Six", "Seven", "Eight",
        "Nine", "Ten", "Eleven", "Twelve",
        "Thirteen", "Fourteen", "Fifteen",
        "Sixteen", "Seventeen", "Eighteen",
        "Nineteen"
    };

    String[] tens = {
        "", "", "Twenty", "Thirty", "Forty",
        "Fifty", "Sixty", "Seventy",
        "Eighty", "Ninety"
    };

    public String numberToWords(int num) {

        if (num == 0) {
            return "Zero";
        }

        StringBuilder result = new StringBuilder();

        if (num >= 1_000_000_000) {
            result.append(helper(num / 1_000_000_000));
            result.append(" Billion ");
            num %= 1_000_000_000;
        }

        if (num >= 1_000_000) {
            result.append(helper(num / 1_000_000));
            result.append(" Million ");
            num %= 1_000_000;
        }

        if (num >= 1000) {
            result.append(helper(num / 1000));
            result.append(" Thousand ");
            num %= 1000;
        }

        if (num > 0) {
            result.append(helper(num));
        }

        return result.toString().trim();
    }

    private String helper(int num) {

        StringBuilder result = new StringBuilder();

        if (num >= 100) {
            result.append(belowTwenty[num / 100]);
            result.append(" Hundred ");
            num %= 100;
        }

        if (num >= 20) {
            result.append(tens[num / 10]);
            result.append(" ");
            num %= 10;
        }

        if (num > 0) {
            result.append(belowTwenty[num]);
        }

        // Important: extra spaces remove
        return result.toString().trim();
    }
}