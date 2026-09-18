class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = piles[0];
        for (int pile : piles) {
            r = Math.max(r, pile);
        }
        int minimumRate = Integer.MAX_VALUE;
        while (l <= r) {
            int mid = l + (r - l)/2;
            if (checkRate(mid, piles, h) < 0) {
                l = mid + 1;
            } else if (checkRate(mid, piles, h) >= 0) {
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
                hoursPerPile = 1;
            } else {
                hoursPerPile = pile/rate;
                if (pile%rate > 0) {
                    hoursPerPile++;
                }
            }
            hours += hoursPerPile;
        }
        if (hours > h) {
            return -1;
        } else if (hours < h) {
            return 1;
        } else {
            return 0;
        }
             
    }
}