class Solution {
    public boolean validUtf8(int[] data) {

        int rem = 0;

        for (int x : data) {

            x &= 255;

            if (rem == 0) {

                if ((x >> 7) == 0) {
                    continue;
                } else if ((x >> 5) == 0b110) {
                    rem = 1;
                } else if ((x >> 4) == 0b1110) {
                    rem = 2;
                } else if ((x >> 3) == 0b11110) {
                    rem = 3;
                } else {
                    return false;
                }

            } else {

                if ((x >> 6) != 0b10) {
                    return false;
                }

                rem--;
            }
        }

        return rem == 0;
    }
}