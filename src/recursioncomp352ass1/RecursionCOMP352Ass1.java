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
        
        System.out.print(Arrays.toString(wrapperOddonaci(5)));
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
            startTime = System.nanoTime();
            BigInteger bigInt = new BigInteger("0");
            bigInt = bigInt.valueOf(multipleOddonaci(i));
            methodTime = System.nanoTime() - startTime;
            writer.print("i = " + i + "\nmultipleOddonaci(" +i + ") = " + bigInt + "\nTime = " + methodTime + " milliseconds\n");
        }
        writer.print("\nLinear Oddonaci:\n\n");
        for (int i = 5; i < 105; i = i +5){
            startTime = System.nanoTime();
            String arrayAsString = Arrays.toString(linearOddonaci(i));
            methodTime = System.nanoTime() - startTime;
            writer.print("i = " + i + "\nlinearOddonaci(" +i + ") = " + arrayAsString + "\nTime = " + methodTime + " milliseconds\n");
        }
        
        writer.print("\nTail Oddonaci:\n\n");
        for (int i = 5; i < 105; i = i +5){
            startTime = System.nanoTime();
            String arrayAsString = Arrays.toString(wrapperOddonaci(i));
            methodTime = System.nanoTime() - startTime;
            writer.print("i = " + i + "\nlinearOddonaci(" +i + ") = " + arrayAsString + "\nTime = " + methodTime + " milliseconds\n");
        }
        
        writer.close();
    }
    /** IMPOSSIBLE TO BE TAIL RECURSIVE. MUST ADAPT TO MAKE IT SUCH
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
    /**MAYBE TAIL RECURSIVE?
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
            return new BigInteger[]{temp[0].add(temp[1]).add(temp[2]), temp[0], temp[1]};
        }
    }
    public static BigInteger[] wrapperOddonaci(int n){
        return tailLinearOddonaci(n, new BigInteger[]{BigInteger.ONE, BigInteger.ONE, BigInteger.ONE});
        //return tailLinearOddonaci(n,BigInteger.valueOf(1),BigInteger.valueOf(1),BigInteger.valueOf(1));
    }
    public static BigInteger[] tailLinearOddonaci(int n, BigInteger a, BigInteger b, BigInteger c){
        if (n <= 3)
            return new BigInteger[]{a, b, c};
        else{
            return tailLinearOddonaci(n-1,a.add(b).add(c),a, b);
        }
    }
    public static BigInteger[] tailLinearOddonaci(int n, BigInteger[] a){
        if (n <= 3)
            return new BigInteger[]{a[0], a[1], a[2]};
        else{
            return tailLinearOddonaci(n-1,new BigInteger[]{a[0].add(a[1]).add(a[2]), a[0], a[1]});
        }
    }
}
