class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {
        Map<Integer, List<Integer>> dict_x = new HashMap<>();
        Map<Integer, List<Integer>> dict_y = new HashMap<>();
        for (int[] build : buildings) {
            int x = build[0], y = build[1];
            dict_x.computeIfAbsent(x, k -> new ArrayList<>()).add(y);
            dict_y.computeIfAbsent(y, k -> new ArrayList<>()).add(x);
        }
        for (List<Integer> list : dict_x.values()) {
            Collections.sort(list);
        }
        for (List<Integer> list : dict_y.values()) {
            Collections.sort(list);
        }

        int res = 0;
        for (int[] build : buildings) {
            int x = build[0], y = build[1];
            List<Integer> ox = dict_x.get(x);
            List<Integer> oy = dict_y.get(y);
            if (oy.get(0) < x && oy.get(oy.size() - 1) > x && ox.get(0) < y && ox.get(ox.size() - 1) > y) {
                res++;
            }
        }
        return res;
    }
}