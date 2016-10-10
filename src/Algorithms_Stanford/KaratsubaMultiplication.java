package Algorithms_Stanford;

import java.math.BigInteger;

/**
 * Karatsuba Multiplication
 *
 * x = 10^(n/2) * a + b
 * y = 10^(n/2) * c + d
 * x*y = 10^n * ac + 10^(n/2) * (ad+bc) + bd
 * ad+bc = (a+b)(c+d) - ac - bd
 */
public class KaratsubaMultiplication {
    public static BigInteger karatsuba(BigInteger x, BigInteger y) {
        int N = Math.max( x.bitLength(), y.bitLength());
        if(N <= 2000)
            return x.multiply(y);

        N = (N / 2) + (N % 2);

        // x = 10^(n/2) * a + b
        // y = 10^(n/2) * c + d
        BigInteger a = x.shiftRight(N);
        BigInteger b = x.subtract(a.shiftLeft(N));
        BigInteger c = y.shiftRight(N);
        BigInteger d = y.subtract(c.shiftRight(N));

        BigInteger ac = karatsuba(a, c);
        BigInteger bd = karatsuba(b, d);
        BigInteger abcd = karatsuba(a.add(b), c.add(d));

        return bd.add(abcd.subtract(ac).subtract(bd).shiftLeft(N)).add(ac.shiftLeft(2*N));
    }

    public static void main(String[] args) {
        BigInteger x = new BigInteger("3141592653589793238462643383279502884197169399375105820974944592");
        BigInteger y = new BigInteger("2718281828459045235360287471352662497757247093699959574966967627");
        System.out.println(karatsuba(x,y).toString());
    }
}
