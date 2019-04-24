// IMPORTS
package Sorts;
/**
 * Developer:           Koleman Pa
 * Date:                4/9/19
 * Program:             Radix Sort
 * Help:                Used online resources to aid the process
 * @author theko
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 *
 * @author theko
 */
public class Radix {




  
        // finds the max value
    static int getMax(int arr[], int n) { 
        int max = arr[0]; 
        for (int i = 1; i < n; i++) {
            if (arr[i] > max) {
                max = arr[i]; 
            } // END if
        }     // END for
        return max; 
    } 
  
    
    static void countSort(int arr[], int n, int exp) { 
        // OUTPUT array
        int output[] = new int[n]; 
        int i; 
        int count[] = new int[10]; 
        Arrays.fill(count,0); 
  
        for (i = 0; i < n; i++) {
            count[ (arr[i]/exp)%10 ]++; 
        }
  
        for (i = 1; i < 10; i++){ 
            count[i] += count[i - 1]; 
        }
  
        for (i = n - 1; i >= 0; i--) { 
            output[count[ (arr[i]/exp)%10 ] - 1] = arr[i]; 
            count[ (arr[i]/exp)%10 ]--; 
        } 
  
        for (i = 0; i < n; i++) {
            arr[i] = output[i]; 
        }
    } 
    static void radixsort(ArrayList<Integer> arr, int n) { 


        int m = Collections.max(arr); 
        
  
        for (int exp = 1; m/exp > 0; exp *= 10) 
            countSort(arr, n, exp); 
    } 
  
    static void print(int arr[], int n) { 
        for (int i=0; i<n; i++) 
            System.out.print(arr[i]+" "); 
    } 
  
      public static void test(ArrayList<Integer> a){
        int n = a.size(); 
        radixsort(a, n); 
        print(a, n);  
      }
    public static void main (String[] args) { 

    } 
} 
    
