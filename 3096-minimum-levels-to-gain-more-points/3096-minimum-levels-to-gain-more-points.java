class Solution {
    public int minimumLevels(int[] possible) {
       int total = 0;

        for (int x : possible)

            total += x == 1 ? 1 : -1;

        int alice = 0;

        for (int i = 0; i < possible.length - 1; i++) {

            alice += possible[i] == 1 ? 1 : -1;

            int bob = total - alice;

            if (alice > bob)

                return i + 1;

        }

        return -1; 
    }
}