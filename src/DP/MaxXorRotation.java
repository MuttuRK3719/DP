public class Main {

    public static void main(String[] args) {
        int[] arr = {7, 8, 5, 5, 9, 2, 2, 0, 1, 6};
        System.out.println(maxValue(arr)); // 99
    }

    static int maxValue(int[] arr) {
        int n = arr.length;
        int ans = 0;

        for (int start = 0; start < n; start++) {

            // ---- clockwise ----
            ans = Math.max(ans, compute(arr, start, +1));

            // ---- anticlockwise ----
            ans = Math.max(ans, compute(arr, start, -1));
        }
        return ans;
    }

    static int compute(int[] arr, int start, int dir) {
        int n = arr.length;
        int prefixXor = 0;
        int sum = 0;

        for (int k = 0; k < n; k++) {
            int idx = (start + dir * k + n) % n;
            prefixXor ^= arr[idx];
            sum += prefixXor;
        }
        return sum;
    }
}
