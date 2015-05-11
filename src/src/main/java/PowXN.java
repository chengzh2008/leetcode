package src.main.java;

/**
 * Implement pow(x, n).
 * <p>
 * Show Tags
 */
public class PowXN {
    // devide and conque!
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        double temp = myPow(x, n/2);
        if (n%2 == 0) {
            return temp*temp;
        } else {
            if (n > 0) {
                return x * temp * temp;
            } else {
                return temp * temp / x;
            }
        }
    }

    public static void main(String[] args) {
        PowXN powXN = new PowXN();
        System.out.println(powXN.myPow(0.1, 0));
        System.out.println(powXN.myPow(0.1, 2));
        System.out.println(powXN.myPow(	0.00001, 2147483647));
    }
}
