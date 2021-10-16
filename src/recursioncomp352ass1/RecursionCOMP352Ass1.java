/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursioncomp352ass1;

import java.io.PrintWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;
/**
 * 
 * @author Zakary
 */
public class RecursionCOMP352Ass1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //To output the running times of the 3 algorithms to a text file
        PrintWriter writer = null;
        try{
            writer = new PrintWriter("out.txt");
        }
        catch (IOException e){
            System.out.println("Error opening file");
        }
        //To calculate the starting time of the algorithms
        long startTime = 0;
        //To calculate the ending time of the algorithms
        long methodTime = 0;
        
        //Calculates and outputs the first 40 input of the multiple odonacci in increments of 5
        writer.print("Multiple Oddonaci:\n\n");
        for (int i = 5; i < 45; i = i +5){
            startTime = System.nanoTime();
            BigInteger bigInt = new BigInteger("0");
            bigInt = bigInt.valueOf(multipleOddonaci(i));
            methodTime = System.nanoTime() - startTime;
            writer.print("i = " + i + "\nmultipleOddonaci(" +i + ") = " + bigInt + "\nTime = " + methodTime + " milliseconds\n");
        }
        
        //Calculates and outputs the first 40 input of the linear odonacci in increments of 5
        writer.print("\nLinear Oddonaci:\n\n");
        for (int i = 5; i < 105; i = i +5){
            startTime = System.nanoTime();
            String arrayAsString = Arrays.toString(linearOddonaci(i));
            methodTime = System.nanoTime() - startTime;
            writer.print("i = " + i + "\nlinearOddonaci(" +i + ") = " + arrayAsString + "\nTime = " + methodTime + " milliseconds\n");
        }
        
        //Calculates and outputs the first 40 input of the tail odonacci in increments of 5
        writer.print("\nTail Oddonaci:\n\n");
        for (int i = 5; i < 105; i = i +5){
            startTime = System.nanoTime();
            String arrayAsString = Arrays.toString(wrapperOddonaci(i));
            methodTime = System.nanoTime() - startTime;
            writer.print("i = " + i + "\ntailOddonaci(" +i + ") = " + arrayAsString + "\nTime = " + methodTime + " milliseconds\n");
        }
        
        //To ensure that all text is written to the file
        writer.close();
    }
    
    //Multiple recursion Oddonaci calculator
    //Input: A nonnegative integer n
    //Output: The nth Oddonacci number On
    public static int multipleOddonaci(int n){
        
        //Base case of Oddonaci
        if (n <= 3)
            return 1;
        else
            return multipleOddonaci(n-1) + multipleOddonaci(n-2) + multipleOddonaci(n-3); //previous Oddonaci number, previousprevious Oddonaci number, previouspreviousprevious Oddonaci number
    }                                                                                     
    
    //Linear recursion Oddonaci calculator
    //Input: A nonnegative integer n
    //Output: Tuple of Oddonaci numbers(On,On-1, On-2)
    public static BigInteger[] linearOddonaci(int n){
        
        //Base case of Oddonaci
        if (n <= 3)
            return new BigInteger[] {BigInteger.ONE,BigInteger.ONE,BigInteger.ONE}; 
        else{
            BigInteger[] temp = linearOddonaci(n-1);
            return new BigInteger[]{temp[0].add(temp[1]).add(temp[2]), temp[0], temp[1]}; //current Oddonaci number, previous Oddonaci number, previousprevious Oddonaci number                                                                                 //previous + previousprevious + previouspreviousprevious, previous, previousprevious
        }                                                                                 //previous + previousprevious + previouspreviousprevious, previous, previousprevious
    }                                                                                        
    
    //Wrapper method for the tail recursions
    //Calls the tail oddonaci function
    public static BigInteger[] wrapperOddonaci(int n){
        return tailOddonaci(n, new BigInteger[]{BigInteger.ONE, BigInteger.ONE, BigInteger.ONE});
    }
    
    //Tail recursion Oddonaci calculator
    //Input: A nonnegative integer n, an array A of integers
    //Output: Tuple of Oddonaci numbers(On,On-1, On-2)
    public static BigInteger[] tailOddonaci(int n, BigInteger[] a){
        
        //Base case of Oddonaci
        if (n <= 3)
            return new BigInteger[]{a[0], a[1], a[2]}; //Returns Oddonaci(n), Oddonaci(n-1),Oddonaci(n-2)
        else{
            return tailOddonaci(n-1,new BigInteger[]{a[0].add(a[1]).add(a[2]), a[0], a[1]}); //current Oddonaci number, previous Oddonaci number, previousprevious Oddonaci number
        }                                                                                    //previous + previousprevious + previouspreviousprevious, previous, previousprevious     
    }
}
