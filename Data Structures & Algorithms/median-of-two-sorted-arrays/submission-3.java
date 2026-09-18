class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int median1 = 0;
        int median2 = 0;
        int i = 0;
        int j = 0;
        int n1 = nums1.length;
        int n2 = nums2.length; 
        for (int index = 0; index <= (n1 + n2)/2; index++) {
            median2 = median1;
            if (i < n1 && j < n2) {
                if (nums1[i] <= nums2[j]) {
                    median1 = nums1[i];
                    i++;
                } else {
                    median1 = nums2[j];
                    j++;
                }
            } else if (i < n1) {
                median1 = nums1[i];
                i++;
            } else if (j < n2) {
                median1 = nums2[j];
                j++;
            }
        }
        if ((n1 + n2)%2 == 0) {
            return (double) (median1 + median2)/2;
        } else {
            return (double) median1;
        }
    }
}
