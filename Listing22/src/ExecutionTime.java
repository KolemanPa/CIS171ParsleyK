/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Scanner;
public class ExecutionTime {
          public static void main(String[] args) {
              System.out.println("Whate number are we calculating till?");
              Scanner sc = new Scanner(System.in);
              int num = sc.nextInt();
              long startPrimeTime = System.currentTimeMillis();
              ExecutionPrime.test(num);
              long endPrimeTime = System.currentTimeMillis();
              
              long startEffPrime = System.currentTimeMillis();
              ExecutionEffPrime.test(num);
              long endEffPrime = System.currentTimeMillis();
              
              long startSievePrime = System.currentTimeMillis();
              SieveOfEratosthenes.test(num);
              long endSievePrime = System.currentTimeMillis();
              
              
              
              System.out.println("THE RESULTS ARE IN");
              System.out.println("LISTING 22.5 took "+(endPrimeTime-startPrimeTime));
              System.out.println("LISTING 22.6 took "+(endEffPrime-startEffPrime));
              System.out.println("LISTING 22.7 took "+(endSievePrime-startSievePrime));
              
              
              
          }
}
