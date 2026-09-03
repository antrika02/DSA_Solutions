class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int m = flowerbed.length;
        int c = 0;

        for (int i = 0; i < m; i++) {
            if (flowerbed[i] == 0
                && (i == 0 || flowerbed[i - 1] == 0)
                && (i == m - 1 || flowerbed[i + 1] == 0)) {
                flowerbed[i] = 1;
                c++;
                if (c >= n) return true;
            }
        }

        return c >= n;
    }
}