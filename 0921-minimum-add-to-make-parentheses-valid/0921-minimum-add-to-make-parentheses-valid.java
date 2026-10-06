class Solution {
    public int minAddToMakeValid(String s) {
        int open = 0;

        int moves = 0;

        

        for (char ch : s.toCharArray()) {
            if (ch == '(') {

                open++;

            }
            else {
                if (open > 0) {

                    open--;

                }
                else {

                    moves++;

                }

            }

        }
        moves += open;

        

        return moves;
    }
}