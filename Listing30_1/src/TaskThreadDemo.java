//IMPORTS



/**
 * 
 * Developer:       Koleman Pa
 * Date:            4/16/19
 * Program:         Task Thread
 */
public class TaskThreadDemo {

    public static void main(String[] args) {
        // CREATE our tasks
        Runnable printA = new PrintChar('a',100);
        Runnable printB = new PrintChar('b',100);
        Runnable print100 = new PrintNum(100);
        
        // Create threads to hold the tasks
        Thread thread1 = new Thread(printA);
        Thread thread2 = new Thread(printB);
        Thread thread3 = new Thread(print100);
        
        // Start the threads
        thread1.start();
        thread2.start();
        thread3.start();
    }
    
}


class PrintChar implements Runnable {
    private char charToPrint;       // the charector to print
    private int times;              //the number to print
    
    // Constructor - construct a task with a specified character
    // and number of times to print the charactor
    public PrintChar(char c, int t){
        charToPrint = c;
        times = t;
    }
    
    @Override
    public void run(){
        for (int i = 0; i < times; i++){
            System.out.print(" "+charToPrint);
        }
    }
    
}


class PrintNum implements Runnable {
    private int lastNum;              //the last number
    
    // Constructor - construct a task with a specified number
    public PrintNum(int n){
        lastNum = n;
    }
    
    @Override
    public void run(){
        for (int i = 0; i < lastNum; i++){
            System.out.print(" " +i);
        }
    }
    
}