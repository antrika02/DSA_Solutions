class Solution {
    public boolean checkOverlap(int radius, int xCenter, int yCenter,
                                int x1, int y1, int x2, int y2) {

        int x = Math.max(x1, Math.min(xCenter, x2));
        int y = Math.max(y1, Math.min(yCenter, y2));

        int dx = x - xCenter;
        int dy = y - yCenter;

        return dx * dx + dy * dy <= radius * radius;
    }
}