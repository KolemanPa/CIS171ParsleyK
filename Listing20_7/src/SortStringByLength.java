/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kp0885055
 */
public class SortStringByLength {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String[] cities = {"Atlanta", "Savannah", "New York", "Dallas" , "Ava" };
        java.util.Arrays.sort(cities, new MyComparator());
        
        for (String s : cities){
            System.out.println(s+" ");
        }
        
    }
    public static class MyComparator implements java.util.Comparator<String>{
        @Override
        public int compare (String s1, String s2){
            return s1.length() - s1.length();
        }
    }
}
