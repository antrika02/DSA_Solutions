class Solution {
    public int smallestNumber(int n, int t) {
       int x = n;

        while (true) {

            int p = 1;

            int y = x;

            if (y == 0) {

                p = 0;

            } else {

                while (y > 0) {

                    p *= (y % 10);

                    y /= 10;

                }

            }

            if (p % t == 0) {

                return x;

            }

            x++;

        } 
    }
}