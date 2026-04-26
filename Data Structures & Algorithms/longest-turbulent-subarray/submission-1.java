class Solution {
    int arr[];

    public int maxTurbulenceSize(int[] arr) {
        this.arr = arr;
        int n = arr.length;
        if (n == 0) return 0;
        int max = 1;
        
        // Brute force: Check every subarray (start, end)
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isTurbulent(i, j))
                    max = Math.max(max, j - i + 1);
                else 
                    break; // Optimization: If i...j isn't turbulent, i...j+1 won't be either
            }
        }
        return max;
    }

    private boolean isTurbulent(int start, int end) {
        // Pattern 1: High, Low, High... (arr[i] > arr[i+1] < arr[i+2])
        boolean pattern1 = true;
        for (int i = start; i < end; i++) {
            if ((i - start) % 2 == 0) {
                if (!(arr[i] > arr[i + 1])) pattern1 = false;
            } else {
                if (!(arr[i] < arr[i + 1])) pattern1 = false;
            }
        }

        // Pattern 2: Low, High, Low... (arr[i] < arr[i+1] > arr[i+2])
        boolean pattern2 = true;
        for (int i = start; i < end; i++) {
            if ((i - start) % 2 == 0) {
                if (!(arr[i] < arr[i + 1])) pattern2 = false;
            } else {
                if (!(arr[i] > arr[i + 1])) pattern2 = false;
            }
        }

        return pattern1 || pattern2;
    }
}
