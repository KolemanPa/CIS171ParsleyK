
// IMPORTS
import java.util.Scanner;

/**
 * Developer:       KolemanPa
 * Date:            4/2/2019
 * Program:         Execution time for prime numbers
 * @author kp0885055
 */

public class ExecutionPrime extends ExecutionTime{
    public static void test(int temp){
        

    Scanner input = new Scanner(System.in);
    System.out.print("Find all prime numbers <= n, enter n: ");
    int n = temp;
    long startTime = System.currentTimeMillis();


    final int NUMBER_PER_LINE = 10; // Display 10 per line
    int count = 0; // Count the number of prime numbers
    int number = 2; // A number to be tested for primeness

    System.out.println("The prime numbers are:");

    // Repeatedly find prime numbers
    while (number <= n) {
      // Assume the number is prime
      boolean isPrime = true; // Is the current number prime?

      // ClosestPair if number is prime
      for (int divisor = 2; divisor <= (int)(Math.sqrt(number)); 
          divisor++) {
        if (number % divisor == 0) { // If true, number is not prime
          isPrime = false; // Set isPrime to false          
          break; // Exit the for loop
        }
      }

      // Print the prime number and increase the count
      if (isPrime) {
        count++; // Increase the count

        if (count % NUMBER_PER_LINE == 0) {
          // Print the number and advance to the new line
          System.out.printf("%10d\n", number);
        }
        else
          System.out.printf("%10d", number);
      }

      // Check if the next number is prime
      number++;
    }
    
    System.out.println("\n" + count + 
      " prime(s) less than or equal to " + n);
    long endTime = System.currentTimeMillis();
      System.out.println("Execution Time took " +(endTime-startTime)+ " Milliseconds");
      
    }
  public static void main(String[] args) {

  }




}