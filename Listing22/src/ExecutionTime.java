/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class ExecutionTime {
          public static void main(String[] args) {
              long startPrimeTime = System.currentTimeMillis();
              ExecutionPrime.main(args);
              long endPrimeTime = System.currentTimeMillis();
              
              long startEffPrime = System.currentTimeMillis();
              ExecutionEffPrime.main(args);
              long endEffPrime = System.currentTimeMillis();
              
              long startSievePrime = System.currentTimeMillis();
              SieveOfEratosthenes.main(args);
              long endSievePrime = System.currentTimeMillis();
              
              
              
              System.out.println("THE RESULTS ARE IN");
              System.out.println("LISTING 22.5 took "+(endPrimeTime-startPrimeTime));
              System.out.println("LISTING 22.6 took "+(endEffPrime-startEffPrime));
              System.out.println("LISTING 22.7 took "+(endSievePrime-startSievePrime));
              
              
              
          }
}
