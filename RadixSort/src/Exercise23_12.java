
// IMPORTS
import java.util.*;

/**
 * Developer:           Koleman Pa
 * Date:                4/9/19
 * Program:             Radix Sort
 * Help:                Used online resources to aid the process
 * @author theko
 */

public class Exercise23_12 {

  
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
    static void radixsort(int arr[], int n) { 


        int m = getMax(arr, n); 
  
        for (int exp = 1; m/exp > 0; exp *= 10) 
            countSort(arr, n, exp); 
    } 
  
    static void print(int arr[], int n) { 
        for (int i=0; i<n; i++) 
            System.out.print(arr[i]+" "); 
    } 
  
  
    public static void main (String[] args) { 
        int arr[] = {45,9,4,5,6,7,43,64};
        int n = arr.length; 
        radixsort(arr, n); 
        print(arr, n); 
    } 
} 
    
