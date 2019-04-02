/**
 * Developer:       KOleman Pa
 * Date:            4/2/2019
 * Program:         Insertion Sort
 * Purpose:         Using insertion Sort
 * @author kp0885055
 */

public class InsertionSort {

    public static void insertionSort(int[] list){
        // THIS method will do the sort , it expects an array of ints as a parameter
        for(int i = 1; i<list.length; i++){
            int currentElement = list[i];
            int k;
            for (k = i-1; k>= 0 && list[k] > currentElement; k--){
                list[k+1] = list[k];
            }  // END k for loop
            list[k+1] = currentElement;
        }      // END i for loop
    }          // END of insertionSort
    
    public static void main(String[] args) {
        int[] list = {2,-3,4,5,6,7,8,9,92,3,23,-1};
        insertionSort(list);
        for (int i=0; i < list.length; i++)
            System.out.println(list[i] + " ");
           
    }
    
}
