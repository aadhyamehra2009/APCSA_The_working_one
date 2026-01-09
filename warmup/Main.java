package warmup;
import java.math.BigInteger;
public class Main {

    public static long largestPrimeFactor(long n) {
        long maxPrime = -1;
        while (n % 2 == 0) {
            maxPrime = 2;
            n /= 2;
        }
        for (long factor = 3; factor * factor <= n; factor += 2) {
            while (n % factor == 0) {
                maxPrime = factor;
                n /= factor;
            }
        }
        if (n > 2) {
            maxPrime = n;
        }
        return maxPrime;
    }
    //finished
    public static void main(String[] args) {
        BigInteger bigInt = new BigInteger("600851475143");
        long number = bigInt.longValue();
        long result = largestPrimeFactor(number);
        System.out.println(result);
    }
}
