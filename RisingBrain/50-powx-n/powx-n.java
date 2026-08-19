class Solution {
    public double myPow(double x, int n) {
        //ChargeBee | Software Engineer | 12LPA
        // Use binary exponentiation: multiply ans when n is odd and square x while halving the n.
        // Convert negative n using 1/x and use long to safely handle Integer.MIN_VALUE(corner case).

        double ans = 1.0;
        long num = n;

        if (n < 0) {
            num = -num;
            x = 1 / x;
        }

        while (num > 0) {

            if (num % 2 == 1) {
                ans = ans * x;
                num = num - 1;
            } else {
                x = x * x;
                num = num / 2;
            }
        }
        return ans;
    }
}