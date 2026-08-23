class Solution {
    public int nthUglyNumber(int n, int a, int b, int c) {
        long lo = 1;

        long hi = 2000000000L;

        long ab = lcm(a, b);

        long ac = lcm(a, c);

        long bc = lcm(b, c);

        long abc = lcm(ab, c);

        while (lo < hi) {

            long mid = lo + (hi - lo) / 2;

            long cnt = mid / a

                    + mid / b

                    + mid / c

                    - mid / ab

                    - mid / ac

                    - mid / bc

                    + mid / abc;

            if (cnt >= n)

                hi = mid;

            else

                lo = mid + 1;

        }

        return (int) lo;

    }

    private long gcd(long a, long b) {

        while (b != 0) {

            long t = a % b;

            a = b;

            b = t;

        }

        return a;

    }

    private long lcm(long a, long b) {

        return (a / gcd(a, b)) * b;
    }
}