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
       
        PrintWriter writer = null;
        try{
            writer = new PrintWriter("out.txt");
        }
        catch (IOException e){
            
        }
        long startTime = 0;
        long methodTime = 0;
        writer.print("Multiple Oddonaci:\n\n");
        for (int i = 5; i < 40; i = i +5){
            startTime = System.currentTimeMillis();
            BigInteger bigInt = new BigInteger("0");
            bigInt = bigInt.valueOf(multipleOddonaci(i));
            methodTime = System.currentTimeMillis() - startTime;
            writer.print("i = " + i + "\nmultipleOddonaci(" +i + ") = " + bigInt + "\nTime = " + methodTime + " milliseconds\n");
        }
        writer.print("\nLinear Oddonaci:\n\n");
        for (int i = 5; i <= 105; i = i +5){
            startTime = System.currentTimeMillis();
            methodTime = System.currentTimeMillis() - startTime;
            writer.print("i = " + i + "\nlinearOddonaci(" +i + ") = " + Arrays.toString(linearOddonaci(i)) + "\nTime = " + methodTime + " milliseconds\n");
        }
        writer.close();
    }
    /**
     * Algorithm multipleOddonacci(n)
     * Input: A nonnegative integer n
     * Output: The nth Oddonacci number On
     * if n <= 3 
     *  return 1
     * else
     *  return multipleOddonaci(n-1) + multipleOddonaci(n-2) + multipleOddonaci(n-3)
     */
    public static int multipleOddonaci(int n){
        if (n <= 3)
            return 1;
        else
            return multipleOddonaci(n-1) + multipleOddonaci(n-2) + multipleOddonaci(n-3);
    }
    /**
     * Algorithm linearOddonacci
     * Input: A nonnegative integer n
     * Output: The nth Oddonaci number On
     * if n <= 3
     *  return (1,1,1)
     * else
     *  (i,j,k) = linearOddonacci(n-1)
     *  return (i+j+k, i, j)
     * 
     */
    public static BigInteger[] linearOddonaci(int n){
        if (n <= 3)
            return new BigInteger[] {BigInteger.ONE,BigInteger.ONE,BigInteger.ONE};
        else{
            BigInteger[] temp = linearOddonaci(n-1);
            return new BigInteger[]{(temp[0]).add((temp[1])).add((temp[2])), temp[0], temp[1]};
        }
    }
}
