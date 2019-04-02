//Imports
import java.util.ArrayList;
import java.util.Scanner;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Developer:       Koleman Pa
 * Date:            3/30/2019
 * Program:         Determine prime numbhers 
 */


public class findingAllPrimNums  extends Application{
    @Override
    public void start(Stage primaryStage){
        BorderPane pane = new BorderPane();
        TextField fieldForPrime = new TextField(" ");
        fieldForPrime.setAlignment(Pos.TOP_RIGHT);
        pane.setTop(fieldForPrime);
        Text prime = new Text("fdsafsa");
        pane.setCenter(prime);
        Text tempText = new Text();
        
        
        
        fieldForPrime.setOnAction(e ->{
           tempText.setText(fieldForPrime.getText()); 
           String stuff = tempText.getText();
           double someNum = Double.parseDouble(stuff);
           int num = (int) Math.round(someNum);
//           prime.setText(num);
           primeOrNo(num);
        });
        
        
        Scene scene = new Scene(pane,500,500);
        primaryStage.setTitle("PRIME");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void primeOrNo(int n){
        int counter =0;
        boolean prime[] = new boolean[n+1]; 
            for(int i=0;i<n;i++) 
                 prime[i] = true; 
          
        for(int p = 2; p*p <=n; p++) {
            // If prime[p] is not changed, then it is a prime 
            if(prime[p] == true) {
                // Update all multiples of p 
                for(int i = p*p; i <= n; i += p) 
                    prime[i] = false; 
            }
        }
          
        ArrayList<Integer> ar1 = new ArrayList<Integer>();
        // Print all prime numbers 
        for(int i = 2; i <= n; i++) {
            if(prime[i] == true) {
                System.out.println(i + " ");
                counter +=1;
            }
        }
        System.out.println(" There Are "+counter+ " Prime Numbers");
    }
        public static void main(String[] args) {
            getTIme(1000000);
            launch(args);
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Please Enter a number");
//        int n = sc.nextInt();
//        
//        System.out.print("Following are the prime numbers "); 
//        System.out.println("smaller than or equal to " + n); 
//        findingAllPrimNums g = new findingAllPrimNums(); 
//        g.primeOrNo(n); 
    }
      

        
        public static void getTIme(long n){
            long startTime = System.currentTimeMillis();
            long k = 0;
            for (long i = 1; i<= n; i++){
                k = k+5;
            }
            long endTime = System.currentTimeMillis();
            System.out.println("Execution TIme for n = "+n+" is " +(endTime-startTime)+ " Milliseconds");
            
        }
        
} 
    
