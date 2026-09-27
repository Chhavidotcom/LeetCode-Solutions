class Solution {
    public int earliestFinishTime(
        int[] landStartTime,
        int[] landDuration,
        int[] waterStartTime,
        int[] waterDuration
    ) {

        int ans = Integer.MAX_VALUE;

        // Land -> Water
        for (int i = 0; i < landStartTime.length; i++) {

            int landFinish =
                landStartTime[i] + landDuration[i];

            for (int j = 0; j < waterStartTime.length; j++) {

                int waterStart =
                    Math.max(landFinish, waterStartTime[j]);

                int finish =
                    waterStart + waterDuration[j];

                ans = Math.min(ans, finish);
            }
        }

        // Water -> Land
        for (int j = 0; j < waterStartTime.length; j++) {

            int waterFinish =
                waterStartTime[j] + waterDuration[j];

            for (int i = 0; i < landStartTime.length; i++) {

                int landStart =
                    Math.max(waterFinish, landStartTime[i]);

                int finish =
                    landStart + landDuration[i];

                ans = Math.min(ans, finish);
            }
        }

        return ans;
    }
}