class Solution {
    public int calPoints(String[] operations) {
        int[] arr = new int[1000];
        int i = 0;
        for (String op : operations) {
            if ("D".equals(op)) {
                arr[i] = 2 * arr[i -1];
                i++;
            } else if ("C".equals(op)) {
                arr[i - 1] = 0;
                i--;
            } else if ("+".equals(op)) {
                arr[i] = arr[i - 1] + arr[i - 2];            
                i++;
            } else {
                arr[i] = Integer.valueOf(op);
                i++;
            }
        }
        int sum = 0;
        for (int j = 0; j < i; j++) {
            sum += arr[j];
        }
        return sum;
    }
}