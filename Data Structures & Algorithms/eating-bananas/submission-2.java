class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = piles[0];
        for (int pile : piles) {
            r = Math.max(r, pile);
        }
        int max = r;
        while (l <= r) {
            int mid = l + (r - l)/2;
            if (checkRate(mid, piles, h) < 0) {
                l = mid + 1;
            } else if (checkRate(mid, piles, h) >= 0) {
                r = mid - 1;
            }
        }
        if (l < 1) {
            return 1;
        } else if (l > max) {
            return max;
        }
        return l;
    }

    int checkRate(int rate, int[] piles, int h) {
        long hours = 0;
        for (int pile : piles) {
            hours += (pile + rate - 1L) / rate;
        }
        if (hours == h) {
            return 0;
        } else if (hours < h) {
            return 1;
        }
        return -1;       
    }
}