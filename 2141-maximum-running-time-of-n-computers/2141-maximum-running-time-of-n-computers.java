class Solution {
    public long maxRunTime(int n, int[] batteries) {
        long totalEnergy = 0;
        for (int battery : batteries) {
            totalEnergy = totalEnergy + battery;
        }

        Arrays.sort(batteries);

        for (int i = batteries.length - 1; i >= 0; i--) {
            if (batteries[i] > totalEnergy / n) {
                totalEnergy = totalEnergy- batteries[i];
                n--;
            }
             else {
                break;
            }
        }

        return totalEnergy / n;
    }
}