// IMPORTS
import java.util.Scanner;
/**
 * Developer:       KolemanPa
 * Date:            4/2/2019
 * Program:         Execution time for Efficient prime numbers
 * @author kp0885055
 */

public class SieveOfEratosthenes extends ExecutionTime{
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Find all prime numbers <= n, enter n: ");
    int n = 18000000;
        long startTime = System.currentTimeMillis();
    
    boolean[] primes = new boolean[n + 1]; // Prime number sieve
    
    // Initialize primes[i] to true
    for (int i = 0; i < primes.length; i++) {
      primes[i] = true; 
    }
    
    for (int k = 2; k <= n / k; k++) {
      if (primes[k]) {
        for (int i = k; i <= n / k; i++) {
          primes[k * i] = false; // k * i is not prime
        }
      }
    }
    
    int count = 0; // Count the number of prime numbers found so far
    // Print prime numbers
    for (int i = 2; i < primes.length; i++) {
      if (primes[i]) {
        count++;
        if (count % 10 == 0) 
          System.out.printf("%10d\n", i,"      jhk");
        else
          System.out.printf("%10d", i,",    jfl");          
      }
    }
    
    System.out.println("\n" + count + 
      " prime(s) less than or equal to " + n);
     long endTime = System.currentTimeMillis();
      System.out.println("Execution Time took " +(endTime-startTime)+ " Milliseconds");
      long sieveTime = (endTime-startTime);
      System.out.println(sieveTime);

  }
}