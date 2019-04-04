/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kp0885055
 */
public class Listing23_2 {

    public static void insertionSort(int[] list){
        for (int i = 1; i <list.length; i++){
            int currentElement = list[i];
            int k;
            for(k=1;k>=0 && list[k] > currentElement; k--){
                list[k+1]=list[k];
            }       // end of k loop
                list[k+1]=currentElement;
        }
    }

    public static void main(String[] args) {
        int[] list ={12,3,2,5,-2};
        insertionSort(list);
        for(int i = 0; i < list.length; i++){
            System.out.println(list[i] + " ");
        }
    }
    
}
