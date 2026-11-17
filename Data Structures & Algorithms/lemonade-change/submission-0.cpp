class Solution {
public:
    bool lemonadeChange(vector<int>& bills) {
        int five = 0, ten = 0;
        
        for (int b : bills) {
            if (b == 5) five++;
            else if (b == 10) ten++;

            int change = b - 5;
            if (change == 5) {
                if (five > 0) five--;
                else return false;
            } else if (change == 15) {
                if (ten > 0 && five > 0) {
                    five--;
                    ten--;
                } else if (five >= 3) five -= 3;
                else return false;
            }
        }

        return true;
    }
};