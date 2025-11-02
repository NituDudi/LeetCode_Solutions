class Solution {
    public double myPow(double x, int n) {
        // x^n
        if (n == 0) {
            return 1;
        }

        if (n < 0) {
            x = 1 / x;
            if (n == Integer.MIN_VALUE) {
                return x * myPow(x, -(n + 1));
            }
            n = -n;
        }

        double halfpower = myPow(x, n / 2);

        if (n % 2 == 0) {  // even power
            return halfpower * halfpower;
        } else {
            return x * halfpower * halfpower;
        }
    }
}
