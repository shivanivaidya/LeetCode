/*

Description:

Count the number of prime numbers less than a non-negative number, n.

*/

public class Problem204 {
    // Sieve of Eratosthenes - visit all prime nos and mark their multiples as composite.
    public int countPrimes(int n) {
        boolean[] numbers = new boolean[n];
        int count = 0;
        for (int i=2; i<n; i++) {
            if (numbers[i])
                continue;
             
            count++;
            for (int j=i; j<n; j=j+i)
                numbers[j] = true;
        }
         
        return count;
    }
}