package calc.aca.android.zidansuid.com.primefinder;

/**
 * Created by zidansuid on 9/5/16.
 */
public class PrimeFinder implements Runnable {

    public long target;
    public long prime;
    public boolean finished = false;
    private Thread runner;

    PrimeFinder(long inTarget) {
        target = inTarget;
        if (runner == null) {
            runner = new Thread(this);
            runner.start();
        }
    }

    @Override
    public void run() {
        long numPrimes = 0;
        long candidate = 2;

        while (numPrimes < target) {
            if (isPrime(candidate)) {
                numPrimes++;
                prime = candidate;
                System.out.println("Prime Candidate: " + prime);
            }
            candidate++;
        }
        System.out.println("Number of Primes: " + numPrimes);
        finished = true;
    }

    boolean isPrime(long checkNumber) {
        double root = Math.sqrt(checkNumber);

        for (int i = 2; i <= root; i++) {
            if (checkNumber % i == 0) {
                return false;
            }
        }
        return true;
    }

















}
