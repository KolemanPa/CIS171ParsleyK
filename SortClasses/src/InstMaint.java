/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class InstMaint {
    
    private int[] instArray;
    private int size;
    public InstMaint(int size){
        instArray = new int[size];
        this.size = size;
    }
    
    public void randomArray(){
        instArray = SortMaint.randomArray(size);
    }
    public void printArray(){
        SortMaint.printArray(instArray);
        
    }
    
}
