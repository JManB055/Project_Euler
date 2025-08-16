/* Joshua Wyckoff
 * Problem 3: Largest Prime Factor
 * The prime factors of 13195 are 5, 7, 13, and 29.
 * What is the largest prime factor of the number 600851475143?
 */

public class App {
    // Array to hold previously found prime numbers
    // Starts with the first prime number, 2
    static long[] primes = new long[] {2};
    public static void main(String[] args) throws Exception {
        long number = 600851475143L;
        //long number = 13195L; // Change this to test with different numbers

        System.out.println("Finding Prime Numbers...");
        for (long i = 3L; i <= (Math.sqrt(number)); i+=2) {
            isPrime(i);
        }
        
        System.out.println("Checking for Prime Factors...");
        System.out.println("Largest Prime Factor: " + findPrimeFactor(number));
        //System.out.println(primes);
    }

    // Function to determine if a number is prime. Relies on previous prime numbers to be found first.
    static boolean isPrime(long n) {
        // Checks to see if n is prime by checking if it is divisible by any of the previously found primes
        for (long prime : primes) {
            //if ((double)(n/prime) == (double)n / prime) {
            if (n % prime == 0) {
                // If n is divisible by a prime, it is not prime and returns false
                return false;
            }
        }

        // Create a new array with the new prime number
        long[] temp = new long[primes.length + 1];
        for (int i = 0; i < primes.length; i++) {
            temp[i] = primes[i];
        }
        temp[temp.length - 1] = n;
        primes = temp;

        // Returns true (At this point, we know n is prime)
        return true;
    }

    // Function to find the largest prime factor of n based on the previously found primes
    static long findPrimeFactor(long n) {
        // Iterate through the primes array in reverse order to find the largest prime factor
        for (int i = primes.length - 1; i >= 0; i--) {
            long testPrime = primes[i];
            if (n % testPrime == 0) return testPrime;
        }
        return 0;
    }
}
