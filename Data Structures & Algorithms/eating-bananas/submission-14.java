class Solution {
    //core idea is to find the minimum rate of banana eating per hours from the range of 1 to max of piles
    // record the rate in minimumRate once mid (rate) is greater than the "h"

    //also this question unlocks the idea that in order to use Binary Search we can use custom criterias

    public int minEatingSpeed(int[] piles, int h) {
        int l = 1; // minimum rate
        int r = piles[0];
        for (int pile : piles) {
            r = Math.max(r, pile); // calculating the max
        }
        // now r is the maximum rate
        int minimumRate = r;
        while (l <= r) {
            int mid = l + (r - l)/2;
            if (checkRate(mid, piles, h) < 0) { // if rate is less, then we need to start searching in mid + 1 to right
                l = mid + 1;
            } else if (checkRate(mid, piles, h) >= 0) {
                // if rate is more or equal, then first record the minimumRate as it could be pottential answer
                // and start seaching in l to mid - 1 to find even lesser minimumRate
                minimumRate = Math.min(mid, minimumRate);
                r = mid - 1;
            }
        }
        return minimumRate;
    }

    int checkRate(int rate, int[] piles, int h) {
        long hours = 0;
        for (int pile : piles) {
            int hoursPerPile = 0;
            if (pile <= rate) {
                hoursPerPile = 1; //because we cannot change to next pile in same hour
            } else {
                hoursPerPile = pile/rate; //to calculate straight away the hours required
                if (pile%rate > 0) {
                    hoursPerPile++; // addional hour to complete residual bananas
                }
            }
            hours += hoursPerPile;
        }
        if (hours > h) {
            return -1; // not sufficient, increase the rate in caller method
        } else if (hours < h) {
            return 1; // sufficient, decrease the rate in caller method to check next candidate
        } else {
            return 0;
        }
             
    }
}